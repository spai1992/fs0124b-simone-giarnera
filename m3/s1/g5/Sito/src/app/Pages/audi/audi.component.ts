import { Component } from '@angular/core';
import { iAuto } from '../../Modules/i-auto';
import { AutoService } from '../../auto.service';

@Component({
  selector: 'app-audi',
  templateUrl: './audi.component.html',
  styleUrl: './audi.component.scss',
})
export class AudiComponent {
  autoAudi: iAuto[] = [];
  constructor(private autoService: AutoService) {}

  ngOnInit(): void {
    this.autoService.getAllCars().then((autos) => {
      this.autoAudi = autos.filter((auto) => auto.brand === 'Audi');
    });
  }
}
