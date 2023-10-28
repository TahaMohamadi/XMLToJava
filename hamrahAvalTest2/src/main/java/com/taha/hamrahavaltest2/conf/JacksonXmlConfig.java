package com.taha.hamrahavaltest2.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonXmlConfig {

    @Bean
    public XmlMapper xmlMapper() {
        return new XmlMapper();
    }

    @Bean
    public ObjectMapper objectMapper(XmlMapper xmlMapper) {
        return xmlMapper;
    }
}
