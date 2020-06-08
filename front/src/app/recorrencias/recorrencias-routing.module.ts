import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { RecorrenciaCadastroComponent } from './recorrencia-cadastro/recorrencia-cadastro.component';
import { RecorrenciaPesquisaComponent } from './recorrencia-pesquisa/recorrencia-pesquisa.component';

const routes: Routes = [
  { path: 'recorrencias', component: RecorrenciaPesquisaComponent },
  { path: 'recorrencias/nova', component: RecorrenciaCadastroComponent },
  { path: 'recorrencias/:codigo', component: RecorrenciaCadastroComponent }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class RecorrenciasRoutingModule { }