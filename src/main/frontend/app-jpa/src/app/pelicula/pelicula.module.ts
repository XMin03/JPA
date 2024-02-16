import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PeliculaRoutingModule } from './pelicula-routing.module';
import {EditComponent} from "./edit/edit.component";
import {CreateComponent} from "./create/create.component";
import {IndexComponent} from "./index/index.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Select2Module} from "ng-select2-component";


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
        PeliculaRoutingModule,
        Select2Module
    ]
})
export class PeliculaModule { }
