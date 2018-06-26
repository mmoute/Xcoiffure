import {Adresse} from '../Adresse/adresse';
import {Service} from '../Service/service';
import {Employes} from '../Employes/employes';

export class Entreprise {
  public id: number = 0;
  constructor(public nom_societe?: string, public entrepriseAssocies?: Array<Adresse>,  public nom_gerant?: string, public service?: Array<Service>, public employes?: Array<Employes>) {
  }
}
