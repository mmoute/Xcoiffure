import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from './accueil.component';
import {ApiAccueilService} from './api-accueil.service';
import {FormsModule} from '@angular/forms';

const routes: Routes = [
  { path: 'accueil', component: AccueilComponent }
];

@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(routes), FormsModule
  ],
  declarations: [
    AccueilComponent
  ],
  providers: [
    ApiAccueilService
  ]

})

  export class AccueilModule {}
