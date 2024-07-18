package Methods;

import Class.Actores;
import Class.Busqueda;
import Class.Peliculas;
import Class.Usuario;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

public class Busca {

    // Métodos para buscar películas
    // Realiza una búsqueda lineal de películas por nombre
    public static LinkedList<Peliculas> buscarPeliculasPorNombreLineal(LinkedList<Peliculas> listaPeliculas, Busqueda busqueda) {
        LinkedList<Peliculas> resultados = new LinkedList<>();
        // Itera sobre la lista de películas
        for (Peliculas pelicula : listaPeliculas) {
            // Comprueba si el nombre de la película contiene el término de búsqueda (ignorando mayúsculas y minúsculas)
            if (pelicula.getNombre().toLowerCase().contains(busqueda.getNombreBus().toLowerCase())) {
                resultados.add(pelicula); // Si se encuentra coincidencia, se agrega a los resultados
            }
        }
        return resultados; // Devuelve la lista de películas que coinciden con la búsqueda
    }

    // Realiza una búsqueda binaria recursiva de películas por nombre
    public static LinkedList<Peliculas> buscarPeliculasBinarioRecursivo(LinkedList<Peliculas> listaPeliculas, Busqueda busqueda) {
        // Lista para almacenar los resultados de la búsqueda
        LinkedList<Peliculas> resultados = new LinkedList<>();

        // Convertir el término de búsqueda a minúsculas para una búsqueda insensible a mayúsculas y minúsculas
        String nombreBusqueda = busqueda.getNombreBus().toLowerCase();

        // Llamar al método auxiliar recursivo para realizar la búsqueda binaria
        buscarBinarioRecursivo(listaPeliculas, nombreBusqueda, 0, listaPeliculas.size() - 1, resultados);

        // Devolver la lista de resultados encontrados
        return resultados;
    }

// Método auxiliar recursivo para búsqueda binaria de películas por nombre
    private static void buscarBinarioRecursivo(LinkedList<Peliculas> listaPeliculas, String nombreBusqueda, int low, int high, LinkedList<Peliculas> resultados) {
        // Caso base: si low es mayor que high, terminar la recursión
        if (low <= high) {
            // Calcular el índice medio
            int mid = (low + high) / 2;

            // Obtener la película en el índice medio
            Peliculas pelicula = listaPeliculas.get(mid);

            // Obtener el nombre de la película en minúsculas para comparación insensible a mayúsculas y minúsculas
            String nombrePelicula = pelicula.getNombre().toLowerCase();

            // Realizar la comparación para determinar si encontramos la película que contiene el término de búsqueda
            if (nombrePelicula.contains(nombreBusqueda) && !resultados.contains(pelicula)) {
                // Agregar la película a los resultados si cumple con el criterio de búsqueda y no está ya en la lista de resultados
                resultados.add(pelicula);
            }

            // Búsqueda hacia la izquierda para encontrar más coincidencias
            int left = mid - 1;
            while (left >= 0 && listaPeliculas.get(left).getNombre().toLowerCase().contains(nombreBusqueda)) {
                // Agregar la película a los resultados si cumple con el criterio de búsqueda y no está ya en la lista de resultados
                if (!resultados.contains(listaPeliculas.get(left))) {
                    resultados.add(listaPeliculas.get(left));
                }
                left--;
            }

            // Búsqueda hacia la derecha para encontrar más coincidencias
            int right = mid + 1;
            while (right < listaPeliculas.size() && listaPeliculas.get(right).getNombre().toLowerCase().contains(nombreBusqueda)) {
                // Agregar la película a los resultados si cumple con el criterio de búsqueda y no está ya en la lista de resultados
                if (!resultados.contains(listaPeliculas.get(right))) {
                    resultados.add(listaPeliculas.get(right));
                }
                right++;
            }

            // Llamadas recursivas para las mitades restantes de la lista
            buscarBinarioRecursivo(listaPeliculas, nombreBusqueda, low, mid - 1, resultados); // Búsqueda en la mitad izquierda
            buscarBinarioRecursivo(listaPeliculas, nombreBusqueda, mid + 1, high, resultados); // Búsqueda en la mitad derecha
        }
    }

