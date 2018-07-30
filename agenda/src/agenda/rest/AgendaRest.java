package agenda.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import agenda.api.Agenda;
import agenda.api.Conference;


@Path("agenda")
public class AgendaRest {
	private volatile Agenda agenda;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> listConferences() {
		List<Conference> conferences = agenda.listConferences();
		
		List<String> res = new ArrayList<>();
		
		if (conferences != null) {			
			for (Conference conference : conferences) {
				System.out.println(conference.getName());
				res.add(conference.getName());
			}
		} else {
			System.out.println("Agenda not available");
		}
		
		return res;
	}
	
	public void addConference(String name, String location) {

		agenda.addConference(new Conference(name, location));
	}
}
