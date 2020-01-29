package es.deusto.ingenieria.sd.server.data.IberiaServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.deusto.ingenieria.sd.server.data.dto.*;

public class IberiaService extends Thread {
	private DataOutputStream out;
	private Socket tcpSocket;
	
	private List<FlightInfoDTO> flights = Arrays.asList(new FlightInfoDTO("1", "01012020", "01012020", 180 , 32, "Bilbao", "Malta", "Iberia"), 
			new FlightInfoDTO("2", "01012020", "01012020", 150, 89, "Bilbao", "Malta", "Iberia"),
			new FlightInfoDTO("3", "07012020", "07012020", 130, 57, "Bilbao", "Malta", "Iberia"),
			new FlightInfoDTO("4", "01022020", "01022020", 200, 36, "Bilbao", "Paris", "Iberia"),
			new FlightInfoDTO("5", "11012020", "12012020", 200, 45, "Paris", "Moscu", "Iberia"));
	private List<UserDTO> users = Arrays.asList(new UserDTO("kevin@gmail.com", "3333" ,"kevin", "kevvin", "bilbao"),
			new UserDTO("erik@gmail.com", "1111", "erik", "erik","bilbao"),
			new UserDTO("viola@gmail.com", "0000", "viola", "viola","bilbao"), new UserDTO("ruben@gmail.com", "1234", "ruben", "ruben","bilbao"));
	private List<ReservationDTO> reser = Arrays.asList();

	public IberiaService(Socket socket) {
		System.out.println(socket.toString());
		try {
			this.tcpSocket = socket;
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# IberiaService - TCPConnection IO error:" + e.getMessage());
		}
	}

	public void run() {
		try {
			System.out.println("run in iberia service");
			//String data = this.in.readUTF();
			//System.out.println("   - IberiaService - Received data from '"
			//		+ tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			String finalList = "";
			
			for (int i = 0; i < flights.size(); i++) {
				if(i<flights.size()-1) {
					finalList += flights.get(i) + "//";
				}else {
					finalList += flights.get(i);
				}
			}
			
			
			this.out.writeUTF(finalList);
			System.out.println("   - IberiaService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + finalList.toUpperCase() + "'");
		} catch (EOFException e) {
			System.err.println("   # IberiaService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println("   # IberiaService - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println("   # IberiaService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}

	public List<FlightInfoDTO> getFlight(String airportDep, String airportArrivalCode, String departureDate,
			int numPeople) {
		System.out.println("getFlighsxxx");
		List<FlightInfoDTO> retFlights = new ArrayList<FlightInfoDTO>();
		for (int i = 0; 0 < flights.size(); i++) {
			if (flights.get(i).getAirportDepart().equals(airportDep)) {
				if (flights.get(i).getAirportArriv().equals(airportArrivalCode)) {
					if (flights.get(i).getTimeDeparture().equals(departureDate)) {
						retFlights.add(flights.get(i));
					}
				}
			}
		}
		return retFlights;
	}

	public boolean notifyAirline(FlightInfoDTO flight, UserDTO user, List<PassengerDTO> listPassengers)
			throws RemoteException {
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).equals(flight)) {
				for (int j = 0; j < users.size(); j++) {
					if (users.get(j).equals(user)) {
						int numberSeat = listPassengers.size() + 1;
						String id = "" + ((int)(Math.random()*99999999+10000000));
						reser.add(new ReservationDTO(id, numberSeat, user, flight));
					}
				}
			}
		}

		return false;
	}

	

}
