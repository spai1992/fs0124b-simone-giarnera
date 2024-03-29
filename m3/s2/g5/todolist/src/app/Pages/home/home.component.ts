import { Component } from '@angular/core';
import { TodoService } from '../../Services/todo.service';
import { iTodo } from '../../Models/todo';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  todos: iTodo[] = [];

  constructor(private todoService: TodoService) {}

  ngOnInit() {
    this.todos = this.todoService.getTodos();
  }
}
