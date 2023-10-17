package com.cpifppiramide.ofertas;

import com.cpifppiramide.ofertas.application.OfertasUseCases;
import com.cpifppiramide.ofertas.domain.Oferta;
import com.cpifppiramide.ofertas.infrastructure.OfertasRepositoryRAM;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class OfertasUseCasesRAMTests {

    OfertasUseCases ofertasUseCases;

    public OfertasUseCasesRAMTests(){
        this.ofertasUseCases = new OfertasUseCases(
                new OfertasRepositoryRAM()
        );
    }

    @Test
    void findAll(){
        List<Oferta> ofertas = this.ofertasUseCases.getAll();
        assertEquals(0,ofertas.size());
    }

    @Test
    void save(){
        Oferta oferta = new Oferta("titulo", "descr");
        Oferta guardada = this.ofertasUseCases.save(oferta);
        assertEquals(guardada.getTitulo(),oferta.getTitulo());
    }

    @Test
    void update(){
        Oferta oferta = new Oferta("titulo actualizado", "descr");
        this.ofertasUseCases.save(oferta);
        Oferta nueva = new Oferta(oferta.getTitulo(), "desc nueva");
        Oferta actualizada = this.ofertasUseCases.update(nueva);

        assertEquals(actualizada.getDescripcion(),oferta.getDescripcion());
    }

    @Test
    void delete(){
        Oferta oferta = new Oferta("titulo a borrar", "descr");
        this.ofertasUseCases.save(oferta);
        String resultado = this.ofertasUseCases.delete(oferta.getTitulo());

        assertEquals(resultado, oferta.getTitulo());
    }



}
