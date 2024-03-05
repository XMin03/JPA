package org.iesvdm.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.iesvdm.jpa.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CatecoriaCustomRepositoryImpl implements CatecoriaCustomRepository{
    @Autowired
    private EntityManager em;
    @Override
    public List<Categoria> queryCustomCategoria(Optional<String> buscar, Optional<String> ordenar){
        StringBuilder queryBuilder=new StringBuilder("Select c from Categoria c");
        if (buscar.isPresent()){
            queryBuilder.append(" where c.nombre like :buscar");
        }
        if (ordenar.isPresent() && (ordenar.get().equalsIgnoreCase("ASC")||ordenar.get().equalsIgnoreCase("DESC"))){
            queryBuilder.append(" order by c.nombre ").append(ordenar.get());
        }
        Query query=em.createQuery(queryBuilder.toString());
        buscar.ifPresent(s -> query.setParameter("buscar", "%" + s + "%"));
        return query.getResultList();
    }
}
