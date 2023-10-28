package com.taha.hamrahavaltest2.controller;

import com.taha.hamrahavaltest2.service.MOService;
import com.taha.hamrahavaltest2.service.MOTreeService;
import com.taha.hamrahavaltest2.model.MOTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class MOTreeController {
    @Autowired
    private MOTreeService motreeService;
    @Autowired
    private MOService moService;

    @PostMapping("/parse-xml-and-save")
    public void parseXmlAndSave(@RequestParam("filePath") String filePath) {
        try {
            // Read the XML content from the file specified by the filePath
            String xmlData = readXmlFromFile(filePath);

            // Parse the XML content and save it to the database
            MOTree motree = motreeService.parseXmlToJava(xmlData);
            motreeService.saveMOTreeToDatabase(motree);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    private String readXmlFromFile(String filePath) throws IOException {
        // Implement code to read the XML content from the file specified by filePath
        // You can use standard file I/O or any other method that suits your needs
        // Here's a simple example:
        return Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
    }

    @PostMapping("/readAndSave")
    public void readAndSave(){
        moService.scheduledParseAndSave();
    }
}

