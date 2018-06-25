import {Adresse} from '../Adresse/adresse';
import {Service} from '../Service/service';
import {Employes} from '../Employes/employes';

export class Entreprise {
  public id: number = 0;
  constructor(public nom?: string, public adresse?: Adresse, public nomGerant?: string, public services?: Array<Service>, public employes?: Array<Employes>, public entrepriseAssocies?: Array<Adresse>) {
  }
}
