import { Component, OnInit } from '@angular/core';
import {Employes} from './employes';
import {ApiEmployesService} from './api-employes.service';

@Component({
  selector: 'app-employes',
  templateUrl: './employes.component.html',
  styleUrls: ['./employes.component.css']
})
export class EmployesComponent implements OnInit {
  public employess: Array<Employes> = new Array<Employes>();
  public filtre: string = '';
  public formEmployes: Employes = null;

  constructor(public employessService: ApiEmployesService) {
    this.list();
  }

  ngOnInit() {

  }

  public sauvegarder() {

    if (this.formEmployes.id) {
      this.employessService.update(this.formEmployes).subscribe(data => this.list());
    } else {
      this.employessService.create(this.formEmployes).subscribe(data => this.list());
    }
    this.formEmployes = null;
  }

  public filtrer() {
    return this.employess.filter(c =>
      c.nom.toLowerCase().indexOf(this.filtre.toLowerCase()) !== -1 ||
      c.prenom.toLowerCase().indexOf(this.filtre.toLowerCase()) !== -1
    );
  }

  public ajouter() {
    this.formEmployes = new Employes();
  }

  public editer(id: number) {
    this.employessService.findById(id).subscribe(resp => {
      this.formEmployes = resp;
    });
  }

  public supprimer(id: number) {
    this.employessService.deleteById(id).subscribe(data => this.list());
  }

  private list() {

    this.employessService.findAll().subscribe(resp => {
      this.employess = resp;
    });
  }
}
