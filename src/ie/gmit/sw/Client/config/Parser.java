package ie.gmit.sw.Client.config;

public class Parser {

	public static final String FILE = "config-client.xml";
	private String username;
	private String host;
	private int port;
	private String dir;
	// Parser constructor
	public Parser() {
		super();
	}
	
	// Getters & Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	// Return the items read in from the file
	@Override
	public String toString() {
		return "Username: " + username + "\nHost: " + host + "\nPort: " + port + "\nDir: " + dir;
	}

}
	
