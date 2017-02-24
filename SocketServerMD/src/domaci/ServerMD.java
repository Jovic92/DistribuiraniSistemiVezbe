package domaci;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ServerMD {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket serverSocket = null;
        int count=0;
		try {
			serverSocket = new ServerSocket(10007);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 10007.");
			System.exit(1);
		}

		Socket clientSocket = null;
		System.out.println("Waiting for connection.....");

		try {
			clientSocket = serverSocket.accept();
			System.out.println("Client from "+clientSocket.getInetAddress().getHostAddress()+" connected");
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		System.out.println("Connection successful");
		System.out.println("Waiting for input.....");
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		// DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		/*InputStream ins = clientSocket.getInputStream();
		ObjectInputStream in = new ObjectInputStream(ins);*/
		String inputLine;
		//File jsonFromClient;
		String pom="";
		boolean ok=true;
		while ((inputLine = in.readLine()) != null) {
			if(inputLine.equals("KRAJ")){
				try{
					ObjectMapper mapper = new ObjectMapper();
					String jsonString=null;
					Student student = mapper.readValue(pom, Student.class);
				    mapper.enable(SerializationFeature.INDENT_OUTPUT);
				    jsonString = mapper.writeValueAsString(student);
				    System.out.println("Client says: " + jsonString);
					}catch (Exception e) { 
				        e.printStackTrace(); 
				    }
						try{
							ObjectMapper mapper = new ObjectMapper();
							String jsonString=null;
						Raspored raspored = mapper.readValue(new File("raspored.json"), Raspored.class);
						mapper.enable(SerializationFeature.INDENT_OUTPUT);
				        jsonString = mapper.writeValueAsString(raspored);
				        System.out.println("Json kod servera :"+jsonString);
						//System.out.print("input: ");
					   //userInput=scan.nextLine();
				       // File file2=new File("raspored.json");
							out.println(jsonString);
							out.println("KRAJSERVER");
						}catch (Exception e) { 
					        e.printStackTrace(); 
					        System.out.println("greska u mapperu!");
					    }
			}
			pom=pom+inputLine;
		}
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}


}
