package com.cpifppiramide.ofertas.infrastructure;

import com.cpifppiramide.ofertas.domain.Oferta;
import com.cpifppiramide.ofertas.domain.OfertasRepository;

import java.util.ArrayList;
import java.util.List;

public class OfertasRepositoryRAM implements OfertasRepository {

    private List<Oferta> ofertas;

    public OfertasRepositoryRAM(){
        this.ofertas = new ArrayList<>();
    }

    @Override
    public List<Oferta> getAll() {
        return this.ofertas;
    }

    @Override
    public Oferta find(String titulo) {
        for (Oferta actual: this.ofertas){
            if(titulo.equals(actual.getTitulo())){
                return actual;
            }
        }
        return null;
    }

    @Override
    public Oferta save(Oferta oferta) {
        this.ofertas.add(oferta);
        Oferta insertada = this.find(oferta.getTitulo());
        return insertada;
    }

    @Override
    public Oferta update(Oferta anterior, Oferta actualizada) {
        for (Oferta actual: this.ofertas){
            if(anterior.getTitulo().equals(actualizada.getTitulo())){
                actual.setDescripcion(actualizada.getDescripcion());
                return actual;
            }
        }
        return null;
    }

    @Override
    public String delete(String titulo) {
        int index = -1;
        for (int i = 0; i < this.ofertas.size(); i++){
            Oferta actual = this.ofertas.get(i);
            if(actual.getTitulo().equals(titulo)){
                index = i;
                break;
            }
        }
        if(index >= 0){
            this.ofertas.remove(index);
            return titulo;
        }
        else return null;
    }
}
