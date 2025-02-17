package juanrav.fit_zone.service;

import juanrav.fit_zone.model.Client;
import juanrav.fit_zone.respository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService implements IClientService{

    //DEPENDENCY INJECTION
    //We will need the repository in service layer
    @Autowired
    private ClientRepository clientRepository; //It creates an instance of the type of class we specified

    @Override
    public List<Client> getClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public Client searchClientByID(Integer clientID) {
        Client clientFound = clientRepository.findById(clientID).orElse(null);
        return clientFound;
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client); //If ID==null : insert ? update
        System.out.println("Client Saved Successfully");
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }
}
