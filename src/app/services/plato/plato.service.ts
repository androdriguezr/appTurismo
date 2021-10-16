import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PlatoService {
URL_BASE = environment.API_URL;

  constructor(private http: HttpClient) { }

  InsertRecord(data: any, id: any): Observable<any> {
    return this.http.post(`${this.URL_BASE}plato/nuevo/${id}`, data);
  }

  UpdateRecord(data: any, id: any): Observable<any> {
    return this.http.put(`${this.URL_BASE}plato/actualizar/${id}`, data);
  }

  DeleteItemRecord(id: any): Observable<any> {
    return this.http.delete(`${this.URL_BASE}plato/eliminar/${id}`);
  }

  BuscarPlatoById(id: any) {
    const responce = fetch(`${this.URL_BASE}plato/buscarbyid/${id}`);
    return responce;
  }

  async BuscarPlatoPorNombre(nombre: any) {
    const responce = await fetch(`${this.URL_BASE}plato/buscarbyname/${nombre}`);
    return await responce.json();
  }

  async listarPlatos() {
    const responce = await fetch(`${this.URL_BASE}plato/listartodos`);
    return await responce.json();
  }
}
