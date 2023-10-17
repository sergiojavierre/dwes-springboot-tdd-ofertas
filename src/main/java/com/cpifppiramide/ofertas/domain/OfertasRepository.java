package com.cpifppiramide.ofertas.domain;

import java.util.List;

public interface OfertasRepository {

    public List<Oferta> getAll();
    public Oferta find(String titulo);
    public Oferta save(Oferta oferta);
    public Oferta update(Oferta anterior, Oferta actualizada);
    public String delete(String titulo);

}
