package com.taha.hamrahavaltest2.service;

import com.taha.hamrahavaltest2.model.MO;
import com.taha.hamrahavaltest2.repo.MORepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
@Service
public class MOService {
    private final MORepository moRepository;

    public MOService(MORepository moRepository) {
        this.moRepository = moRepository;
    }
    @Scheduled(fixedRate = 10000) // Run every 10 seconds
    public void scheduledParseAndSave() {
        parseAndSave();
    }

    public void parseAndSave() {


        try {
            File myFile = new File("/Users/tahamohammadi/Desktop/export2.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(myFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getTagName());
            NodeList nodeList = doc.getElementsByTagName("MO");
            for (int moIndex = 0; moIndex < nodeList.getLength(); moIndex++) {
                System.out.println("++++++++++++++++++++++++++++++");
                Node moNode = nodeList.item(moIndex);
                if (moNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element moElement = (Element) moNode;
                    MO mo = new MO();
                    NodeList attrList = moElement.getElementsByTagName("attr");
                    for (int attrIndex = 0; attrIndex < attrList.getLength(); attrIndex++) {
                        Element attrElement = (Element) attrList.item(attrIndex);
                        String attrName = attrElement.getAttribute("name");
                        String attrValue = attrElement.getTextContent();
                        try {
                            java.lang.reflect.Field field = MO.class.getDeclaredField(attrName);
                            field.setAccessible(true);
                            field.set(mo, attrValue);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(attrName + ": " + attrValue);
                    }
                    System.out.println("MO Object: " + mo);
                    moRepository.save(mo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
