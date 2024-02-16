import {Pelicula} from "../pelicula/pelicula";

export interface Categoria {

  id: number;

  nombre: string;

  peliculas:Pelicula[]|null;

  ultimaActualizacion: string

}
