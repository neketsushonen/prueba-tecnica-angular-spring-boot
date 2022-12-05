export interface TipoMusica {
  id: number;
  name: string;
  
}

export const tipoMusica = [
  {
    id: 1,
    name: 'Rock' 
  },
  {
    id: 2,
    name: 'Pop' 
  },
  {
    id: 3,
    name: 'Jazz' 
  },
  {
    id: 4,
    name: 'Clásica' 
  },
];

export interface Encuesta    {
  id: number,
  correo: string
}

/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/