import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { iTelefono } from './Models/i-telefono';

@Injectable({
  providedIn: 'root',
})
export class PreferitiService {
  private preferitiSource = new BehaviorSubject<iTelefono[]>([]);
  preferiti$ = this.preferitiSource.asObservable();

  constructor() {}

  aggiungiPreferito(telefono: iTelefono) {
    const preferitiAttuali = this.preferitiSource.getValue();
    const esiste = preferitiAttuali.some((t) => t.id === telefono.id);
    if (!esiste) {
      const nuoviPreferiti = [...preferitiAttuali, telefono];
      this.preferitiSource.next(nuoviPreferiti);
    }
  }
}
