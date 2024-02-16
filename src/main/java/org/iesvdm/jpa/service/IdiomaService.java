package org.iesvdm.jpa.service;

import org.iesvdm.jpa.domain.Idioma;
import org.iesvdm.jpa.repository.IdiomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IdiomaService {

    private final IdiomaRepository idiomaRepository;

    public IdiomaService(IdiomaRepository idiomaRepository) {
        this.idiomaRepository = idiomaRepository;
    }
    public List<Idioma> all() {
        return this.idiomaRepository.findAll();
    }

}
