import { Component } from '@angular/core';
import { MoviesService } from '../movies.service';
import { iUsers } from '../Models/users';

@Component({
  selector: 'app-registered',
  templateUrl: './registered.component.html',
  styleUrl: './registered.component.scss',
})
export class RegisteredComponent {
  users: iUsers[] = [];

  constructor(private usersSvc: MoviesService) {}

  ngOnInit(): void {
    this.usersSvc.$users.subscribe((users) => {
      this.users = users;
    });
  }
}
