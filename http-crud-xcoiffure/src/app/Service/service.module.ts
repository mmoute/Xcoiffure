import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ServiceComponent} from './service.component';
import {FormsModule} from '@angular/forms';
import {ApiServiceService} from './api-service.service';

const routes: Routes = [
  { path: 'client', component: ServiceComponent }
 ];

@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(routes), FormsModule
  ],
  declarations: [
    ServiceComponent,

  ],
  providers: [
    ApiServiceService
  ]

})
export class ServiceModule { }
