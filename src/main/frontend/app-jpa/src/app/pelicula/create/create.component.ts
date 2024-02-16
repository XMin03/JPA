import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {PeliculaService} from "../pelicula.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrl: './create.component.css'
})
export class CreateComponent implements OnInit {
  form: FormGroup =  new FormGroup({
    titulo:  new FormControl('', [ Validators.required, Validators.pattern('^[a-zA-ZÁáÀàÉéÈèÍíÌìÓóÒòÚúÙùÑñüÜ \-\']+') ]),
    idioma_id:  new FormControl('', [ Validators.required])
  });
  constructor(
    public peliculaService: PeliculaService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }
  get f(){
    return this.form.controls;
  }
  submit(){
    console.log(this.form.value);
    this.peliculaService.create(this.form.value).subscribe(res => {
      console.log('Pelicula creada correctamente!');
      this.router.navigateByUrl('pelicula/index').then();
    })
  }
}
