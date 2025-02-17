package juanrav.fit_zone.service;

import juanrav.fit_zone.model.Client;
import java.util.List;

public interface IClientService {
    public List<Client> getClients();
    public Client searchClientByID(Client client);
    public void saveClient(Client client);
    public void deleteClient(Client client);
}
