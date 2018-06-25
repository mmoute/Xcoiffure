import {Entreprise} from '../Entreprise/entreprise';

export class Employes {
  public id: number = 0;
  constructor(public nom?: string, public prenom?: string, public entreprise?: Entreprise, public indisponibilite?: boolean) {
  }
}
