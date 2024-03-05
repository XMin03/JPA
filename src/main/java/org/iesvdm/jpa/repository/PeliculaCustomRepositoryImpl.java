package org.iesvdm.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.iesvdm.jpa.domain.Categoria;
import org.iesvdm.jpa.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaCustomRepositoryImpl implements PeliculaCustomRepository{
    @Autowired
    private EntityManager em;
    @Override
    public List<Pelicula> queryCustomPelicula(String[] ordenar) {
        StringBuilder queryBuilder=new StringBuilder("Select p from Pelicula p");
        String enUnalinea=Arrays.toString(ordenar);
        String[] fieldValue= enUnalinea
                .substring(1,enUnalinea.length()-1)//eliminar los corchetes
                .replace(" ","")//eliminar los espacios en blanco
                .split(",");//convertir en array.
        queryBuilder.append(" order by ");
        for (int i = 0; i < fieldValue.length; i++) {
            //si es primera vez no pone ","
            if (i!=0){
                queryBuilder.append(",");
            }
            //pone el campo y el sentido
            queryBuilder.append(" p."+fieldValue[i++]+" "+fieldValue[i]);
        }
        Query query=em.createQuery(queryBuilder.toString());
        return query.getResultList();
    }
}
