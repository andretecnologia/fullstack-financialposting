import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { environment } from '../../environments/environment';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class CategoriaService {

  baseUrl = environment.baseUrl;

  categoriasUrl = this.baseUrl + '/categorias';

  constructor(private http: Http) { }

  listarTodas(): Promise<any> {
    const headers = new Headers();

    return this.http.get(this.categoriasUrl, { headers })
      .toPromise()
      .then(response => response.json());
  }

}