    //==============================================================================================================================
    // Métodos para buscar actores
    // Realiza una búsqueda lineal de actores por nombre
    public static LinkedList<Actores> buscarActoresPorNombreLineal(LinkedList<Actores> listaActores, Busqueda busqueda) {
        LinkedList<Actores> resultados = new LinkedList<>();
        String nombreBusqueda = busqueda.getNombreBus().toLowerCase();
        // Itera sobre la lista de actores
        for (Actores actor : listaActores) {
            // Comprueba si el nombre del actor contiene el término de búsqueda (ignorando mayúsculas y minúsculas)
            if (actor.getNombre().toLowerCase().contains(nombreBusqueda)) {
                resultados.add(actor); // Si se encuentra coincidencia, se agrega a los resultados
            }
        }
        return resultados; // Devuelve la lista de actores que coinciden con la búsqueda
    }

// Realiza una búsqueda binaria de actores por nombre (la lista debe estar ordenada por nombre)
    public static LinkedList<Actores> buscarActoresPorNombreBinarioRecursivo(LinkedList<Actores> listaActores, Busqueda busqueda) {
        LinkedList<Actores> resultados = new LinkedList<>();
        String nombreBusqueda = busqueda.getNombreBus().toLowerCase();
        int low = 0;
        int high = listaActores.size() - 1;

        buscarActoresPorNombreBinarioRecursivoAux(listaActores, nombreBusqueda, low, high, resultados);

        return resultados;
    }

    private static void buscarActoresPorNombreBinarioRecursivoAux(LinkedList<Actores> listaActores, String nombreBusqueda, int low, int high, LinkedList<Actores> resultados) {
        if (low <= high) {
            int mid = (low + high) / 2;
            Actores actor = listaActores.get(mid);
            int comparison = actor.getNombre().toLowerCase().compareTo(nombreBusqueda);

            if (comparison == 0) {
                // Se encontró un actor con el nombre buscado
                resultados.add(actor);

                // Búsqueda hacia la izquierda para encontrar más coincidencias exactas
                int left = mid - 1;
                while (left >= 0 && listaActores.get(left).getNombre().toLowerCase().equals(nombreBusqueda)) {
                    resultados.add(listaActores.get(left));
                    left--;
                }

                // Búsqueda hacia la derecha para encontrar más coincidencias exactas
                int right = mid + 1;
                while (right < listaActores.size() && listaActores.get(right).getNombre().toLowerCase().equals(nombreBusqueda)) {
                    resultados.add(listaActores.get(right));
                    right++;
                }
            }

            // Llamadas recursivas en base a la comparación
            if (comparison < 0) {
                buscarActoresPorNombreBinarioRecursivoAux(listaActores, nombreBusqueda, mid + 1, high, resultados);
            } else {
                buscarActoresPorNombreBinarioRecursivoAux(listaActores, nombreBusqueda, low, mid - 1, resultados);
            }
        }
    }

    //==============================================================================================================================
    // Realiza una búsqueda lineal de usuarios por nombre de usuario
    public static LinkedList<Usuario> buscarUsuariosPorNombreLineal(LinkedList<Usuario> listaUsuarios, Busqueda busqueda) {
        LinkedList<Usuario> resultados = new LinkedList<>();
        String nombreBusqueda = busqueda.getNombreBus().toLowerCase();
        // Itera sobre la lista de usuarios
        for (Usuario usuario : listaUsuarios) {
            // Comprueba si el nombre de usuario contiene el término de búsqueda (ignorando mayúsculas y minúsculas)
            if (usuario.getUsuario().toLowerCase().contains(nombreBusqueda)) {
                resultados.add(usuario); // Si se encuentra coincidencia, se agrega a los resultados
            }
        }
        return resultados; // Devuelve la lista de usuarios que coinciden con la búsqueda
    }

