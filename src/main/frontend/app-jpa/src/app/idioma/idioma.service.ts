import { Injectable } from '@angular/core';
import {catchError, Observable, throwError} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Idioma} from "./idioma";

@Injectable({
  providedIn: 'root'
})
export class IdiomaService {
  private apiURL = "http://localhost:8080/idiomas";

  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<Idioma[]> {
    return this.httpClient.get<Idioma[]>(this.apiURL)
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
