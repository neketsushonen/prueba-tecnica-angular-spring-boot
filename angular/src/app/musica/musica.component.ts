import { Component, OnInit,Input } from '@angular/core';
import { tipoMusica ,Encuesta} from '../tipo-musica';
import {  EncuestaService } from '../encuesta-service.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-musica',
  templateUrl: './musica.component.html',
  styleUrls: ['./musica.component.css']
})
export class MusicaComponent implements OnInit {

  tipoSeleccionado = '1';
  correoSeleccionado = '';

  tipos = tipoMusica;

  constructor(
    private route: ActivatedRoute, 
    private router: Router,
    private encuestaService: EncuestaService) { }

  ngOnInit(): void {
  }

  onSelected(value:string): void{
    this.tipoSeleccionado = value;
  }

  onChangeCorreo(value:string): void{
    this.correoSeleccionado = value;
  }

  responder(): void{
    this.encuestaService.addEncuesta(this.tipoSeleccionado, this.correoSeleccionado).subscribe( 
      result => { 
        alert("Encuesta respondida exitosamente");
        this.router.navigate(["resultado"]);
      },
      error => {
        alert(error.error.message);
      },
      () => {
        
      }
    );
   //
  }

}
