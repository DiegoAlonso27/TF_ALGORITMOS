package Grafos;

import java.util.*;

public class GrafoActores {

    private Map<String, List<String>> grafo; // Mapa de actores a películas

    public GrafoActores() {
        grafo = new HashMap<>();
    }

    public void agregarRelacion(String actor, String pelicula) {
        // Agrega una relación actor - película
        if (!grafo.containsKey(actor)) {
            grafo.put(actor, new ArrayList<>());
        }
        grafo.get(actor).add(pelicula);
    }

    public List<String> obtenerPeliculas(String actor) {
        // Obtiene las películas en las que ha participado un actor
        return grafo.getOrDefault(actor, new ArrayList<>());
    }

    public boolean contieneActor(String actor) {
        // Verifica si el grafo contiene el actor dado
        return grafo.containsKey(actor);
    }

}




