import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { FormaPagamentoCadastroComponent } from './forma-pagamento-cadastro/forma-pagamento-cadastro.component';
import { FormaPagamentoPesquisaComponent } from './forma-pagamento-pesquisa/forma-pagamento-pesquisa.component';

const routes: Routes = [
  { path: 'forma-pagamento', component: FormaPagamentoPesquisaComponent },
  { path: 'forma-pagamento/nova', component: FormaPagamentoCadastroComponent },
  { path: 'forma-pagamento/:codigo', component: FormaPagamentoCadastroComponent }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class FormaPagamentoRoutingModule { }
