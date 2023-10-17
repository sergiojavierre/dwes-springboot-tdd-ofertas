package com.cpifppiramide.ofertas.infrastructure;


import com.cpifppiramide.ofertas.application.OfertasUseCases;
import com.cpifppiramide.ofertas.domain.Oferta;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfertasRestController {

    private OfertasUseCases ofertasUseCases;

    public OfertasRestController(){
        this.ofertasUseCases = new OfertasUseCases(
                new OfertasRepositoryRAM()
        );
    }

    @GetMapping("/ofertas")
    List<Oferta> getAll(){
       return this.ofertasUseCases.getAll();
    }

    @GetMapping("/ofertas/{titulo}")
    Oferta find(@PathVariable String titulo){
        return this.ofertasUseCases.find(titulo);
    }

    @PostMapping(path = "/ofertas", consumes = MediaType.APPLICATION_JSON_VALUE)
    Oferta save(@RequestBody Oferta oferta){
        return this.ofertasUseCases.save(oferta);
    }

    @PutMapping(path = "/ofertas/{titulo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Oferta update(@PathVariable String titulo, @RequestBody String descripcion){
        return this.ofertasUseCases.update(new Oferta(titulo, descripcion));
    }

    @DeleteMapping("/ofertas/{titulo}")
    String delete(@PathVariable String titulo){
        return this.ofertasUseCases.delete(titulo);
    }

}
