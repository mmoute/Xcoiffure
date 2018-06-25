import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {EmployesComponent} from './employes.component';
import {ApiEmployesService} from './api-employes.service';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';

const routes: Routes = [
  { path: 'employes', component: EmployesComponent }
];
@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(routes), FormsModule
  ],
  declarations: [
    EmployesComponent
  ],
  providers: [
    ApiEmployesService
  ]
})

export class EmployesModule { }
