package es.deusto.ingenieria.sd.server.data.dto;

import java.io.Serializable;

public class FlightInfoDTO implements Serializable {

	private static final long serialVersionUID = 4L;
	private String flightNumber;
	private String timeDeparture;
	private String timeArrival;
	private int totalSeats;
	private int availableSeats;
	private String airportDepart;
	private String airportArriv;
	private String Airline;
	
	public FlightInfoDTO(String flightNumber, String timeDeparture, String timeArrival, int totalSeats,
			int availableSeats, String airportDepart, String airportArriv, String airline) {
	
		this.flightNumber = flightNumber;
		this.Airline = airline;
		this.setTimeDeparture(timeDeparture);
		this.setTimeArrival(timeArrival);
		this.setTotalSeats(totalSeats);
		this.setAvailableSeats(availableSeats);
		this.setAirportDepart(airportDepart);
		this.setAirportArriv(airportArriv);
		
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getTimeDeparture() {
		return timeDeparture;
	}
	public void setTimeDeparture(String timeDeparture) {
		this.timeDeparture = timeDeparture;
	}
	public String getTimeArrival() {
		return timeArrival;
	}
	public void setTimeArrival(String timeArrival) {
		this.timeArrival = timeArrival;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public String getAirportDepart() {
		return airportDepart;
	}
	public void setAirportDepart(String airportDepart) {
		this.airportDepart = airportDepart;
	}
	public String getAirportArriv() {
		return airportArriv;
	}
	public void setAirportArriv(String airportArriv) {
		this.airportArriv = airportArriv;
	}
	
	public String getAirline() {
		return Airline;
	}
	
	public void setAirline(String airline) {
		this.Airline = airline;
	}
	
	


}