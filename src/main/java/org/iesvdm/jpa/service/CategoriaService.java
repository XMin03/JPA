package org.iesvdm.jpa.service;

import org.iesvdm.jpa.domain.Categoria;
import org.iesvdm.jpa.exception.CategoriaNotFoundException;
import org.iesvdm.jpa.repository.CatecoriaCustomRepositoryImpl;
import org.iesvdm.jpa.repository.CategoriaRepository;
import org.iesvdm.jpa.util.ListToPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final CatecoriaCustomRepositoryImpl customRepository;
    public CategoriaService(CategoriaRepository categoriaRepository, CatecoriaCustomRepositoryImpl customRepository) {
        this.categoriaRepository = categoriaRepository;
        this.customRepository = customRepository;
    }
    public Map<String,Object> allByFilter(Optional<String> buscar, Optional<String> order,int pagina,int tamaño) {
        Pageable p= PageRequest.of(pagina,tamaño);
        List<Categoria> list=this.customRepository.queryCustomCategoria(buscar,order);
        Page<Categoria> page= ListToPage.convertToPage(list,p);
        Map<String,Object> res=new HashMap<>();
        res.put("categorias",page.getContent());
        res.put("currentPage",page.getNumber());
        res.put("totalItems",page.getTotalElements());
        res.put("totalPages",page.getTotalPages());
        return res;
    }

    public List<Categoria> all() {
        return this.categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    public Categoria one(Long id) {
        return this.categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public Categoria replace(Long id, Categoria categoria) {

        return this.categoriaRepository.findById(id).map( p -> (id.equals(categoria.getId())  ?
                        this.categoriaRepository.save(categoria) : null))
                .orElseThrow(() -> new CategoriaNotFoundException(id));

    }

    public void delete(Long id) {
        this.categoriaRepository.findById(id).map(c -> {
            c.getPeliculas().forEach(pelicula -> pelicula.getCategorias().remove(c));
            this.categoriaRepository.delete(c);
                    return c;})
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

}
