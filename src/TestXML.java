
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestXML {

	public static void main(String[] args) {

		try {

			File file = new File("/staffs.xml");

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document doc = dBuilder.parse(file);

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			if (doc.hasChildNodes()) {

				printNote(doc.getChildNodes());

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void printNote(NodeList nodeList) {

		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName().equals("company")) {

				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());

				if (tempNode.hasAttributes()) {

					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();

					for (int i = 0; i < nodeMap.getLength(); i++) {

						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());

					}

				}

				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					System.out.println(tempNode.getChildNodes().getLength());
					newMethod(tempNode.getChildNodes());

				}

				System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

			}

		}

	}

	public static void newMethod(NodeList nodeList) {

		for (int j = 0; j < nodeList.getLength(); j++) {
			Node tempNode = nodeList.item(j);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName().equals("staff")) {
				if (tempNode.hasAttributes()) {
					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();

					for (int i = 0; i < nodeMap.getLength(); i++) {

						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());

					}

					System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
					System.out.println("Node Value =" + tempNode.getTextContent());
					if(tempNode.hasChildNodes()){
						printfinal(tempNode.getChildNodes());
					}
				}

			}
		}
	}

	private static void printfinal(NodeList childNodes) {
		
		for(int i = 0; i<childNodes.getLength() ; i++){
			
			Node finalValue = childNodes.item(i);
			
			if(finalValue.getNodeName().equals("firstname")){
				System.out.println("First Name is:" +finalValue.getNodeValue());
			}
			if(finalValue.getNodeName().equals("lastname")){
				System.out.println("Last Name is:" +finalValue.getTextContent());				
			}
			if(finalValue.getNodeName().equals("nickname")){
				System.out.println("Nick Name is:" +finalValue.getTextContent());				
			}
			if(finalValue.getNodeName().equals("salary")){
				System.out.println("Salary is:" +finalValue.getTextContent());				
			}
		}
		
		
	}

}