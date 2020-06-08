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
import { RecorrenciaPesquisaComponent } from './recorrencia-pesquisa/recorrencia-pesquisa.component';
import { RecorrenciaCadastroComponent } from './recorrencia-cadastro/recorrencia-cadastro.component';
import { RecorrenciasRoutingModule } from './recorrencias-routing.module';

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
    SharedModule,
    RecorrenciasRoutingModule
  ],
  declarations: [
    RecorrenciaCadastroComponent,
    RecorrenciaPesquisaComponent,
  ],
  exports: []
})
export class RecorrenciasModule { }
