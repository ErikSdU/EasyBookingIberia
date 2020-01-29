package es.deusto.ingenieria.sd.server.data.dto;

public class PassengerDTO {
	private static final long serialVersionUID = 1L;
	private String username;
	private String name;

    public PassengerDTO(String username, String name) {
		this.username = username;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Passenger [username=" + username + ", name=" + name + "]";
	}

	
}
