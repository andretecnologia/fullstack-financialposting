import { Http, Headers, URLSearchParams  } from '@angular/http';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';
import { Recorrencia } from '../core/model';


export class RecorrenciaFiltro {
    nome: string;
    pagina = 0;
    itensPorPagina = 5;
  }
  
@Injectable()
export class RecorrenciaService {

  recorrenciasUrl = 'http://localhost:8080/recorrencias';

  constructor(private http: Http) { }

  
  pesquisar(filtro: RecorrenciaFiltro): Promise<any> {
    const params = new URLSearchParams();
    const headers = new Headers();
    
    params.set('page', filtro.pagina.toString());
    params.set('size', filtro.itensPorPagina.toString());
    
    if (filtro.nome) {
      params.set('nome', filtro.nome);
    }
    
    return this.http.get(`${this.recorrenciasUrl}`, { headers, search: params })
    .toPromise()
    .then(response => {
      const responseJson = response.json();
      const recorrencias = responseJson.content;
      
      const resultado = {
        recorrencias,
        total: responseJson.totalElements
      };
      
      return resultado;
    })
  }
  
  listarTodas(): Promise<any> {
    const headers = new Headers();

    return this.http.get(this.recorrenciasUrl, { headers })
      .toPromise()
      .then(response => response.json().content);
  }
  
  excluir(codigo: number): Promise<void> {
    const headers = new Headers();
  
      return this.http.delete(`${this.recorrenciasUrl}/${codigo}`, { headers })
        .toPromise()
        .then(() => null);
    }
  
    adicionar(recorrencia: Recorrencia): Promise<Recorrencia> {
      const headers = new Headers();
      headers.append('Content-Type', 'application/json');
  
      return this.http.post(this.recorrenciasUrl, JSON.stringify(recorrencia), { headers })
        .toPromise()
        .then(response => response.json());
    }
  
    atualizar(recorrencia: Recorrencia): Promise<Recorrencia> {
      const headers = new Headers();
      headers.append('Content-Type', 'application/json');
  
      return this.http.put(`${this.recorrenciasUrl}/${recorrencia.codigo}`,
          JSON.stringify(recorrencia), { headers })
        .toPromise()
        .then(response => response.json() as Recorrencia);
    }
  
    buscarPorCodigo(codigo: number): Promise<Recorrencia> {
      const headers = new Headers();
  
      return this.http.get(`${this.recorrenciasUrl}/${codigo}`, { headers })
        .toPromise()
        .then(response => response.json() as Recorrencia);
    }

}