package run;

import services.dao.MyDao;
import services.interfaces.ICRUD;

import Entities.Autor;
import Entities.Libro;
import Entities.Categoria;

import java.util.List;

public class Main {

    public static final ICRUD dao = new MyDao();

    public static void insertarAutor() {
        Autor a = new Autor();
        a.setNombre("Gabriel Garcia Marquez");
        a.setNacionalidad("Mexicana");
        dao.insert(a);

        Autor r = new Autor();
        r.setNombre("Ruben Dario");
        r.setNacionalidad("Nicaraguense");
        dao.insert(r);
    }

    public static void listarAutores() {
        System.out.println("Registro Almacenados:");
        List<Autor> autores = dao.getAll("autores.All", Autor.class);
        autores.forEach(autor -> System.out.println(autor.getNombre()));
    }

    public static void editarAutor() {
        Autor a = new Autor();
        a = dao.findById(1, Autor.class);
        a.setNacionalidad("Colombiana");
        dao.update(a);
    }

    public static void eliminarAutor() {
        Autor a = new Autor();
        a = dao.findById(2, Autor.class);
        dao.delete(a);
    }


    public static void insertarCategoria() {
        Categoria c1 = new Categoria();
        c1.setNombre("Novela");
        dao.insert(c1);

        Categoria c2 = new Categoria();
        c2.setNombre("Poesía");
        dao.insert(c2);
    }

    public static void listarCategorias() {
        System.out.println("Categorías registradas:");
        List<Categoria> categorias = dao.getAll("categorias.All", Categoria.class);
        categorias.forEach(c -> System.out.println(c.getId() + " - " + c.getNombre()));
    }

    public static void editarCategoria() {
        Categoria c = dao.findById(1, Categoria.class);
        c.setNombre("Novela Histórica");
        dao.update(c);
    }

    public static void eliminarCategoria() {
        Categoria c = dao.findById(2, Categoria.class);
        dao.delete(c);
    }

    public static void insertarLibro() {
        Libro l1 = new Libro();
        l1.setTitulo("Cien años de soledad");
        l1.setAñoPub(1967);
        l1.setAutor(dao.findById(1, Autor.class));        // Autor existente
        l1.setCategoria(dao.findById(1, Categoria.class)); // Categoría existente
        dao.insert(l1);

        Libro l2 = new Libro();
        l2.setTitulo("Azul...");
        l2.setAñoPub(1888);
        l2.setAutor(dao.findById(2, Autor.class));
        l2.setCategoria(dao.findById(2, Categoria.class));
        dao.insert(l2);
    }

    public static void listarLibros() {
        System.out.println("Libros registrados:");
        List<Libro> libros = dao.getAll("libros", Libro.class);
        libros.forEach(l -> System.out.printf(
                "ID: %d | Título: %s | Año: %d | Autor: %s | Categoría: %s%n",
                l.getId(),
                l.getTitulo(),
                l.getAñoPub(),
                (l.getAutor() != null ? l.getAutor().getNombre() : "Sin autor"),
                (l.getCategoria() != null ? l.getCategoria().getNombre() : "Sin categoría")
        ));
    }

    public static void editarLibro() {
        Libro l = dao.findById(1, Libro.class);
        l.setTitulo("Cien años de soledad (Edición revisada)");
        l.setAñoPub(1970);
        dao.update(l);
    }

    public static void eliminarLibro() {
        Libro l = dao.findById(2, Libro.class);
        dao.delete(l);
    }

    public static void main(String[] args) {
        System.out.println("===== AUTORES =====");
        insertarAutor();
        listarAutores();
        editarAutor();
        listarAutores();
        //eliminarAutor();
        listarAutores();

        // === CATEGORÍAS ===
        System.out.println("\n===== CATEGORÍAS =====");
        insertarCategoria();
        listarCategorias();
        editarCategoria();
        listarCategorias();
       // eliminarCategoria();
        listarCategorias();

        // === LIBROS ===
        System.out.println("\n===== LIBROS =====");
        insertarLibro();
        listarLibros();
        editarLibro();
        listarLibros();
        //eliminarLibro();
        listarLibros();
    }
}