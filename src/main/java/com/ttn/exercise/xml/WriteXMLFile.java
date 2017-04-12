package com.ttn.exercise.xml;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by akhil on 12/4/17.
 */
public class WriteXMLFile {

    public static void main(String argv[]) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("ttn");
            doc.appendChild(rootElement);

            Element department = doc.createElement("department");
            rootElement.appendChild(department);

            Attr attr = doc.createAttribute("name");
            attr.setValue("Technology ");
            department.setAttributeNode(attr);

            Element competency1 = doc.createElement("competency");
            department.appendChild(competency1);

            Attr attr1= doc.createAttribute("name");
            attr1.setValue("JVM");
            competency1.setAttributeNode(attr1);

            Element employee = doc.createElement("employee");
            employee.appendChild(doc.createTextNode("50"));
            competency1.appendChild(employee);

            Element head = doc.createElement("head");
            head.appendChild(doc.createTextNode("Raghu"));
            competency1.appendChild(head);

            Element competency2 = doc.createElement("competency");
            department.appendChild(competency2);

            Attr attr2= doc.createAttribute("name");
            attr2.setValue("Drupal");
            competency2.setAttributeNode(attr2);

            Element employee1 = doc.createElement("employee");
            employee1.appendChild(doc.createTextNode("30"));
            competency2.appendChild(employee1);

            Element head1 = doc.createElement("head");
            head1.appendChild(doc.createTextNode("Karan"));
            competency2.appendChild(head1);



            Element competency3 = doc.createElement("competency");
            department.appendChild(competency3);

            Attr attr3= doc.createAttribute("name");
            attr3.setValue("Mobility");
            competency3.setAttributeNode(attr3);

            Element employee2 = doc.createElement("employee");
            employee2.appendChild(doc.createTextNode("20"));
            competency3.appendChild(employee2);

            Element head2 = doc.createElement("head");
            head2.appendChild(doc.createTextNode("Ken"));
            competency3.appendChild(head2);

            Element department1= doc.createElement("department");
            rootElement.appendChild(department1);

            Attr attr4=doc.createAttribute("name");
            attr4.setValue("Management");
            department1.setAttributeNode(attr4);

            Element competency4= doc.createElement("competency");
            department1.appendChild(competency4);

            Attr attr5= doc.createAttribute("name");
            attr5.setValue("Sales");
            competency4.setAttributeNode(attr5);

            Element employee3= doc.createElement("employee");
            employee3.appendChild(doc.createTextNode("10"));
            competency4.appendChild(employee3);

            Element head3= doc.createElement("head");
            head3.appendChild(doc.createTextNode("Abhishek"));
            competency4.appendChild(head3);


            Element competency5= doc.createElement("competency");
            department1.appendChild(competency5);

            Attr attr6= doc.createAttribute("name");
            attr6.setValue("HR");
            competency5.setAttributeNode(attr6);

            Element employee4= doc.createElement("employee");
            employee4.appendChild(doc.createTextNode("7"));
            competency5.appendChild(employee4);

            Element head4= doc.createElement("head");
            head4.appendChild(doc.createTextNode("Gaurav"));
            competency5.appendChild(head4);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("XMLfile.xml"));

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
