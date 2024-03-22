import { Component } from '@angular/core';
import { iAuto } from '../../Modules/i-auto';
import { AutoService } from '../../auto.service';

@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrl: './ford.component.scss',
})
export class FordComponent {
  autoFord: iAuto[] = [];
  constructor(private autoService: AutoService) {}

  ngOnInit(): void {
    this.autoService.getAllCars().then((autos) => {
      this.autoFord = autos.filter((auto) => auto.brand === 'Ford');
    });
  }
}
