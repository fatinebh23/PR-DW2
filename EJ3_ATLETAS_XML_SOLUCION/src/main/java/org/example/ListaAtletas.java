package org.example;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@JacksonXmlRootElement(localName = "atletasAna")
public class ListaAtletas {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "atletaAna")
    private List<AtletaFemenina> atletas;


}
