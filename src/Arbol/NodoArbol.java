package Arbol;

import Class.Peliculas;

public class NodoArbol {

    Peliculas pelicula;
    NodoArbol izquierdo;
    NodoArbol derecho;

    public NodoArbol(Peliculas pelicula) {
        this.pelicula = pelicula;
        this.izquierdo = null;
        this.derecho = null;
    }
}
