package org.iesvdm.jpa.serializer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.iesvdm.jpa.domain.Pelicula;


public class PeliculaSerializer  extends StdSerializer<Pelicula> {


    public PeliculaSerializer() {
        this(null);
    }


    public PeliculaSerializer(Class < Pelicula > t) {
        super(t);
    }


    @Override
    public void serialize(Pelicula pelicula, JsonGenerator jgen,
                          SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", pelicula.getId());
        jgen.writeStringField("titulo", pelicula.getTitulo());
        jgen.writeFieldName("idioma");

        if (pelicula.getIdioma() != null) {
            jgen.writeStartObject();
            jgen.writeNumberField("id", pelicula.getIdioma().getId());
            jgen.writeStringField("nombre", pelicula.getIdioma().getNombre());
            jgen.writeEndObject();
        } else {
            jgen.writeRawValue("null");
        }

        jgen.writeEndObject();


    }
}
