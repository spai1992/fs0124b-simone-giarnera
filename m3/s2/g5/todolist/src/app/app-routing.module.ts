import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Pages/home/home.component';
import { CompletatiComponent } from './Pages/completati/completati.component';
import { IncompletiComponent } from './Pages/incompleti/incompleti.component';
import { UtentiComponent } from './Pages/utenti/utenti.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'completati',
    component: CompletatiComponent,
  },
  {
    path: 'incompleti',
    component: IncompletiComponent,
  },
  {
    path: 'utenti',
    component: UtentiComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
