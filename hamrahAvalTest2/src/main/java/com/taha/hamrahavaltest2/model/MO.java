package com.taha.hamrahavaltest2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private MOTree motree;

    @JacksonXmlProperty(localName = "className")
    private String className;
    @JacksonXmlProperty(localName = "fdn")
    private String fdn;
    @JacksonXmlProperty(localName = "fdn")

    private String fdnChild;
    private String IP;
    private String MOIndex;
    @JacksonXmlProperty(localName = "className")

    private String classNameChild;
    private String isOffline;
    private String latitude;
    private String locationName;
    private String longitude;
    private String matchVersion;
    private String name;
    private String neID;
    private String neType;
    private String neVersion;
    private String realLatitude;
    private String realLongitude;
    private String vendorName;
    private String DaylightSaveInfo;
    private String TimeZone;
    private String ADJNODENAME;
    private String ANI;
    private String NODEBID;
    private String NODET;
    private String TRANST;
    private String CELLID;
    private String CONNQHYST1S;
    private String CONNQHYST2S;
    private String CONNSINTERSEARCH;
    private String CONNSINTRASEARCH;
    private String IDLEQHYST1S;
    private String IDLEQHYST2S;
    private String IDLESINTERSEARCH;
    private String IDLESINTRASEARCH;
    private String INTERFREQTRESELSCALINGFACTOR;
    private String INTERRATTRESELSCALINGFACTOR;
    private String LOGICRNCID;
    private String MAXALLOWEDULTXPOWER;
    private String NONHCSIND;
    private String QHYST1SFACH;
    private String QHYST1SPCH;
    private String QHYST2SFACH;
    private String QHYST2SPCH;
    private String QQUALMIN;
    private String QRXLEVMIN;
    private String QRXLEVMINEXTSUP;
    private String QUALMEAS;
    private String SPEEDDEPENDENTSCALINGFACTOR;
    private String SSEARCHRAT;
    private String TRESELECTIONS;
    private String TRESELECTIONSFACH;
    private String TRESELECTIONSPCH;
    private String BLINDHOFLAG;
    private String CIOOFFSET;
    private String DRDECN0THRESHHOLD;
    private String GSMCELLINDEX;
    private String MBDRFLAG;
    private String MBDRPRIO;
    private String NPRIOFLAG;
    private String QOFFSET1SN;
    private String RNCID;
    private String SIB11IND;
    private String SIB12IND;
    private String TEMPOFFSET1;
    private String TPENALTYHCSRESELECT;
    private String IDLEQOFFSET1SN;
    private String IDLEQOFFSET2SN;
    private String NCELLID;
    private String NCELLRNCID;
    private String NRNCID;
    private String CNOPERATORID;
    private String ENODEBFUNCTIONNAME;
    private String NBIOTTAFLAG;
    private String TAC;
    private String TRACKINGAREAID;
    private String ENODEBID;

}
