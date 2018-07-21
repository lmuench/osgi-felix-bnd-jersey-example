package agenda.rest;

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
	@Produces(MediaType.TEXT_PLAIN)
	public String listConferences() {
		List<Conference> conferences = agenda.listConferences();
		
		String res = "";
		
		if (conferences != null) {			
			for (Conference conference : conferences) {
				System.out.println(conference.getName());
				res += conference.getName() + " ";
			}
		} else {
			System.out.println("Agenda not available");
			res += "There are no conferences.";
		}
		
		return res;
	}
	
	public void addConference(String name, String location) {

		agenda.addConference(new Conference(name, location));
	}
}
