import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';



import { ToastyService } from 'ng2-toasty';

import { ErrorHandlerService } from '../../core/error-handler.service';
import { RecorrenciaService } from '../recorrencia.service';
import { Recorrencia } from '../../core/model';

@Component({
  selector: 'app-recorrencia-cadastro',
  templateUrl: './recorrencia-cadastro.component.html',
  styleUrls: ['./recorrencia-cadastro.component.css']
})
export class RecorrenciaCadastroComponent implements OnInit {

  recorrencia = new Recorrencia();

  constructor(
    private recorrenciaService: RecorrenciaService,
    private toasty: ToastyService,
    private errorHandler: ErrorHandlerService,
    private route: ActivatedRoute,
    private router: Router,
    private title: Title
  ) { }

  ngOnInit() {
    const codigoRecorrencia = this.route.snapshot.params['codigo'];

    this.title.setTitle('Nova recorrencia');

    if (codigoRecorrencia) {
      this.carregarRecorrencia(codigoRecorrencia);
    }
  }


  get editando() {
    return Boolean(this.recorrencia.codigo)
  }

  carregarRecorrencia(codigo: number) {
    this.recorrenciaService.buscarPorCodigo(codigo)
      .then(recorrencia => {
        this.recorrencia = recorrencia;

        this.atualizarTituloEdicao();
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  salvar(form: FormControl) {
    if (this.editando) {
      this.atualizarRecorrencia(form);
    } else {
      this.adicionarRecorrencia(form);
    }
  }

  adicionarRecorrencia(form: FormControl) {
    this.recorrenciaService.adicionar(this.recorrencia)
      .then(recorrenciaAdicionada => {
        this.toasty.success('Recorrencia adicionada com sucesso!');
        this.router.navigate(['/recorrencias', recorrenciaAdicionada.codigo]);
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  atualizarRecorrencia(form: FormControl) {
    this.recorrenciaService.atualizar(this.recorrencia)
      .then(recorrencia => {
        this.recorrencia = recorrencia;

        this.toasty.success('Recorrencia alterada com sucesso!');
        this.atualizarTituloEdicao();
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  nova(form: FormControl) {
    form.reset();

    setTimeout(function() {
      this.recorrencia = new Recorrencia();
    }.bind(this), 1);

    this.router.navigate(['/recorrencias/nova']);
  }

  atualizarTituloEdicao() {
    this.title.setTitle(`Edição de recorrencia: ${this.recorrencia.nome}`);
  }

}
