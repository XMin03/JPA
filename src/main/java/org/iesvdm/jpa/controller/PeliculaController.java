package org.iesvdm.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.jpa.domain.Pelicula;
import org.iesvdm.jpa.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping({"","/"})
    public Map<String,Object> all(@RequestParam(value = "orden",defaultValue = "id,asc") String[] order,
                                  @RequestParam(value = "pagina",defaultValue = "0,3") int[] pagina) {
        log.info("Accediendo a todas las películas");
        return this.peliculaService.all(order,pagina);
    }

    @PostMapping({"","/"})
    public Pelicula save(@RequestBody Pelicula pelicula) {
        return this.peliculaService.save(pelicula);
    }

    @GetMapping("/{id}")
    public Pelicula one(@PathVariable("id") Long id) {
        return this.peliculaService.one(id);
    }

    @PutMapping("/{id}")
    public Pelicula replace(@PathVariable("id") Long id, @RequestBody Pelicula pelicula) {
        return this.peliculaService.replace(id, pelicula);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.peliculaService.delete(id);
    }


}
