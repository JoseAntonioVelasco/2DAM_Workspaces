package principal;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class ConvertidorPDF {
	public static void main(String[] args) {
		ConvertidorPDF fOPPdfDemo = new ConvertidorPDF();
		try {fOPPdfDemo.convertToPDF();}
		catch(Exception e) {System.out.println("Excepcion: "+e);}
	}
	
	public void convertToPDF() throws IOException,FOPException,TransformerException
	{
		File xsltFile = new File("CiclosFormativos_fo.xsl");
		StreamSource xmlSource = new StreamSource(new File("CiclosFormativos.xml"));
		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		OutputStream out;
		out = new java.io.FileOutputStream("tablas.pdf");
		
		try {
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF,foUserAgent,out);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
			Result res = new SAXResult(fop.getDefaultHandler());
			transformer.transform(xmlSource, res);
		}
		finally {out.close();}
	}
}
