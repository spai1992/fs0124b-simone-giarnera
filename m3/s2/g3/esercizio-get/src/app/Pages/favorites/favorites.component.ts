import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { PreferitiService } from '../../preferiti.service';
import { iTelefono } from '../../Models/i-telefono';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.scss'],
})
export class FavoritesComponent implements OnInit, OnDestroy {
  preferiti: iTelefono[] = [];
  private subscription: Subscription = new Subscription();

  constructor(private preferitiService: PreferitiService) {}

  ngOnInit(): void {
    this.subscription = this.preferitiService.preferiti$.subscribe({
      next: (preferiti) => {
        this.preferiti = preferiti;
      },
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
