/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Class.Usuario;
import Handler.CSVHandler;
import java.util.List;

/**
 *
 * @author diego
 */
public class UsuarioService {

    private List<Usuario> usuarios;
    private CSVHandler<Usuario> csvHandler;
    private int currentId;

    public UsuarioService() {
        csvHandler = new CSVHandler<>("usuarios.csv", Usuario.class);
        usuarios = csvHandler.cargar();
        currentId = calcularCurrentId();

        //validamos si se cargaron los usuarios si el archivo esta vacio o no existe mostramos un mensaje
        if (usuarios.isEmpty()) {
            //Mostramos un mensaje en consola
            System.out.println("No se encontraron usuarios registrados");
        }
    }

    private int calcularCurrentId() {
        return usuarios.stream().mapToInt(Usuario::getId).max().orElse(0) + 1;
    }

    public void agregarUsuario(String nombre, String email, String contraseña) {
        Usuario usuario = new Usuario(currentId++, nombre, email, contraseña);
        usuarios.add(usuario);
        csvHandler.guardar(usuarios);
    }

    public void editarUsuario(int id, String nuevoNombre, String nuevoEmail, String nuevaContraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuario.setUsuario(nuevoNombre);
                usuario.setCorreo(nuevoEmail);
                usuario.setContraseña(nuevaContraseña);
                csvHandler.guardar(usuarios);
                break;
            }
        }
    }

    public void eliminarUsuario(int id) {
        usuarios.removeIf(usuario -> usuario.getId() == id);
        csvHandler.guardar(usuarios);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean validarCredenciales(String nombreUsuario, String contraseña) {
        System.out.println("Validando: " + nombreUsuario + " " + contraseña);
        boolean resultado = usuarios.stream().anyMatch(usuario -> usuario.getUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña));
        // imprimo la lista de usuarios
        usuarios.forEach(usuario -> System.out.println(usuario.getUsuario() + " " + usuario.getContraseña()));
        System.out.println("Resultado: " + resultado);
        return resultado;
    }

}
