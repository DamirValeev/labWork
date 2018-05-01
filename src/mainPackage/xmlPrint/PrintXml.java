package mainPackage.xmlPrint;

import mainPackage.Patient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrintXml {
    static public void printXmlFile() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("patients.xml");
        Element root = document.getDocumentElement();
        List<Patient> patientList = new ArrayList<>();
        NodeList patients = root.getChildNodes();
        for (int i = 0; i < patients.getLength(); i++) {
            Node patient = patients.item(i);
            if (!patient.getNodeName().equals("#text")) {
                System.out.println(patient.getNodeName() + " : ");
                NodeList patientNodeList = patient.getChildNodes();
                int patId = 0;
                String patName = null;
                String patLastName = null;
                int patAge = 0;
                for (int j = 0; j < patientNodeList.getLength(); j++) {
                    Node insidePatient = patientNodeList.item(j);
                    if (!insidePatient.getNodeName().equals("#text")) {
                        System.out.println("\t" + insidePatient.getNodeName() + " : " + insidePatient.getTextContent());
                        String nodeName = insidePatient.getNodeName();
                        String nodeValue = insidePatient.getTextContent();
                        if (nodeName.equals("patientId")) {
                            patId = Integer.parseInt(nodeValue);
                        } else if (nodeName.equals("firstNamePatient")) {
                            patName = nodeValue;
                        } else if (nodeName.equals("lastNamePatient")) {
                            patLastName = nodeValue;
                        } else if (nodeName.equals("ageOfPatient")) {
                            patAge = Integer.parseInt(nodeValue);
                        }
                    }
                }
                Patient patient1 = new Patient(patId,patName,patLastName,patAge);
                patientList.add(patient1);
                System.out.println(patient1);
            }
        }
    }
}
