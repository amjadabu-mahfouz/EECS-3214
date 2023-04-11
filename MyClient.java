package Datta_3214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Amjad
 * !IMPORTANT! run the following programs in this order: MyServer.java --> MyClient.java (x3) --> MyCoordinator.java
 * 
 * this is the cient class which is suppose to emulate an user who receives an attack command from a hacker and then proceeds to open a connection and ping a server
 * this class requires the client machine's port number as well as the target server's ip and port numbers passed as parameters. 
 * this class runs server mode until a connection from the coordinator is started and an attack command is sent, 
 * after words the server mode will close and the client mode will begin where the client will connect to the server and send a "hello" and "bye" message
 * (refer to the instructions below for more information).
 *    
 * 
 * How to use:
 * 				1) compile program
 * 				2) run the program in the terminal 
 * 				3) this program MUST have the following arguments in this order: <client port#> <target server ip> <target server port#> 
 * 	
 * EXAMPLE: java MyClient 5003 192.168.56.1 5000				
 *
 */

public class MyClient {

	
	
public static void main(String[] args) throws IOException {
        
        if (args.length != 3) {
            System.err.println(
                "Usage: java EchoClient <client port number> <target server name/ip> <target server port number>");
            System.exit(1);
        }

        
        int clientPort = Integer.parseInt(args[0]);
        
        String targetName = args[1];
        int targetPort = Integer.parseInt(args[2]);

        try (
        	//start of server code
        		ServerSocket serverSocket =
        			new ServerSocket(clientPort);
                Socket clientSocket = serverSocket.accept();     
                PrintWriter serverOut =
                    new PrintWriter(clientSocket.getOutputStream(), true);                   
                BufferedReader serverIn = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));	
        	//end of server code
        	) {
        	
        	
        	//if coordinator sends an "attack" command, initiate client code to connect to server
            
            String beginAttack;
            
            while ((beginAttack = serverIn.readLine()) != null){
            	
            	if(beginAttack == "attack"){
            		break;
            	}
            }
            	
            
           
       
        serverSocket.close();
        serverIn.close();
        serverOut.close();
        
        
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + clientPort + " or listening for a connection");
            System.out.println(e.getMessage());
        }
   
    
        
        try(
    			
        		//start of client code	
        		Socket connSocket = new Socket(targetName, targetPort);
        		PrintWriter clientOut =
        				new PrintWriter(connSocket.getOutputStream(), true);
        		BufferedReader clientIn =
        				new BufferedReader(
        						new InputStreamReader(connSocket.getInputStream()));
        		//end of client code
        			
        	){
        		clientOut.println("hello");
        		clientOut.println("bye");
        		
        		connSocket.close();
        		clientOut.close();
        		clientIn.close();
        	
        	} catch (UnknownHostException e) {
                System.err.println("Don't know about host " + targetName);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to " +
                    targetName);
                System.exit(1);
            } 
    
        
        
        
    }
	
	
}
