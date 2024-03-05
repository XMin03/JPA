package org.iesvdm.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.jpa.domain.Categoria;
import org.iesvdm.jpa.service.CategoriaService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = {"","/"},params = {"!buscar","!ordenar","!pagina","!tamanio"})
    public List<Categoria> all() {
        log.info("Accediendo a todas las categorias");
        return this.categoriaService.all();
    }
    @GetMapping({"","/"})
    public Page<Categoria> all(@RequestParam("buscar")Optional<String> buscar,
                               @RequestParam("ordenar")Optional<String> ordenar,
                               @RequestParam(value = "pagina",defaultValue = "0")int pagina,
                               @RequestParam(value = "tamanio",defaultValue = "3")int tamanio) {
        log.info("Accediendo a todas las categorias con filtro buscar: %s y ordenar: %s",buscar.orElse("VOID"),ordenar.orElse("VOID"));
        return this.categoriaService.allByFilter(buscar,ordenar,pagina,tamanio);
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
