import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {ApiAdresseService} from './api-adresse.service';
import {AdresseComponent} from './adresse.component';


const routes: Routes = [
  { path: 'adresse', component: AdresseComponent}
  ];

    @NgModule({
      imports: [
        CommonModule, RouterModule.forChild(routes), FormsModule
      ],
      declarations: [
        AdresseComponent

      ],
      providers: [
        ApiAdresseService
      ]

    })
export class AdresseModule { }
