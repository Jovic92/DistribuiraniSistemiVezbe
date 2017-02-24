package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTest {
	public static void main(String[] args) throws IOException {

		String serverHostname = new String("127.0.0.1");

		Socket srvSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			srvSocket = new Socket(serverHostname, 10007);
			out = new PrintWriter(srvSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(srvSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + serverHostname);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
			System.exit(1);
		}

		Scanner scan = new Scanner(System.in);
		String userInput;

		System.out.print("input: ");
		while (scan.hasNext()) {
			userInput = scan.nextLine();
			out.println(userInput);
			System.out.println("server says: " + in.readLine());
			System.out.print("input: ");
		}

		out.close();
		in.close();
		scan.close();
		srvSocket.close();
	}

}
