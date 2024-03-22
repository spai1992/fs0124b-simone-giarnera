import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Pages/home/home.component';
import { AudiComponent } from './Pages/audi/audi.component';
import { FiatComponent } from './Pages/fiat/fiat.component';
import { FordComponent } from './Pages/ford/ford.component';
import { DettagliComponent } from './Pages/dettagli/dettagli.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'audi',
    component: AudiComponent,
  },
  {
    path: 'dettagli/:id',
    component: DettagliComponent,
  },
  {
    path: 'fiat',
    component: FiatComponent,
  },
  {
    path: 'ford',
    component: FordComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
