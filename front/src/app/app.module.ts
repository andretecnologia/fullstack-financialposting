import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';
import { PessoasModule } from './pessoas/pessoas.module';
import { LancamentosModule } from './lancamentos/lancamentos.module';
import { RecorrenciasModule } from './recorrencias/recorrencias.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { FormaPagamentoModule } from './forma-pagamento/forma-pagamento.module';
import { AppRoutingModule } from './app-routing.module';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    AngularFontAwesomeModule,
    FontAwesomeModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpModule,
    ReactiveFormsModule,

    CoreModule,
    DashboardModule,
    RecorrenciasModule,
    LancamentosModule,
    FormaPagamentoModule,
    PessoasModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
