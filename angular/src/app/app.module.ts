import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MusicaComponent } from './musica/musica.component';
import { ResultadoComponent } from './resultado/resultado.component';
import { AcercadeComponent } from './acercade/acercade.component';

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: MusicaComponent },
      { path: 'resultado', component: ResultadoComponent },
      { path: 'acercade', component: AcercadeComponent },
      

    ])
  ],
  declarations: [
    AppComponent,
    
    MusicaComponent,
    ResultadoComponent,
    AcercadeComponent
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/