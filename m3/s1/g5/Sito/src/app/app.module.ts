import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FiatComponent } from './Pages/fiat/fiat.component';
import { AudiComponent } from './Pages/audi/audi.component';
import { FordComponent } from './Pages/ford/ford.component';
import { HeaderComponent } from './Components/header/header.component';
import { FooterComponent } from './Components/footer/footer.component';
import { HomeComponent } from './Pages/home/home.component';
import { DettagliComponent } from './Pages/dettagli/dettagli.component';
import { Routes } from '@angular/router';

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
  declarations: [
    AppComponent,
    FiatComponent,
    AudiComponent,
    FordComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    DettagliComponent,
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
