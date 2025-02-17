package juanrav.fit_zone.respository;

import juanrav.fit_zone.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA REPOSITORY gets 2 parameters:
    //1.-Type of class we are working on
    //2.-Type of PK
public interface ClientRepository  extends JpaRepository<Client, Integer> { }
