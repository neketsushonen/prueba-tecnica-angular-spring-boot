import { Injectable } from '@angular/core';
import { HttpClient,HttpParams ,HttpHeaders} from '@angular/common/http';
import {Encuesta} from './tipo-musica';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EncuestaService {

  encuestas: Encuesta[] = [];
  
  constructor( private http: HttpClient) {
    
  }


  getEncuestas() {
    const configUrl= '/encuesta';
    return this.http.get<Encuesta[]>(configUrl);

    
     
  }

  addEncuesta(tipo:string,correo:string ) {

    const configUrl= '/encuesta';
    const params = new HttpParams({  fromObject: { id : tipo,  correo : correo    }  });
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
   
    return this.http.post(configUrl, params, { headers });
    
    //this.encuestas.push({id: Number(tipo), correo:correo});
  }
}
