import { Component } from '@angular/core';
import { ArticoliService } from '../../articoli.service';
import { iArticolo } from '../../Models/articolo';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrl: './active-posts.component.scss',
})
export class ActivePostsComponent {
  articoliArr: iArticolo[] = [];

  constructor(private articoliSvc: ArticoliService) {}

  ngOnInit() {
    this.articoliSvc.getActiveArticle().then((res) => {
      this.articoliArr = res;
    });
  }
}
