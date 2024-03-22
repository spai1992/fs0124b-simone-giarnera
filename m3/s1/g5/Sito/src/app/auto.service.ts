import { Injectable } from '@angular/core';
import { iAuto } from './Modules/i-auto';

@Injectable({
  providedIn: 'root',
})
export class AutoService {
  autoArr: iAuto[] = [];
  autoRandom: iAuto[] = [];

  getAllCars(): Promise<iAuto[]> {
    return fetch('../assets/db.json')
      .then((res) => res.json())
      .then((res: iAuto[]) => res);
  }

  getBrandLogos(): string[] {
    const brandLogos: string[] = [];

    this.autoArr.forEach((auto) => {
      if (!brandLogos.includes(auto.brandLogo)) {
        brandLogos.push(auto.brandLogo);
      }
    });
    return brandLogos;
    console.log(brandLogos);
  }

  getRandom(num: number): void {
    const disponibili: number[] = [];
    this.autoRandom = [];

    const findRandomAuto = () => {
      let counter = 0;
      this.autoArr.forEach((auto) => {
        if (counter === num) return;
        const index = Math.floor(Math.random() * this.autoArr.length);
        if (!disponibili.includes(index)) {
          disponibili.push(index);
          this.autoRandom.push(auto);
          counter++;
        }
      });
      if (this.autoRandom.length < num) findRandomAuto();
    };

    findRandomAuto();
  }

  getAutoById(id: string): Promise<iAuto | undefined> {
    return this.getAllCars().then((res) => res.find((p) => p.id == id));
  }
}
