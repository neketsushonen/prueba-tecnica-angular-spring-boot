import { Component, OnInit } from '@angular/core';
import { tipoMusica,Encuesta } from '../tipo-musica';
import { EncuestaService } from '../encuesta-service.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-resultado',
  templateUrl: './resultado.component.html',
  styleUrls: ['./resultado.component.css']
})
export class ResultadoComponent implements OnInit {
  encuestas: Encuesta[] = [];

  constructor(private encuestaService: EncuestaService) { }

  ngOnInit(): void {
    this.encuestaService.getEncuestas().subscribe((data:any)=>{
      this.encuestas = data.data;
    });

  }

  getLista(): Encuesta[]{
   
    return this.encuestas;
  } 

  getTipo(id:number){
    const result = tipoMusica.find((obj) => {
      return obj.id === id;
    });
    return result?.name;
  }
}
