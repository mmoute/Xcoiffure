import { Component, OnInit } from '@angular/core';
import {Service} from './service';
import {ApiServiceService} from './api-service.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {
  public services: Array<Service> = new Array<Service>();
  public filtre: string = '';
  public formService: Service = null;

  constructor(public servicesService: ApiServiceService) {
    this.list();
  }

  ngOnInit() {
  }
  public sauvegarder() {
    if (this.formService.id) {
      this.servicesService.update(this.formService).subscribe(data => this.list());
    } else {
      this.servicesService.create(this.formService).subscribe(data => this.list());
    }
    this.formService = null;
  }

  public filtrer() {
    return this.services.filter(c =>
      c.nomService.toLowerCase().indexOf(this.filtre.toLowerCase()) !== -1);
  }

  public ajouter() {
    this.formService = new Service();
  }

  public editer(id: number) {
    this.servicesService.findById(id).subscribe(resp => {
      this.formService = resp;
    });
  }

  public supprimer(id: number) {
    this.servicesService.deleteById(id).subscribe(data => this.list());
  }

  private list() {

    this.servicesService.findAll().subscribe(resp => {
      this.services = resp;
    });
  }
}
