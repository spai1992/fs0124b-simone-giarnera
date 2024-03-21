import { Injectable } from '@angular/core';
import { iArticolo } from './Models/articolo';

@Injectable({
  providedIn: 'root',
})
export class ArticoliService {
  postArr: iArticolo[] = [];

  constructor() {}

  getAllArticles(): Promise<iArticolo[]> {
    return fetch('../assets/db.json')
      .then((res) => res.json())
      .then((contenutoJson) => {
        this.postArr = contenutoJson.posts;
        return this.postArr;
      });
  }

  getActiveArticle(): Promise<iArticolo[]> {
    return this.getAllArticles().then((res) => res.filter((p) => p.active));
  }

  getInactiveArticle(): Promise<iArticolo[]> {
    return this.getAllArticles().then((res) => res.filter((p) => !p.active));
  }

  getRandomposts(n: number): Promise<iArticolo[]> {
    const randomPosts: iArticolo[] = [];
    for (let i = 0; i < n; i++) {
      const rand = Math.floor(Math.random() * this.postArr.length);
      randomPosts.push(this.postArr[rand]);
    }
    return Promise.resolve(randomPosts);
  }
}
