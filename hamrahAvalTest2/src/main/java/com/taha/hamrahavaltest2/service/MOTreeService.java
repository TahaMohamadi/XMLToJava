package com.taha.hamrahavaltest2.service;

import com.taha.hamrahavaltest2.model.MOTree;
import com.taha.hamrahavaltest2.repo.MOTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

@Service
public class MOTreeService {
    @Autowired
    private MOTreeRepository motreeRepository;
    @Autowired
    private XmlMapper xmlMapper;

    public MOTree parseXmlToJava(String xmlData) throws IOException {
        return xmlMapper.readValue(xmlData, MOTree.class);
    }

    public void saveMOTreeToDatabase(MOTree motree) {
        motreeRepository.save(motree);
    }
}

