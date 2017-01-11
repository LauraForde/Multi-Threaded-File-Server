package ie.gmit.sw.Client.config;

import javax.xml.parsers.*;
import org.w3c.dom.*;

// https://www.youtube.com/watch?v=HfGWVy-eMRc
// video used as reference
public class XMLParser {
	private Parser parse;
	
	public XMLParser(Parser parse){
		super();
		this.parse = parse;
	}
	public void initRun() throws Throwable {
		// Creating document builders and calling the FILE from the Parser class
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(Parser.FILE);
		
		Element root = doc.getDocumentElement();
		NodeList client = root.getChildNodes();
		
		for(int i = 0; i < client.getLength(); i++){
			// Reading node from the file
			Node c = client.item(i);
			// If the item read in is part of the element
			if(c instanceof Element){
				Element cli = (Element) c;
				// If the node reads as "client-config" read in all child nodes
				if(cli.getNodeName().equals("client-config")){
					NodeList cliList = cli.getChildNodes();
					
					for(int j = 0; j < cliList.getLength(); j++){
						Node item = cliList.item(j);
						if(item.getNodeName().equals("username")){
							parse.setUsername(cliList.item(j).getNodeValue());
						}		
					}					
				
				}
				else if(cli.getNodeName().equals("server-host"))
					parse.setHost(cli.getFirstChild().getNodeValue());
				
				else if(cli.getNodeName().equals("server-port"))
					parse.setPort(Integer.parseInt(cli.getFirstChild().getNodeValue()));
				
				else if(cli.getNodeName().equals("download-dir"))
					parse.setDir(cli.getFirstChild().getNodeValue());
			
			}
		}

	}
	public Parser getParse() {
		return parse;
	}
	public void setParse(Parser parse) {
		this.parse = parse;
	}
}
