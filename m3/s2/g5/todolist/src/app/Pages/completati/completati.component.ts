import { Component } from '@angular/core';
import { TodoService } from '../../Services/todo.service';
import { iTodo } from '../../Models/todo';

@Component({
  selector: 'app-completati',
  templateUrl: './completati.component.html',
  styleUrl: './completati.component.scss',
})
export class CompletatiComponent {
  completedTodos: iTodo[] = [];

  constructor(private todoService: TodoService) {}

  ngOnInit() {
    this.completedTodos = this.todoService.getCompletedTodos();
  }
}
