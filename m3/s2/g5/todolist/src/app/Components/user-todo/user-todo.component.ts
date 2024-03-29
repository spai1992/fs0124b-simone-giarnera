import { Component } from '@angular/core';
import { iUser } from '../../Models/user';
import { iTodo } from '../../Models/todo';
import { TodoService } from '../../Services/todo.service';
import { UserService } from '../../Services/user.service';

@Component({
  selector: 'app-user-todo',
  templateUrl: './user-todo.component.html',
  styleUrl: './user-todo.component.scss',
})
export class UserTodoComponent {
  usersWithTodos: { user: iUser; todos: iTodo[] }[] = [];

  constructor(
    private todoService: TodoService,
    private userService: UserService
  ) {}

  ngOnInit() {
    const users = this.userService.getUsers();
    this.usersWithTodos = users.map((user) => ({
      user: user,
      todos: this.todoService
        .getTodos()
        .filter((todo) => todo.userId === user.id),
    }));
  }
}
