package com.taha.hamrahavaltest2.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "MOTree")
public class MOTree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "MO")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motree")
    private List<MO> moList;

}

