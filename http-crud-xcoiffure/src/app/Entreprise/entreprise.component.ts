import { Component, OnInit } from '@angular/core';
import {Entreprise} from './entreprise';
import {ApiEntrepriseService} from './api-entreprise.service';

@Component({
  selector: 'app-entreprise',
  templateUrl: './entreprise.component.html',
  styleUrls: ['./entreprise.component.css']
})
export class EntrepriseComponent implements OnInit {
  public entreprises: Array<Entreprise> = new Array<Entreprise>();
  public filtre: string = '';
  public formEntreprise: Entreprise = null;

  constructor(public entreprisesService: ApiEntrepriseService) {
    this.list();
  }

  ngOnInit() {
  }

  public sauvegarder() {

    if (this.formEntreprise.id) {
      this.entreprisesService.update(this.formEntreprise).subscribe(data => this.list());
    } else {
      this.entreprisesService.create(this.formEntreprise).subscribe(data => this.list());
    }
    this.formEntreprise = null;
  }

  public filtrer() {
    return this.entreprises.filter(c =>
      c.nom.toLowerCase().indexOf(this.filtre.toLowerCase()) !== -1 ||
      c.nomGerant.toLowerCase().indexOf(this.filtre.toLowerCase()) !== -1
    );
  }

  public ajouter() {
    this.formEntreprise = new Entreprise();
  }

  public editer(id: number) {
    this.entreprisesService.findById(id).subscribe(resp => {
      this.formEntreprise = resp;
    });
  }

  public supprimer(id: number) {
    this.entreprisesService.deleteById(id).subscribe(data => this.list());
  }

  private list() {

    this.entreprisesService.findAll().subscribe(resp => {
      this.entreprises = resp;
    });
  }
}
