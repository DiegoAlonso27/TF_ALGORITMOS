/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Arbol.ArbolBinarioBusqueda;
import Class.Peliculas;
import java.util.List;

/**
 *
 * @author diego
 */
public class PeliculaService {
    private ArbolBinarioBusqueda<Peliculas> arbolPeliculas;
    
    public PeliculaService() {
        arbolPeliculas = new ArbolBinarioBusqueda<>();
    }
    
    public void agregarPelicula(Peliculas pelicula) {
        arbolPeliculas.insertar(pelicula);
    }

    public void editarPelicula(Peliculas pelicula) {
        Peliculas peliculaExistente = arbolPeliculas.buscar(pelicula.getId());
        if (peliculaExistente != null) {
            peliculaExistente.setTitulo(pelicula.getTitulo());
            peliculaExistente.setDirector(pelicula.getDirector());
            peliculaExistente.setGenero(pelicula.getGenero());
            // Actualiza otros campos necesarios
        }
    }

    public void eliminarPelicula(int id) {
        arbolPeliculas.eliminar(id);
    }

    public List<Peliculas> obtenerPeliculas() {
        return arbolPeliculas.recorrerInOrden();
    }
}
