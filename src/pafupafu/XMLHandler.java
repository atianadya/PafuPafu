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
    public static int ttime, tlove,tlife,tgender;
    public static String tpafuname, tplayer;
    
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
    
    public static void load(String playerName) {
        try {
            File xmlFile = new File("savefile.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document doc = documentBuilder.parse(xmlFile);
            Element dataElmt = doc.getDocumentElement();
            
            if (!isNameExist(playerName)) {
                System.out.println("gak ada");
            } else {
                // load file
                System.out.println("lalala");
                int playerIdx = findNameIdx(playerName);
                NodeList nl = doc.getElementsByTagName("Player");
                Element playerNode = (Element) nl.item(playerIdx);
                
                tplayer = playerName;
                ttime = Integer.parseInt(playerNode.getElementsByTagName("elapsedtime").item(0).getTextContent());
                tpafuname = playerNode.getElementsByTagName("pafuname").item(0).getTextContent();
                tgender = Integer.parseInt(playerNode.getElementsByTagName("gender").item(0).getTextContent());
                System.out.println("gender" +tgender);
                tlove = Integer.parseInt(playerNode.getElementsByTagName("love").item(0).getTextContent());
                tlife = Integer.parseInt(playerNode.getElementsByTagName("life").item(0).getTextContent());
            }
            
        } catch (ParserConfigurationException | SAXException | IOException pce) {
              pce.printStackTrace();
        }
    }
    
    public static void save(Pet pafupafu, Player player) {
            try {
              File xmlFile = new File("savefile.xml");
              DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
              DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
//              Document doc = dbf.newDocumentBuilder().parse("savefile.xml");
              Document doc = documentBuilder.parse(xmlFile);
              Element dataElmt = doc.getDocumentElement();
              
              if (!isNameExist(player.getPlayerName())) {
                  System.out.println("documentElement:" + dataElmt.toString());
                  
//                  Element pafuElmt = (Element) dataElmt.getElementsByTagName("PafuPafu").item(0);

                  Element newPlayer = doc.createElement("Player");
                  newPlayer.setAttribute("name", player.getPlayerName());
                  
                  Element pafuname = doc.createElement("pafuname");
                  pafuname.appendChild(doc.createTextNode(pafupafu.getName()));
                  newPlayer.appendChild(pafuname);
                  
                  Element gender = doc.createElement("gender");
                  gender.appendChild(doc.createTextNode(Integer.toString(pafupafu.getGender())));
                  newPlayer.appendChild(gender);
                  
                  Element elapsedtime = doc.createElement("elapsedtime");
                  elapsedtime.appendChild(doc.createTextNode(Integer.toString(player.getElapsedTime())));
                  newPlayer.appendChild(elapsedtime);
                  
                  Element love = doc.createElement("love");
                  love.appendChild(doc.createTextNode(Integer.toString(LoveMeter.getLoveVal())));
                  newPlayer.appendChild(love);
                  
                  Element life = doc.createElement("life");
                  life.appendChild(doc.createTextNode(Integer.toString(LifeMeter.getLifeVal())));
                  newPlayer.appendChild(life);
                  
                  dataElmt.appendChild(newPlayer);
                  
              } else {
                  int playerIdx = findNameIdx(player.getPlayerName());
                  System.out.println(playerIdx);
                  NodeList nl = doc.getElementsByTagName("Player");
                  Element nNode = (Element) nl.item(playerIdx);
                  
                  Node elapsedtime = nNode.getChildNodes().item(2);
                  Node timetxt = elapsedtime.getFirstChild();
                  timetxt.setTextContent(Integer.toString(player.getElapsedTime()));
                  
                  Node gender = nNode.getChildNodes().item(1);
                  Node gendertxt = gender.getFirstChild();
                  System.out.println("gender:"+pafupafu.getGender());
                  gendertxt.setTextContent(Integer.toString(pafupafu.getGender()));
                  
                  Node love = nNode.getChildNodes().item(3);
                  Node lovetxt = love.getFirstChild();
                  lovetxt.setTextContent(Integer.toString(LoveMeter.getLoveVal()));
                  
                  Node life = nNode.getChildNodes().item(4);
                  Node lifetxt = life.getFirstChild();
                  lifetxt.setTextContent(Integer.toString(LifeMeter.getLifeVal()));
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
