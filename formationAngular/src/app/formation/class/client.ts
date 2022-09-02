import { Personne } from './personne';

export class Client extends Personne {
  public constructor(prenom?: string, nom?: string) {
    super(prenom, nom);
  }
}
