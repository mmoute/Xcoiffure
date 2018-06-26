import { Component, OnInit } from '@angular/core';
import {Adresse} from './adresse';
import {ApiAdresseService} from './api-adresse.service';

@Component({
  selector: 'app-adresse',
  templateUrl: './adresse.component.html',
  styleUrls: ['./adresse.component.css']
})
export class AdresseComponent implements OnInit {
  public adresses: Array<Adresse> = new Array<Adresse>();
  public filtre: string = '';
  public formAdresse: Adresse = null;

  constructor(public adressesService: ApiAdresseService) {
    this.list();
  }

  ngOnInit() {

  }

  public sauvegarder() {

    if (this.formAdresse.id) {
      this.adressesService.update(this.formAdresse).subscribe(data => this.list());
    } else {
      this.adressesService.create(this.formAdresse).subscribe(data => this.list());
    }
    this.formAdresse = null;
  }

  public filtrer() {
    return this.adresses.filter(a =>
      a.rue.toLowerCase().indexOf(this.filtre.toLowerCase()) !== -1 ||
      a.ville.toLowerCase().indexOf(this.filtre.toLowerCase()) !== -1
    );
  }

  public ajouter() {
    this.formAdresse = new Adresse();
  }

  public editer(id: number) {
    this.adressesService.findById(id).subscribe(resp => {
      this.formAdresse = resp;
    });
  }

  public supprimer(id: number) {
    this.adressesService.deleteById(id).subscribe(data => this.list());
  }

  private list() {

    this.adressesService.findAll().subscribe(resp => {
      this.adresses = resp;
    });
  }
}
