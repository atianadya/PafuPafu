/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pafupafu;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Atia
 */
public class XMLHandler {
    
    public static PafuDefault pf = PafuDefault.getShared();
    
    public static boolean isNameExist(String name) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            Document doc = dbf.newDocumentBuilder().parse("savefile.xml");
            NodeList nl = doc.getElementsByTagName("Player");
            for (int i = 0; i < nl.getLength(); i++) {
                Element nNode = (Element) nl.item(i);
                if (nNode.getAttribute("name").equals(name)) {
                    return true;
                }
            }
            System.out.println("false");
            return false;
        } catch (ParserConfigurationException | SAXException pce) {
            pce.printStackTrace();
            return false;
        } catch (IOException ex) {
            Logger.getLogger(XMLHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static int findNameIdx(String name) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            Document doc = dbf.newDocumentBuilder().parse("savefile.xml");
            NodeList nl = doc.getElementsByTagName("Player");
            for (int i = 0; i < nl.getLength(); i++) {
                Element nNode = (Element) nl.item(i);
                if (nNode.getAttribute("name").equals(name)) {
                    return i;
                }
            }
            System.out.println("false");
            return -99;
        } catch (ParserConfigurationException | SAXException pce) {
            pce.printStackTrace();
            return -99;
        } catch (IOException ex) {
            Logger.getLogger(XMLHandler.class.getName()).log(Level.SEVERE, null, ex);
            return -99;
        }
    }
    
    public static void save(Pet pafupafu) { // pass player, pet, life, love
            try {
              File xmlFile = new File("savefile.xml");
              DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
              DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
//              Document doc = dbf.newDocumentBuilder().parse("savefile.xml");
              Document doc = documentBuilder.parse(xmlFile);
              Element dataElmt = doc.getDocumentElement();
              
              if (!isNameExist("new")) {
                  System.out.println("documentElement:" + dataElmt.toString());
                  
//                  Element pafuElmt = (Element) dataElmt.getElementsByTagName("PafuPafu").item(0);

                  Element newPlayer = doc.createElement("Player");
                  newPlayer.setAttribute("name", "new");
                  
                  Element pafuname = doc.createElement("pafuname");
                  pafuname.appendChild(doc.createTextNode("pafuname"));
                  newPlayer.appendChild(pafuname);
                  
                  Element elapsedtime = doc.createElement("elapsedtime");
                  elapsedtime.appendChild(doc.createTextNode("<player time>"));
                  newPlayer.appendChild(elapsedtime);
                  
                  Element love = doc.createElement("love");
                  love.appendChild(doc.createTextNode("<love value>"));
                  newPlayer.appendChild(love);
                  
                  Element life = doc.createElement("life");
                  life.appendChild(doc.createTextNode("<love value>"));
                  newPlayer.appendChild(life);
                  
                  dataElmt.appendChild(newPlayer);
                  
              } else {
                  int playerIdx = findNameIdx("new");
                  System.out.println(playerIdx);
                  NodeList nl = doc.getElementsByTagName("Player");
                  Element nNode = (Element) nl.item(playerIdx);
                  
                  Node elapsedtime = nNode.getChildNodes().item(1);
                  Node timetxt = elapsedtime.getFirstChild();
                  timetxt.setTextContent("modified");
                  
                  Node love = nNode.getChildNodes().item(2);
                  Node lovetxt = love.getFirstChild();
                  lovetxt.setTextContent("modified");
                  
                  Node life = nNode.getChildNodes().item(3);
                  Node lifetxt = life.getFirstChild();
                  lifetxt.setTextContent("modified");
              }
                doc.replaceChild(dataElmt, dataElmt);
                Transformer tFormer = TransformerFactory.newInstance().newTransformer();
                tFormer.setOutputProperty(OutputKeys.METHOD, "xml");

                Source source = new DOMSource(doc);
                Result result = new StreamResult(xmlFile);
                tFormer.transform(source, result);
                System.out.println("File saved");
                
            } catch (ParserConfigurationException | TransformerException | SAXException | IOException pce) {
              pce.printStackTrace();
            }
        }
}
