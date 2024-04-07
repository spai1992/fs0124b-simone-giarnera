import { Component } from '@angular/core';
import { iMovies } from '../Models/movies';
import { MoviesService } from '../movies.service';

@Component({
  selector: 'app-films',
  templateUrl: './films.component.html',
  styleUrl: './films.component.scss',
})
export class FilmsComponent {
  film: iMovies[] = [];

  constructor(private filmSvc: MoviesService) {}

  ngOnInit(): void {
    this.filmSvc.$film.subscribe((film) => {
      this.film = film;
    });
  }

  deleteMovie(id: number) {
    this.filmSvc.deleteMovie(id).subscribe();
  }
}
