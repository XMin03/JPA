import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {PeliculaService} from "../pelicula.service";
import {Router} from "@angular/router";
import {CategoriaService} from "../../categoria/categoria.service";
import {Select2Data} from "ng-select2-component";
import {IdiomaService} from "../../idioma/idioma.service";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrl: './create.component.css'
})
export class CreateComponent implements OnInit {
  categoria: Select2Data = [];
  idioma: Select2Data = [];

  form: FormGroup =  new FormGroup({
    titulo:  new FormControl('', [ Validators.required, Validators.pattern('^[a-zA-ZÁáÀàÉéÈèÍíÌìÓóÒòÚúÙùÑñüÜ \-\']+') ]),
    idioma:  new FormControl('', [ Validators.required]),
    categorias: new FormControl('', [ Validators.required])
  });
  constructor(
    public peliculaService: PeliculaService,
    public categoriaService: CategoriaService,
    public idiomaService: IdiomaService,
    private router: Router
  ) {
    categoriaService.getAll().subscribe(
      value => value.forEach(v=>this.categoria.push({value:{"id":v.id},label:v.nombre,data:v})));
    idiomaService.getAll().subscribe(
      value => value.forEach(v=>this.categoria.push({value:{"id":v.id},label:v.nombre,data:v})));
  }

  ngOnInit(): void {
  }
  get f(){
    return this.form.controls;
  }
  submit(){
    console.log(this.form.value);
    console.log(JSON.stringify(this.form.value));

    this.peliculaService.create(this.form.value).subscribe(res => {
      console.log('Pelicula creada correctamente!');
      this.router.navigateByUrl('pelicula/index').then();
    })
  }
  /*
  ngAfterViewInit() {
    // Use jQuery to select the element and initialize Select2
    $("#prueba").select2();
  }*/
}
