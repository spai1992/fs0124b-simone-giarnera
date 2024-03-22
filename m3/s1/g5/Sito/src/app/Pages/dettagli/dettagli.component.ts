import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { iAuto } from '../../Modules/i-auto';
import { AutoService } from '../../auto.service';

@Component({
  selector: 'app-dettagli',
  templateUrl: './dettagli.component.html',
  styleUrl: './dettagli.component.scss',
})
export class DettagliComponent {
  auto: iAuto | undefined;
  id: string | null = null;

  constructor(private route: ActivatedRoute, private autoService: AutoService) {
    this.route.params.subscribe((params) => {
      this.id = params['id'];

      if (this.id) {
        this.autoService.getAutoById(this.id).then((auto) => {
          this.auto = auto;
        });
      }
    });
  }
}
