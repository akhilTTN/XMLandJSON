package com.ttn.exercise.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileNotFoundException;

public class XMLDOMParser {

    public static void main(String argv[]) {
        try {
            File file = new File("src/organisation.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("department");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Element eElement = (Element) nNode;
                System.out.println("--------------------------------------");
                NodeList nodeList = eElement.getElementsByTagName("competency");
                System.out.println("Department Name : " + eElement.getAttribute("name"));
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element element = (Element) nodeList.item(i);
                    System.out.println("*********************************************");
                    System.out.println("Competency Name : " + element.getAttribute("name"));
                    System.out.println("Employees : " + element.getElementsByTagName("employees").item(0).getTextContent());
                    System.out.println("Head : " + element.getElementsByTagName("head").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
