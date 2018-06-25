import {Adresse} from '../Adresse/adresse';

export class Entreprise {
  public id: number = 0;
  constructor(public nom?: string, public adresse?: Adresse, public nomGérant?: string, public services?: Array<Service>, public employes?: Array<Employes>, public entrepriseAssocies?: Array<Adresse>) {
  }
}
