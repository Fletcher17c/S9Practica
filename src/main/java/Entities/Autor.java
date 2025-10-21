
package Entities;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "autores")
@Getter
@Setter

@NamedQueries({
        @NamedQuery (name = "autores.All",
                query = "SELECT a FROM Autor a"
        )
})
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_autor", length = 60, nullable = false)
    private String nombre;

    @Column(name="nacionalidad", length = 60, nullable = false)
    private String nacionalidad;

    private LocalDate fechaNac;
}