    // Realiza una búsqueda binaria de usuarios por nombre de usuario (versión recursiva)
    public static LinkedList<Usuario> buscarUsuariosPorNombreBinarioRecursivo(LinkedList<Usuario> listaUsuarios, Busqueda busqueda) {
        LinkedList<Usuario> resultados = new LinkedList<>();
        String nombreBusqueda = busqueda.getNombreBus().toLowerCase(); // Convertir término de búsqueda a minúsculas

        buscarUsuariosPorNombreBinarioRecursivoAux(listaUsuarios, nombreBusqueda, 0, listaUsuarios.size() - 1, resultados);

        return resultados;
    }

// Método auxiliar recursivo para búsqueda binaria de usuarios por nombre de usuario
    private static void buscarUsuariosPorNombreBinarioRecursivoAux(LinkedList<Usuario> listaUsuarios, String nombreBusqueda, int low, int high, LinkedList<Usuario> resultados) {
        if (low <= high) {
            int mid = (low + high) / 2;
            Usuario usuario = listaUsuarios.get(mid);
            String nombreUsuario = usuario.getUsuario().toLowerCase(); // Convertir nombre del usuario a minúsculas

            // Realiza la comparación para determinar si encontramos el usuario
            if (nombreUsuario.contains(nombreBusqueda) && !resultados.contains(usuario)) {
                resultados.add(usuario); // Agrega el usuario si se encuentra y no está en los resultados
            }

            // Búsqueda hacia la izquierda para encontrar más coincidencias
            int left = mid - 1;
            while (left >= 0 && listaUsuarios.get(left).getUsuario().toLowerCase().contains(nombreBusqueda)) {
                if (!resultados.contains(listaUsuarios.get(left))) {
                    resultados.add(listaUsuarios.get(left));
                }
                left--;
            }

            // Búsqueda hacia la derecha para encontrar más coincidencias
            int right = mid + 1;
            while (right < listaUsuarios.size() && listaUsuarios.get(right).getUsuario().toLowerCase().contains(nombreBusqueda)) {
                if (!resultados.contains(listaUsuarios.get(right))) {
                    resultados.add(listaUsuarios.get(right));
                }
                right++;
            }

            // Llamadas recursivas para las mitades restantes
            buscarUsuariosPorNombreBinarioRecursivoAux(listaUsuarios, nombreBusqueda, low, mid - 1, resultados);
            buscarUsuariosPorNombreBinarioRecursivoAux(listaUsuarios, nombreBusqueda, mid + 1, high, resultados);
        }
    }

    //=================================================================================================================
    // Búsqueda lineal
    public int busquedaLineal(DefaultTableModel dt, String nombreBus) {
        for (int i = 0; i < dt.getRowCount(); i++) {
            if (dt.getValueAt(i, 0).toString().equalsIgnoreCase(nombreBus)) {
                return i;
            }
        }
        return -1;
    }

    // Búsqueda binaria recursiva
    public int busquedaBinaria(DefaultTableModel dt, String nombreBus) {
        return busquedaBinariaRecursiva(dt, nombreBus, 0, dt.getRowCount() - 1);
    }

    private int busquedaBinariaRecursiva(DefaultTableModel dt, String nombreBus, int inicio, int fin) {
        if (inicio > fin) {
            return -1;
        }
        int medio = (inicio + fin) / 2;
        String valorMedio = dt.getValueAt(medio, 0).toString();

        if (valorMedio.equalsIgnoreCase(nombreBus)) {
            return medio;
        } else if (valorMedio.compareToIgnoreCase(nombreBus) < 0) {
            return busquedaBinariaRecursiva(dt, nombreBus, medio + 1, fin);
        } else {
            return busquedaBinariaRecursiva(dt, nombreBus, inicio, medio - 1);
        }
    }
}
