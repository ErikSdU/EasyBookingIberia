package es.deusto.ingenieria.sd.server.data.dto;

import java.io.Serializable;


public class ReservationDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String code;
	private int price;
	private UserDTO user;
	private FlightInfoDTO flight;
	
	public ReservationDTO(String code, int price, UserDTO user, FlightInfoDTO flight) {
		super();
		this.code = code;
		this.price = price;
		this.user = user;
		this.flight = flight;
	}


	@Override
	public String toString() {
		return "ReservationDTO [code=" + code + ", price=" + price + ", user=" + user + ", flights=" + flight + "]";
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	public FlightInfoDTO getFlight() {
		return flight;
	}


	public void setFlights(FlightInfoDTO flight) {
		this.flight = flight;
	}
	
	
}
