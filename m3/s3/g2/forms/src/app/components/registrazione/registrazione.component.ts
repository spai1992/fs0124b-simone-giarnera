import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrl: './registrazione.component.scss',
})
export class RegistrazioneComponent {
  form!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.form = this.fb.group({
      nome: this.fb.control(null),
      cognome: this.fb.control(null),
      password: this.fb.control(null),
      confermapassword: this.fb.control(null),
      genere: this.fb.control(null),
      img: this.fb.control(null),
      bio: this.fb.control(null),
      username: this.fb.control(null),
    });
  }
}
