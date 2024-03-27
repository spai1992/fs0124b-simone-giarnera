import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { iTelefono } from './Models/i-telefono';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TelefonoService {
  apiUrl: string = 'https://dummyjson.com/products';

  constructor(private http: HttpClient) {}

  getAll(): Observable<iTelefono[]> {
    return this.http
      .get<{ products: iTelefono[] }>(this.apiUrl)
      .pipe(map((response) => response.products));
  }
}
