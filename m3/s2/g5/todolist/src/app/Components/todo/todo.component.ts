import { Component, OnInit, Input } from '@angular/core';
import { iTodo } from '../../Models/todo';
import { iUser } from '../../Models/user';
import { TodoService } from '../../Services/todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss'],
})
export class TodoComponent implements OnInit {
  @Input() todo!: iTodo;
  user?: iUser;

  constructor(private todoService: TodoService) {}

  ngOnInit() {
    if (this.todo) {
      console.log('Todo:', this.todo);

      this.user = this.todoService.getUserByTodoId(this.todo.id);
    }
  }

  onCheckboxChange() {
    this.todoService.toggleTodoCompleted(this.todo.id);
  }
}
