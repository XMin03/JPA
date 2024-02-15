import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PeliculaRoutingModule } from './pelicula-routing.module';
import {EditComponent} from "./edit/edit.component";
import {CreateComponent} from "./create/create.component";
import {IndexComponent} from "./index/index.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    IndexComponent,
    CreateComponent,
    EditComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    PeliculaRoutingModule
  ]
})
export class PeliculaModule { }
