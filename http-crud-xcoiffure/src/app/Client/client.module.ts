import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ApiClientService} from './api-client.service';
import {ClientComponent} from './client.component';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';

const routes: Routes = [
  { path: 'client', component: ClientComponent }

]
@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(routes), FormsModule

  ],
  declarations: [ ClientComponent],
  providers: [
    ApiClientService
  ]

})
export class ClientModule { }
