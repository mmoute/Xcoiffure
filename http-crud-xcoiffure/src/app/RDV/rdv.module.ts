import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {ApiRdvService} from './api-rdv.service';
import {RdvComponent} from './rdv.component';


const routes: Routes = [
  { path: 'client', component: RdvComponent}
  ];

    @NgModule({
      imports: [
        CommonModule, RouterModule.forChild(routes), FormsModule
      ],
      declarations: [
        RdvComponent

      ],
      providers: [
        ApiRdvService
      ]

    })
export class RdvModule { }
