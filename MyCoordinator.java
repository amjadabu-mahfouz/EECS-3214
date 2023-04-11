import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Amjad
 * !IMPORTANT! run the following programs in this order: MyServer.java --> MyClient.java (x3) --> MyCoordinator.java
 * 
 * this is the coordinator class which is suppose to emulate an attacker who initiates a remote DDos attack on a server by messaging different client machines.
 * this class requires to know the 3 client's machine's ip address and port number.
 * (refer to the instructions below for more information).
 *    
 * 
 * How to use:
 * 				1) compile program
 * 				2) run the program in the terminal 
 * 				3) this program MUST have the following arguments in this order: <client1 ip> <client1 port#> <client2 ip> <client2 port#> <client3 ip> <client3 port#>
 * 	
 * EXAMPLE: java MyCoordinator 192.168.56.1 5003 192.168.56.1 5005 192.168.56.1 5007
 *
 *The improvements could all be made here:
 *										  1) the coordinator could pass in the server ip and port numbers, so clients dont have to keep track
 *										  2) a more intractable and user friendly guide on how to use these programs implemented through system.print and scanners
 *										  3) a more comprehensive error checking and correction system, where if the ip or port did not match, 
 *											 the program will still continue to run while prompting user to re-enter parameters	 				
 *
 */
public class MyCoordinator {
	
    public static void main(String[] args) throws IOException {
        
        if (args.length != 6) {
            System.err.println(
                "Usage: java EchoClient  <client1 name> <client1 port> <client2 name> <client2 port> <client3 name> <client3 port>");
            System.exit(1);
        }
        
        
        String client1Name = args[0];
        int client1Port = Integer.parseInt(args[1]);
        
        String client2Name = args[2];
        int client2Port = Integer.parseInt(args[3]);
        
        String client3Name = args[4];
        int client3Port = Integer.parseInt(args[5]);
        
        
        
        	
        	
        	
       try (
            Socket client1Socket = new Socket(client1Name, client1Port);
            PrintWriter client1Out =
                new PrintWriter(client1Socket.getOutputStream(), true);
            BufferedReader client1In =
                new BufferedReader(
                    new InputStreamReader(client1Socket.getInputStream()));
    		   
    		   Socket client2Socket = new Socket(client2Name, client2Port);
               PrintWriter client2Out =
                   new PrintWriter(client2Socket.getOutputStream(), true);
               BufferedReader client2In =
                   new BufferedReader(
                       new InputStreamReader(client2Socket.getInputStream()));
    		   
    		   
    		   Socket client3Socket = new Socket(client3Name, client3Port);
               PrintWriter client3Out =
                   new PrintWriter(client1Socket.getOutputStream(), true);
               BufferedReader client3In =
                   new BufferedReader(
                       new InputStreamReader(client1Socket.getInputStream()));
           
        
    		   
    		
    		   
    	) {
           
    	   client1Out.println("attack");
    	   
    	   
    	   client2Out.println("attack");
    	   
    	   
    	   client3Out.println("attack");
    	   
    	   
    	   
    	
    	   
            
        client1Socket.close();
        client1Out.close();
        client1In.close();
        
        client2Socket.close();
        client2Out.close();
        client2In.close();
        
        client3Socket.close();
        client3Out.close();
        client3In.close();
        
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " );
            System.exit(1);
        } 
   
        
       
    
    }
	

}
