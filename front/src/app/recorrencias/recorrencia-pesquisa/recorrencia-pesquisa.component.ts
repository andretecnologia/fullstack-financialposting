import { Title } from '@angular/platform-browser';
import { Component, OnInit, ViewChild } from '@angular/core';

import { LazyLoadEvent, ConfirmationService } from 'primeng/components/common/api';
import { ToastyService } from 'ng2-toasty';

import { ErrorHandlerService } from '../../core/error-handler.service';
import { RecorrenciaFiltro, RecorrenciaService } from '../recorrencia.service';


@Component({
  selector: 'app-recorrencia-pesquisa',
  templateUrl: './recorrencia-pesquisa.component.html',
  styleUrls: ['./recorrencia-pesquisa.component.css']
})

export class RecorrenciaPesquisaComponent implements OnInit {

  totalRegistros = 0;
  filtro = new RecorrenciaFiltro();
  recorrencias = [];
  @ViewChild('tabela') grid;

  constructor(
    private recorrenciaService: RecorrenciaService,
    private errorHandler: ErrorHandlerService,
    private confirmation: ConfirmationService,
    private toasty: ToastyService,
    private title: Title
  ) { }

  ngOnInit() {
    this.title.setTitle('Pesquisa de recorrencias');
  }

  pesquisar(pagina = 0) {
    this.filtro.pagina = pagina;

    this.recorrenciaService.pesquisar(this.filtro)
      .then(resultado => {
        this.totalRegistros = resultado.total;
        this.recorrencias = resultado.recorrencias;
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  aoMudarPagina(event: LazyLoadEvent) {
    const pagina = event.first / event.rows;
    this.pesquisar(pagina);
  }

  confirmarExclusao(recorrencia: any) {
    this.confirmation.confirm({
      message: 'Tem certeza que deseja excluir?',
      accept: () => {
        this.excluir(recorrencia);
      }
    });
  }

  excluir(recorrencia: any) {
    this.recorrenciaService.excluir(recorrencia.codigo)
      .then(() => {
        if (this.grid.first === 0) {
          this.pesquisar();
        } else {
          this.grid.first = 0;
        }

        this.toasty.success('Recorrência excluída com sucesso!');
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

}
