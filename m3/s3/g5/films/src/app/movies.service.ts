import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { iMovies } from './Models/movies';
import { BehaviorSubject, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { iUsers } from './Models/users';

@Injectable({
  providedIn: 'root',
})
export class MoviesService {
  filmUrl = environment.filmUrl;

  userUrl = environment.usersUrl;

  filmArr: iMovies[] = [];

  userArr: iUsers[] = [];

  filmSubject = new BehaviorSubject<iMovies[]>([]);

  userSubject = new BehaviorSubject<iUsers[]>([]);

  $film = this.filmSubject.asObservable();

  $users = this.userSubject.asObservable();

  constructor(private http: HttpClient) {
    this.getAllMovies().subscribe((data) => {
      this.filmSubject.next(data);
      this.filmArr = data;
    });
    this.getAllUsers().subscribe((data) => {
      this.userSubject.next(data);
      this.userArr = data;
    });
  }

  getAllMovies() {
    return this.http.get<iMovies[]>(this.filmUrl);
  }

  deleteMovie(id: number) {
    return this.http.delete<iMovies>(this.filmUrl + '/' + id).pipe(
      tap(() => {
        this.filmArr = this.filmArr.filter((p) => p.id != id);
        this.filmSubject.next(this.filmArr);
      })
    );
  }
  getAllUsers() {
    return this.http.get<iUsers[]>(this.userUrl);
  }

  updateUsersList(): void {
    this.getAllUsers().subscribe((users) => {
      this.userSubject.next(users);
    });
  }
}
