import { Component } from '@angular/core';
import { iArticolo } from '../../Models/articolo';
import { ArticoliService } from '../../articoli.service';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrl: './inactive-posts.component.scss',
})
export class InactivePostsComponent {
  articoliArr: iArticolo[] = [];

  constructor(private articoliSvc: ArticoliService) {}

  ngOnInit() {
    this.articoliSvc.getInactiveArticle().then((res) => {
      this.articoliArr = res;
    });
  }
}
