import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Pages/home/home.component';
import { CompletatiComponent } from './Pages/completati/completati.component';
import { IncompletiComponent } from './Pages/incompleti/incompleti.component';
import { UtentiComponent } from './Pages/utenti/utenti.component';
import { TodoComponent } from './Components/todo/todo.component';
import { HeaderComponent } from './Components/header/header.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CompletatiComponent,
    IncompletiComponent,
    UtentiComponent,
    TodoComponent,
    HeaderComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
