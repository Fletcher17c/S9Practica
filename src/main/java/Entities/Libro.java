package Entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "libros")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "libros",
                query = "select l from Libro l"
        )
})
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    private int añoPub;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}