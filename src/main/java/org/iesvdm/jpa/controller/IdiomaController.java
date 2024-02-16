package org.iesvdm.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.jpa.domain.Idioma;
import org.iesvdm.jpa.domain.Pelicula;
import org.iesvdm.jpa.service.IdiomaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/idiomas")
public class IdiomaController {
    private final IdiomaService idiomaService;

    public IdiomaController(IdiomaService idiomaService) {
        this.idiomaService = idiomaService;
    }


    @GetMapping({"","/"})
    public List<Idioma> all() {
        log.info("Accediendo a todas las películas");
        return this.idiomaService.all();
    }
}
