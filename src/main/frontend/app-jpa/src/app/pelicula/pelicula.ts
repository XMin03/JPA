import {Idioma} from "../idioma/idioma";
import {Categoria} from "../categoria/categoria";

export interface Pelicula {
  id: number;

  titulo: string;

  idioma: Idioma|null;
  categoria: Categoria[]|null;
}
