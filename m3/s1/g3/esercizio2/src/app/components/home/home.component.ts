import { Component, OnInit } from '@angular/core';
import { iArticolo } from '../../Models/articolo';
import { ArticoliService } from '../../articoli.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  articoliArr: iArticolo[] = [];

  constructor(private articoliSvc: ArticoliService) {}

  ngOnInit() {
    this.articoliSvc.getAllArticles().then(() => {
      this.articoliSvc.getRandomposts(4).then((randomPosts: iArticolo[]) => {
        this.articoliArr = randomPosts;
      });
    });
  }
}
