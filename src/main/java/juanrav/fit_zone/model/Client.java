package juanrav.fit_zone.model;

import jakarta.persistence.*;
import lombok.*;

//Entity Class
@Entity
@Table(name = "client")
@Data //Generate Get and Set methods
@NoArgsConstructor //Empty Constructor
@AllArgsConstructor // Constructor with ALL arguments
@ToString //To string method
@EqualsAndHashCode //Equals and Hash code methods
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //We are working with null values, It's easier for JPA to know when the pk has a balue or not

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "membership")
    private Integer membership;
}
