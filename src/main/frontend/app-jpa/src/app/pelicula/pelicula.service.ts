import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {Pelicula} from "./pelicula";

@Injectable({
  providedIn: 'root'
})
export class PeliculaService {
  private apiURL = "http://localhost:8080/peliculas";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<Pelicula[]> {
    return this.httpClient.get<Pelicula[]>(this.apiURL)
      .pipe(
        catchError(this.errorHandler)
      )
  }
  create(pelicula: Pelicula): Observable<Pelicula> {
    return this.httpClient.post<Pelicula>(this.apiURL, JSON.stringify(pelicula), this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }
  delete(id: number){
    return this.httpClient.delete<Pelicula>(this.apiURL + id, this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  errorHandler(error: any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }

    return throwError(() => errorMessage);
  }
}
