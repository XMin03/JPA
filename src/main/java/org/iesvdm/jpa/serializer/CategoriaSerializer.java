package org.iesvdm.jpa.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.iesvdm.jpa.domain.Categoria;
import org.iesvdm.jpa.domain.Pelicula;

import java.io.IOException;

public class CategoriaSerializer  extends StdSerializer<Categoria> {


    public CategoriaSerializer() {
        this(null);
    }


    public CategoriaSerializer(Class <Categoria> t) {
        super(t);
    }


    @Override
    public void serialize(Categoria categoria, JsonGenerator jgen,
                          SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", categoria.getId());
        jgen.writeStringField("nombre", categoria.getNombre());
        jgen.writeFieldName("peliculas");
        jgen.writeObject(categoria.getPeliculas());
        jgen.writeEndObject();
    }
}
