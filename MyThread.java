import java.net.*;
import java.util.Date;
import java.io.*;
//import java.util.Timer;


/**
 * @author Amjad
 * !IMPORTANT! run the following programs in this order: MyServer.java --> MyClient.java (x3) --> MyCoordinator.java
 * 
 * this is the thread class, this class is never run, but instead is instantiated by the "MyServer.java" class every time a new client connects to it.
 * once it has been instantiated by the server, it receives the client's input (in this case it would be the "hello" and "bye" messages).
 * before the connection is closed, a 10 second delay will occur.
 * the user message will be recorded in the "server.log" file along with the time it was received (also when the connection closes).
 * 
 * 
 * 
 * 
 * INSTRUCTIONS: 1) compile "MyThread.java"
 * 				 2) don't touch this file, let the server handle making instances of the file
 *    
 */
public class MyThread extends Thread {
	
	 private Socket socket = null;
	 //FileWriter myfw ;
	 //private Timer t = new Timer();
	 
	    public MyThread(Socket socket) {
	        super("MyThread");
	        this.socket = socket;
	        //this.myfw = fileW;
	        
	    }
	    
	    public void run() {

	        try (
	            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(
	                new InputStreamReader(
	                    socket.getInputStream()));
	        		BufferedWriter fileOut = new BufferedWriter(new FileWriter("server.log", true));
	        		//BufferedWriter fileOut = new BufferedWriter(myfw);
	        		
	        ) {
	            String inputLine, outputLine;
	            
	            Date d = new Date();

	            while ((inputLine = in.readLine()) != null ) {
	                
	            	fileOut.append((d = new Date()).toString() + "  ( User Name = " + socket.getInetAddress() + " , Port = "  + socket.getPort() + " ) :" + inputLine);
	            	fileOut.newLine();
	                
	            	try {
						this.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                
	            	inputLine = in.readLine();
	                fileOut.append((d = new Date()).toString() + "  ( User Name = " + socket.getInetAddress() + " , Port = "  + socket.getPort() + " ) :" + inputLine);
	            	fileOut.newLine();
	            	
	                if (inputLine.equals("bye"))
	                    break;
	            }
	            socket.close();
	            fileOut.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
