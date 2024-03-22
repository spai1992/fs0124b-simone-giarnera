import { Component } from '@angular/core';
import { iAuto } from '../../Modules/i-auto';
import { AutoService } from '../../auto.service';

@Component({
  selector: 'app-fiat',
  templateUrl: './fiat.component.html',
  styleUrl: './fiat.component.scss',
})
export class FiatComponent {
  autoFiat: iAuto[] = [];
  constructor(private autoService: AutoService) {}

  ngOnInit(): void {
    this.autoService.getAllCars().then((autos) => {
      this.autoFiat = autos.filter((auto) => auto.brand === 'Fiat');
    });
  }
}
