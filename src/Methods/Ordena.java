package Methods;

import Class.Actores;
import Class.Peliculas;
import Class.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Ordena {

    // Método para ordenar películas por nombre
    public static void ordenarPeliculasPorNombre(LinkedList<Peliculas> peliculas) {
        peliculas.sort((p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()));
    }

    // Método para ordenar películas por fecha de estreno utilizando Quick Sort
    public static void ordenarPeliculasPorFechaEstreno(LinkedList<Peliculas> peliculas) {
        quickSort(peliculas, 0, peliculas.size() - 1);
    }

    // Método para ordenar películas por mayor recaudación utilizando Merge Sort
    public static void ordenarPeliculasPorMayorRecaudacion(LinkedList<Peliculas> peliculas) {
        mergeSort(peliculas, 0, peliculas.size() - 1);
    }

    // Método privado para realizar Quick Sort
    private static void quickSort(LinkedList<Peliculas> lista, int low, int high) {
        if (low < high) {
            int pi = partition(lista, low, high);
            quickSort(lista, low, pi - 1);
            quickSort(lista, pi + 1, high);
        }
    }

    // Método privado para realizar la partición en Quick Sort
    private static int partition(LinkedList<Peliculas> lista, int low, int high) {
        Peliculas pivot = lista.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (lista.get(j).getFecheEstreno().after(pivot.getFecheEstreno())) {
                i++;
                Peliculas temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }
        Peliculas temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);
        return i + 1;
    }

    // Método privado para realizar Merge Sort
    private static void mergeSort(LinkedList<Peliculas> lista, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(lista, left, mid);
            mergeSort(lista, mid + 1, right);
            merge(lista, left, mid, right);
        }
    }

    // Método privado para combinar las listas en Merge Sort
    private static void merge(LinkedList<Peliculas> lista, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        LinkedList<Peliculas> L = new LinkedList<>();
        LinkedList<Peliculas> R = new LinkedList<>();

        for (int i = 0; i < n1; ++i) {
            L.add(lista.get(left + i));
        }
        for (int j = 0; j < n2; ++j) {
            R.add(lista.get(mid + 1 + j));
        }

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L.get(i).getTotalRecaudado() >= R.get(j).getTotalRecaudado()) {
                lista.set(k, L.get(i));
                i++;
            } else {
                lista.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            lista.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            lista.set(k, R.get(j));
            j++;
            k++;
        }
    }

    //Metodos para ordenar Actores por alfabeto
    public static void ordenarActoresPorNombre(LinkedList<Actores> actores) {
        actores.sort((p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()));
    }

    //Metodo Borbuja para ordenar por edad
    public static void ordenarActoresPorEdadBurbuja(LinkedList<Actores> actores) {
        int n = actores.size();
        boolean intercambiado;
        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (actores.get(j).getEdad() > actores.get(j + 1).getEdad()) {
                    // Intercambiar actores[j] con actores[j+1]
                    Actores temp = actores.get(j);
                    actores.set(j, actores.get(j + 1));
                    actores.set(j + 1, temp);
                    intercambiado = true;
                }
            }
            if (!intercambiado) {
                break;
            }
        }
    }

    // Método para ordenar usuarios por correo de manera alfabética utilizando selección
    public static void ordenarUsuariosPorCorreoSeleccion(LinkedList<Usuario> usuarios) {
        int n = usuarios.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (usuarios.get(j).getCorreo().compareToIgnoreCase(usuarios.get(minIndex).getCorreo()) < 0) {
                    minIndex = j;
                }
            }
            // Intercambiar usuarios[i] con usuarios[minIndex]
            Usuario temp = usuarios.get(minIndex);
            usuarios.set(minIndex, usuarios.get(i));
            usuarios.set(i, temp);
        }
    }

    public static void ordenarAlfabeticamente(DefaultTableModel dt) {
        List<Object[]> rows = new ArrayList<>();
        for (int i = 0; i < dt.getRowCount(); i++) {
            Object[] row = new Object[dt.getColumnCount()];
            for (int j = 0; j < dt.getColumnCount(); j++) {
                row[j] = dt.getValueAt(i, j);
            }
            rows.add(row);
        }

        Collections.sort(rows, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] row1, Object[] row2) {
                return row1[0].toString().compareToIgnoreCase(row2[0].toString());
            }
        });

        dt.setRowCount(0);
        for (Object[] row : rows) {
            dt.addRow(row);
        }
    }

    public static void ordenarPorFechaEstreno(DefaultTableModel dt) {
        List<Object[]> rows = new ArrayList<>();
        for (int i = 0; i < dt.getRowCount(); i++) {
            Object[] row = new Object[dt.getColumnCount()];
            for (int j = 0; j < dt.getColumnCount(); j++) {
                row[j] = dt.getValueAt(i, j);
            }
            rows.add(row);
        }

        Collections.sort(rows, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] row1, Object[] row2) {
                return row2[3].toString().compareTo(row1[3].toString()); // Asumiendo que la fecha está en formato YYYY-MM-DD
            }
        });

        dt.setRowCount(0);
        for (Object[] row : rows) {
            dt.addRow(row);
        }
    }

}
