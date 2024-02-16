import {Idioma} from "../idioma/idioma";

export interface Pelicula {
  id: number;

  titulo: string;

  idioma: Idioma|null;

}
