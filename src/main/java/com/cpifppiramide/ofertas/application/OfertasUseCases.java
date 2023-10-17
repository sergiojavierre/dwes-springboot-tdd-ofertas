package com.cpifppiramide.ofertas.application;

import com.cpifppiramide.ofertas.domain.Oferta;
import com.cpifppiramide.ofertas.domain.OfertasRepository;

import java.util.List;

public class OfertasUseCases {

    private final OfertasRepository ofertasRepository;

    public OfertasUseCases(OfertasRepository ofertasRepository){
        this.ofertasRepository = ofertasRepository;
    }

    public List<Oferta> getAll(){
        return this.ofertasRepository.getAll();
    }
    public Oferta find(String titulo){
        return this.ofertasRepository.find(titulo);
    }

    public Oferta save(Oferta oferta){
        return this.ofertasRepository.save(oferta);
    }
    public Oferta update(Oferta actualizada){
        Oferta anterior = this.ofertasRepository.find(actualizada.getTitulo());
        return this.ofertasRepository.update(anterior, actualizada);
    }

    public String delete(String titulo){
        return this.ofertasRepository.delete(titulo);
    }


}
