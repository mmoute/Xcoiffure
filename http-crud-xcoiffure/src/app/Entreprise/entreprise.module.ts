import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {EntrepriseComponent} from './entreprise.component';
import {FormsModule} from '@angular/forms';
import {ApiEntrepriseService} from './api-entreprise.service';

const routes: Routes = [
{ path: 'entreprise', component: EntrepriseComponent }
];

@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(routes), FormsModule
  ],
  declarations: [
    EntrepriseComponent
  ],
  providers: [
    ApiEntrepriseService
  ]

})
export class EntrepriseModule { }
