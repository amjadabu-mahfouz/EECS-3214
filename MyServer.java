import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.io.*;

/**
 * @author Amjad
 * !IMPORTANT! run the following programs in this order: MyServer.java --> MyClient.java (x3) --> MyCoordinator.java
 * 
 * this is the server class which is suppose to emulate a server that receives connections from multiple clients (each connection takes 10 seconds to close) 
 * this class requires to know the server's port number only.
 * this class also instantiates a new "MyThread" class for each client that connects to it, allowing multiple clients to connect the the server
 * (refer to the instructions below for more information).
 *    
 * 
 * How to use:
 * 				1) compile program
 * 				2) run the program in the terminal 
 * 				3) this program MUST have the following arguments in this order: <server port#>
 * 	
 * EXAMPLE: java MyServer 5000				
 *
 */
public class MyServer {
	
	
	 public static void main(String[] args) throws IOException {

		    if (args.length != 1) {
		        System.err.println("Usage: java KKMultiServer <port number>");
		        System.exit(1);
		    }
		    	
		        
		    	int portNumber = Integer.parseInt(args[0]);
		        boolean listening = true;
		        
		        try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
		        	
		        	
		        	
		        	while (listening) {
			            new MyThread(serverSocket.accept()).start();
			            
			        }
		        	
		        	
		        	
			    } catch (IOException e) {
		            System.err.println("Could not listen on port " + portNumber);
		            System.exit(-1);
		        }
		    }
	

}
