import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InputMaskModule } from 'primeng/components/inputmask/inputmask';
import { DataTableModule } from 'primeng/components/datatable/datatable';
import { ButtonModule } from 'primeng/components/button/button';
import { InputTextModule } from 'primeng/components/inputtext/inputtext';
import { TooltipModule } from 'primeng/components/tooltip/tooltip';
import { DropdownModule } from 'primeng/dropdown';
import { PanelModule } from 'primeng/panel';
import { DialogModule } from 'primeng/dialog';
import { TableModule } from 'primeng/table';
import { SharedModule } from './../shared/shared.module';
import { FormaPagamentoRoutingModule } from './forma-pagamento-routing.module';
import { FormaPagamentoCadastroComponent } from './forma-pagamento-cadastro/forma-pagamento-cadastro.component';
import { FormaPagamentoPesquisaComponent } from './forma-pagamento-pesquisa/forma-pagamento-pesquisa.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,

    InputTextModule,
    ButtonModule,
    DataTableModule,
    TooltipModule,
    InputMaskModule,
    PanelModule,
    DialogModule,
    DropdownModule,
    TableModule,
    FormaPagamentoRoutingModule,
    SharedModule

  ],
  declarations: [FormaPagamentoCadastroComponent, FormaPagamentoPesquisaComponent]
})
export class FormaPagamentoModule { }
