import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class TestXML {
    public static void main(String[] args) {
        try {
            new TestXML().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() throws Exception {
        URL url = new URL("");
        URLConnection connection = url.openConnection();

        Document doc = parseXML(connection.getInputStream());
        NodeList imgNodes = doc.getElementsByTagName("ImageName1");
        NodeList imgNodes2 = doc.getElementsByTagName("ImageName2");
        NodeList imgNodes3 = doc.getElementsByTagName("ImageName3");
        NodeList imgNodes4 = doc.getElementsByTagName("ImageName4");
        NodeList imgNodes5 = doc.getElementsByTagName("ImageName5");


        for (int i = 0; i < imgNodes.getLength(); i++) {
            System.out.println(imgNodes.item(i).getTextContent());
        }

        for (int i = 0; i < imgNodes2.getLength(); i++) {
            System.out.println(imgNodes2.item(i).getTextContent());
        }
        for (int i = 0; i < imgNodes3.getLength(); i++) {
            System.out.println(imgNodes3.item(i).getTextContent());
        }
        for (int i = 0; i < imgNodes4.getLength(); i++) {
            System.out.println(imgNodes4.item(i).getTextContent());
        }
        for (int i = 0; i < imgNodes5.getLength(); i++) {
            System.out.println(imgNodes5.item(i).getTextContent());
        }


    }

    private Document parseXML(InputStream stream)
            throws Exception {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();


            doc = objDocumentBuilder.parse(stream);
        } catch (Exception ex) {
            throw ex;
        }
        return doc;
    }


}

