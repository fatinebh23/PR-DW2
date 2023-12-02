package org.example;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "atletaAna")
public class AtletaFemenina {
    private String nombre;
    private List<String> prueba;
    private int edad;
    private String pais;


}
