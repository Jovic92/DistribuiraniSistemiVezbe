package domaci;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



public class ClientMD {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		String serverHostname = new String("127.0.0.1");
		Socket srvSocket = null;
		PrintWriter out = null;
		//ObjectInputStream in = null;
		BufferedReader in=null;
		try {
			srvSocket = new Socket(serverHostname, 10007);
			out = new PrintWriter(srvSocket.getOutputStream(), true);
			in=new BufferedReader(new InputStreamReader(srvSocket.getInputStream()));
			//in =new ObjectInputStream(srvSocket.getInputStream());
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + serverHostname);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: "+ serverHostname);
			System.exit(1);
		}
		System.out.print("input: ");
		String jsonString=null;;
	    try{
	    	ObjectMapper mapper = new ObjectMapper();
	        Student student = mapper.readValue(new File("student.json"), Student.class);
	        mapper.enable(SerializationFeature.INDENT_OUTPUT);
	        jsonString = mapper.writeValueAsString(student);
	        System.out.println("Json kod studenta :"+jsonString);
	    }catch (Exception e) { 
	        e.printStackTrace();
	        System.out.println("greska1");
	    }
	   		//File json = new File("student.json");
			out.println(jsonString);
			out.println("KRAJ");
			/*String serverJSON = null;
			serverJSON = in.readLine();*/
			String inputLine;
			//File jsonFromClient;
			String pom="";
			int brojac=0;
			while ((inputLine =in.readLine()) != null) {
				if(inputLine.equals("KRAJSERVER")){
					try{
						ObjectMapper mapper = new ObjectMapper();
						String jsonString2=null;
						Raspored raspored = mapper.readValue(pom, Raspored.class);
						//System.out.println(prijava.getStudent().getIme());
						// mapper.enable(SerializationFeature.INDENT_OUTPUT);
						//jsonString = mapper.writeValueAsString(student);
						System.out.println("Odgovor servera!");
						System.out.println("server says:Raspored je sledeci :");
						for (int i = 0; i < raspored.getPredmeti().length; i++) {
							//String predmet=raspored.getPredmeti()[1];
							System.out.println("Predmet :"+raspored.getPredmeti()[i]);
							System.out.println("Vreme :"+raspored.getVreme()[i]);
							System.out.println("Sala :"+raspored.getSala()[i]);
							System.out.println("--------------------------------");
					}
					}catch (Exception e) { 
				        e.printStackTrace(); 
				        System.out.println("greska u mapperu!");
				    }
				}
				pom=pom+inputLine;
			}
		in.close();
		srvSocket.close();
	}
	}


