package ie.gmit.sw.Server;

import java.io.*;
import java.net.*;
// Used lecturer, John Healy's, WebServer as reference

public class Server {
	private ServerSocket ss;
	private static final int SERVER_PORT = 7777;
	private volatile boolean keepRunning = true;
	
	public Server(){
		try{
			ss = new ServerSocket(SERVER_PORT);
			Thread server = new Thread(new Listner(), "Web Server Listner");
			server.setPriority(Thread.MAX_PRIORITY);
			// Start the server
			server.start();
			System.out.println("Server started and listening on port " + SERVER_PORT);
		}catch(IOException e){
			System.out.println("Something went wrong! " + e.getMessage());
		}
	}
	public static void main(String[] args) {
		new Server();
	}
	// Keep the Listner running
	public class Listner implements Runnable{
		public void run(){
			int counter = 0;
			while(keepRunning){
				try{
					Socket s = ss.accept();
					new Thread(new HTTPRequest(s), "T-" + counter).start();
					counter++;
				}catch(IOException e){
					System.out.println("Error handling incoming request" + e.getMessage());
				}
			}
		}
	}
	private class HTTPRequest implements Runnable{
		private Socket sock;
		
		private HTTPRequest(Socket request){
			this.sock = request;
		}
		
		public void run(){
			try{
				System.out.println("Server Running");
			}catch (Exception e) {
            	System.out.println("Error processing request from " + sock.getRemoteSocketAddress());
            	e.printStackTrace();
            }
		}
	}

}
