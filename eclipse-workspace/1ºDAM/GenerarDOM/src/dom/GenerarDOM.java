package dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GenerarDOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File x = new File("libro.xml");
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder b = f.newDocumentBuilder();
			Document d =(Document) b.parse(x);
			imprimeNodo((Node) d,"");
			
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	static void imprimeNodo(Node n,String p)
	{
		NodeList l = n.getChildNodes();
		NamedNodeMap m = n.getAttributes();
		
		int ml = -1;
		if(m != null)
			ml=m.getLength();
		System.out.println(p+n.getNodeName()+": "+n.getNodeType()+", "+l.getLength()+", "
				+ml+", "+n.getNodeValue());
		for(int i=0; i<ml; i++) {
			Node c = m.item(i);
			imprimeNodo(c,p+" |-");
		}
		for(int i=0; i<l.getLength(); i++) {
			Node c = l.item(i);
			imprimeNodo(c, p+" ");
		}
	}

}
