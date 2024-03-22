import { Component } from '@angular/core';
import { AutoService } from '../../auto.service';
import { iAuto } from '../../Modules/i-auto';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  brandLogos: string[] = [];
  randomAuto: iAuto[] = [];

  constructor(private autoService: AutoService) {}

  ngOnInit(): void {
    this.autoService.getAllCars().then((autos) => {
      this.autoService.autoArr = autos;
      this.brandLogos = this.autoService.getBrandLogos();
      this.autoService.getRandom(2);
      this.randomAuto = this.autoService.autoRandom;
    });
  }
}
