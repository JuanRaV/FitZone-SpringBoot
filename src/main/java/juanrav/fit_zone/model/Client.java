package juanrav.fit_zone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

//Identity Class
@Entity
@Data //Generate Get and Set methods
@NoArgsConstructor //Empty Constructor
@AllArgsConstructor // Constructor with ALL arguments
@ToString //To string method
@EqualsAndHashCode //Equals and Hash code methods
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //We are working with null values, It's easier for JPA to know when the pk has a balue or not
    private String firstName;
    private String lastName;
    private Integer membership;
}
