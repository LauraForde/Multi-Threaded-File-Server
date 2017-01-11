package ie.gmit.sw.Client;

import java.io.*;
import java.net.*;

// Used WebClient, on John Healy's moodle page, as reference
public class Connect {

	// Creating new socket
	Socket soc = new Socket();
	
	public void runCon(){
		// Try connect to the server through the localhost
		try{
			soc = new Socket("localhost", 7777);
			System.out.println("Connected to the server");
			soc.close();
		}catch(Exception e){
			// Throw error
			System.out.println("Error " + e.getMessage());
		}
	}
	public void closeCon() throws IOException{
		// Close the connection
		soc.close();
	}

}
