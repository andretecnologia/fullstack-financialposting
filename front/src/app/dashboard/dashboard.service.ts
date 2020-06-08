import { Http, Headers, URLSearchParams } from '@angular/http';
import { Injectable } from '@angular/core';


import 'rxjs/operator/toPromise';
import * as moment from 'moment';

import { environment } from './../../environments/environment';

@Injectable()
export class DashboardService {

  lancamentosUrl: string;

  constructor(private http: Http) {
    this.lancamentosUrl = `http://localhost:8080/lancamentos`;
  }

  lancamentosPorCategoria(): Promise<Array<any>> {
    return this.http.get(`http://localhost:8080/lancamentos/estatisticas/por-categoria`)
      .toPromise()
      .then(response => response.json());
  }

  lancamentosPorDia(): Promise<Array<any>> {
    return this.http.get(`http://localhost:8080/lancamentos/estatisticas/por-dia`)
      .toPromise()
      .then(response => {
        const dados = response.json();
        this.converterStringsParaDatas(dados);

        return dados;
      });
  }

  private converterStringsParaDatas(dados: Array<any>) {
    for (const dado of dados) {
      dado.dia = moment(dado.dia, 'YYYY-MM-DD').toDate();
    }
  }

  servicePessoas(): Promise<any> {
    return this.http.get(`http://localhost:8080/pessoas/total`)
    .toPromise()
    .then(response => {
      const responseJson = response.json();
      const total = responseJson;
      const retorno = { total };
    return retorno;

    });
  }

  serviceCategorias(): Promise<any> {
    return this.http.get(`http://localhost:8080/categorias/total`)
    .toPromise()
    .then(response => {
      const responseJson = response.json();
      const total = responseJson;
      const retorno = { total };
    return retorno;

    });
  }

  serviceRecorrencias(): Promise<any> {
    return this.http.get(`http://localhost:8080/recorrencias/total`)
    .toPromise()
    .then(response => {
      const responseJson = response.json();
      const total = responseJson;
      const retorno = { total };
    return retorno;

    });
  }

  serviceLancamentos(): Promise<any> {
    return this.http.get(`http://localhost:8080/lancamentos/total`)
    .toPromise()
    .then(response => {
      const responseJson = response.json();
      const total = responseJson;
      const retorno = { total };
    return retorno;

    });
  }


}
