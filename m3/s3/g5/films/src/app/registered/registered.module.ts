import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisteredRoutingModule } from './registered-routing.module';
import { RegisteredComponent } from './registered.component';


@NgModule({
  declarations: [
    RegisteredComponent
  ],
  imports: [
    CommonModule,
    RegisteredRoutingModule
  ]
})
export class RegisteredModule { }
