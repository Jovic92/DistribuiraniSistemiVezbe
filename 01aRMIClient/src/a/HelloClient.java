package a;

import java.rmi.Naming;
public class HelloClient {

	public static void main(String arg[]) {

		try {
		
			HelloIntf obj = (HelloIntf) Naming.lookup("//127.0.0.1:4000/HelloServer");
			System.out.println(obj.sayHello());

		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
