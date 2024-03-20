import { Component } from '@angular/core';
import { iArticolo } from './Models/articolo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  articoliArr: iArticolo[] = [];
  randomArray: iArticolo[] = [];

  ngOnInit() {
    fetch('../assets/db.json')
      .then((articoli) => articoli.json())
      .then((articolo) => {
        this.articoliArr = articolo.posts;
        this.generaArrayRandom();
      });
  }

  generaNumeroRandom() {
    let index: number = Math.floor(Math.random() * this.articoliArr.length);
    return index;
  }

  generaArrayRandom() {
    for (let i = 0; i < 4; i++) {
      this.randomArray.push(this.articoliArr[this.generaNumeroRandom()]);
    }
  }
}
