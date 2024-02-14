package org.iesvdm.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.jpa.domain.Categoria;
import org.iesvdm.jpa.exeption.CategoriaNotFoundException;
import org.iesvdm.jpa.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping({"","/"})
    public List<Categoria> all() {
        log.info("Accediendo a todas las categorias");
        return this.categoriaService.all();
    }
    @PostMapping({"","/"})
    public Categoria save(@RequestBody Categoria categoria) {
        log.info("Guardando una categoria");
        return this.categoriaService.save(categoria);
    }
    @GetMapping("/{id}")
    public Categoria one(@PathVariable("id") Long id) {
        return this.categoriaService.one(id);
    }
    @PutMapping("/{id}")
    public Categoria replace(@PathVariable("id") Long id, @RequestBody Categoria pelicula) {
        return this.categoriaService.replace(id, pelicula);
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.categoriaService.delete(id);
    }
}
