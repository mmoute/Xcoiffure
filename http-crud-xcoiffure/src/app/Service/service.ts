export class Service {
  public id: number = 0;
  constructor(public nomService?: string, public prix?: number, public temps?: number, public entreprise?: Entreprise, public rdvs?: List<Rdv>) {
  }
}
