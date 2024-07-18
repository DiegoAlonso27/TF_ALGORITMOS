package Arbol;

import Class.Peliculas;
import java.util.LinkedList;

public class ArbolBinarioBusqueda {

    private NodoArbol raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public void insertar(Peliculas pelicula) {
        raiz = insertarRecursivo(raiz, pelicula);
    }

    private NodoArbol insertarRecursivo(NodoArbol raiz, Peliculas pelicula) {
        if (raiz == null) {
            raiz = new NodoArbol(pelicula);
            return raiz;
        }

        if (pelicula.getNombre().compareTo(raiz.pelicula.getNombre()) < 0) {
            raiz.izquierdo = insertarRecursivo(raiz.izquierdo, pelicula);
        } else if (pelicula.getNombre().compareTo(raiz.pelicula.getNombre()) > 0) {
            raiz.derecho = insertarRecursivo(raiz.derecho, pelicula);
        }

        return raiz;
    }

    public LinkedList<Peliculas> buscar(String nombre) {
        LinkedList<Peliculas> resultados = new LinkedList<>();
        buscarRecursivo(raiz, nombre, resultados);
        return resultados;
    }

    private void buscarRecursivo(NodoArbol raiz, String nombre, LinkedList<Peliculas> resultados) {
        if (raiz != null) {
            if (nombre.equalsIgnoreCase(raiz.pelicula.getNombre())) {
                resultados.add(raiz.pelicula);
            }

            buscarRecursivo(raiz.izquierdo, nombre, resultados);
            buscarRecursivo(raiz.derecho, nombre, resultados);
        }
    }
}
