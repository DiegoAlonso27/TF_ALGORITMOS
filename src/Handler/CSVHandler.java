/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handler;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

/**
 *
 * @author diego
 */

public class CSVHandler<T> {
    private String csvFile;
    private Class<T> type;

    public CSVHandler(String csvFileName, Class<T> type) {
        this.type = type;
        this.csvFile = getProjectPath() + File.separator + "bd" + File.separator + csvFileName;
        ensureDirectoryExists();
    }

    private String getProjectPath() {
        return System.getProperty("user.dir");
    }

    private void ensureDirectoryExists() {
        File directory = new File(getProjectPath() + File.separator + "bd");
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public void guardar(List<T> items) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            for (T item : items) {
                writer.println(convertToCSV(item));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> cargar() {
        List<T> items = new ArrayList<>();
        File file = new File(csvFile);
      
        if (!file.exists() || !file.canRead()) {
            System.err.println("El archivo no existe o no se puede leer: " + csvFile);
            return items;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                items.add(convertFromCSV(line));
            }
        } catch (IOException e) {
            System.err.println("Error de E/S al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        } catch (ReflectiveOperationException e) {
            System.err.println("Error de reflexión al convertir la línea CSV: " + e.getMessage());
            e.printStackTrace();
        }

        return items;
    }

    private String convertToCSV(T item) {
        StringBuilder sb = new StringBuilder();
        for (Field field : item.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                sb.append(field.get(item)).append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private T convertFromCSV(String csv) throws ReflectiveOperationException {
        T item = type.getDeclaredConstructor().newInstance();
        String[] values = csv.split(",");
        Field[] fields = type.getDeclaredFields();
        
        if (values.length != fields.length) {
            throw new IllegalArgumentException("El número de valores en el CSV no coincide con el número de campos en la clase");
        }
    
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            setFieldValue(fields[i], item, values[i]);
        }
        return item;
    }

    private void setFieldValue(Field field, T item, String value) throws IllegalAccessException {
        // Manejo básico de tipos. Agrega más casos según sea necesario.
        if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
            field.set(item, Integer.parseInt(value));
        } else if (field.getType().equals(double.class) || field.getType().equals(Double.class)) {
            field.set(item, Double.parseDouble(value));
        } else if (field.getType().equals(String.class)) {
            field.set(item, value);
        } else {
            throw new IllegalArgumentException("Tipo de campo no soportado: " + field.getType().getName());
        }
    }
}