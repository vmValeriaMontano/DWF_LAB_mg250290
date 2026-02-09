package sv.edu.udb.repository.domain;

import lombok.*;

@Getter //Basi getter methods
@Setter //Basic setter methods
@Builder //Patter desing
@NoArgsConstructor //Default constructor
@AllArgsConstructor //All atribute constructor

//Base de el proyecto
public class Movie {
    private Long id;
    private String name;
    private String type;
    private Integer releaseYear;
}
