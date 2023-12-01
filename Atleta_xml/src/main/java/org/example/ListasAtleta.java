package org.example;

import java.util.List;

public class ListasAtleta {
     private List<AtletaFemenina> listaAtletas;

    public ListasAtleta(List<AtletaFemenina> listaAtletas) {
        this.listaAtletas = listaAtletas;
    }

    public List<AtletaFemenina> getListaAtletas() {
        return listaAtletas;
    }

    public void setListaAtletas(List<AtletaFemenina> listaAtletas) {
        this.listaAtletas = listaAtletas;
    }

    public void anyadirAtleta(AtletaFemenina atleta){
        this.listaAtletas.add(atleta);
        System.out.println("Se ha añadido atleta");
    }
}

