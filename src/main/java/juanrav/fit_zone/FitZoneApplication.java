package juanrav.fit_zone;

import juanrav.fit_zone.model.Client;
import juanrav.fit_zone.service.IClientService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

//import java.util.logging.Logger;

@SpringBootApplication
public class FitZoneApplication implements CommandLineRunner {

	//Inject IClientService dependency
	@Autowired
	private IClientService clientService;

	//Logger-login variable
	private static final Logger logger = LoggerFactory.getLogger(FitZoneApplication.class);

	private String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("STARTING APP");
		//Factory needs to be up and ready
		SpringApplication.run(FitZoneApplication.class, args);
		logger.info("FINISHING APP");
	}

	@Override
	public void run(String... args) throws Exception {
		fitZoneApp();
	}

	private void fitZoneApp(){
		var exit = false;
		var console = new Scanner(System.in);
		while(!exit){
			var option = showMenu(console);
			exit = excecuteOptions(console, option);
			logger.info(nl);
		}
	}

	private int showMenu(Scanner console){
		logger.info(nl + """
				*** FIT ZONE APP GYM ***
				1.- Get all clients
				2.- Search client
				3.- Add client
				4.- Modify client
				5.- Delete client
				6.- Exit
				Choose an option: \s""");
		return Integer.parseInt(console.nextLine());
	}
	private boolean excecuteOptions(Scanner console, int option){
		var exit = false;
		switch (option){
			case 1->{
				logger.info(nl + "---CLIENTS LIST---" + nl);
				List<Client> clients = clientService.getClients();
				clients.forEach(client->logger.info(client.toString() + nl));
			}
			case 2->{
				logger.info(nl+"---SEARCH CLIENT BY ID---" + nl);
				logger.info("Write Client ID: " );
				var clientID = Integer.parseInt(console.nextLine());
				Client client = clientService.searchClientByID(clientID);
				if(client!=null)
					logger.info("Client found: "+ client + nl);
				else
					logger.info("Client not found with ID: " + clientID + nl);
			}
			case 3 ->{
				logger.info(nl+ "---ADD CLIENT ---" + nl);
				logger.info("First Name: ");
				var name = console.nextLine();
				logger.info("Last Name: ");
				var lastName = console.nextLine();
				logger.info("Membership: ");
				var membership = Integer.parseInt(console.nextLine());

				var client = new Client();
				client.setFirstName(name);
				client.setLastName(lastName);
				client.setMembership(membership);
				clientService.saveClient(client);
				logger.info("CLIENT ADDED SUCCESSFULLY: " + client + nl);
			}

			case 4->{
				logger.info("---EDIT CLIENT---" + nl);
				logger.info("Clients ID: ");
				int id = Integer.parseInt(console.nextLine());
				Client clientFound = clientService.searchClientByID(id);
				if(clientFound!=null){
					logger.info("First Name: ");
					var name = console.nextLine();
					logger.info("Last Name: ");
					var lastName = console.nextLine();
					logger.info("Membership: ");
					var membership = Integer.parseInt(console.nextLine());
					clientFound.setLastName(name);
					clientFound.setLastName(lastName);
					clientFound.setMembership(membership);
					clientService.saveClient(clientFound);
					logger.info("Client Updated Successfully");
				}else{
					logger.info("Client not found");
				}
			}
			case 5->{
				logger.info("---DELETE CLIENT---" + nl);
				logger.info("Clients ID: ");
				int id = Integer.parseInt(console.nextLine());
				Client clientFound = clientService.searchClientByID(id);
				if(clientFound!=null){
					clientService.deleteClient(clientFound);
					logger.info("Client Deleted Successfully: " + clientFound + nl);
				}else{
					logger.info("Client Not Found");
				}
			}
			case 6->{
				logger.info("THANKS FOR USING FIT ZONE APP"+ nl + nl);
				exit=true;
			}
			default -> logger.info("Option not valid");
		}
		return exit;
	}
}
