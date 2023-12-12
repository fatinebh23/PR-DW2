package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//ignorar las otras etiquetas
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    private String strTeam;
    private String intFormedYear;
    private String strStadium;

}
