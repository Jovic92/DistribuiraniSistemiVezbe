package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		int count = 0;
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
			System.out.println("Client from " + clientSocket.getInetAddress().getHostAddress() + " connected");
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}

		System.out.println("Connection successful");
		System.out.println("Waiting for input.....");

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		String inputLine;

		while ((inputLine = in.readLine()) != null) {

			System.out.println("Client says: " + inputLine);
			if (inputLine.equals("Bye.")) {
				out.print("Good bye!");
				break;
			} else {

				/*
				 * count++;
				 * out.println("This is "+count+". response from server.");
				 */
				Scanner scan = new Scanner(System.in);
				String userInput;

				System.out.print("input: ");
				userInput = scan.nextLine();
				out.println(userInput);

			}

		}

		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}

}
