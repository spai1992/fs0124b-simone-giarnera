import { Component, OnInit } from '@angular/core';
import { TelefonoService } from '../../telefono.service';
import { PreferitiService } from '../../preferiti.service';
import { iTelefono } from '../../Models/i-telefono';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  telefoni: iTelefono[] = [];

  constructor(
    private telefonoService: TelefonoService,
    private preferitiService: PreferitiService
  ) {}

  ngOnInit(): void {
    this.telefonoService.getAll().subscribe((dati) => {
      this.telefoni = dati;
    });
  }

  aggiungiAiPreferiti(telefono: iTelefono): void {
    console.log('Aggiungendo ai preferiti:', telefono);
    this.preferitiService.aggiungiPreferito(telefono);
  }
}
