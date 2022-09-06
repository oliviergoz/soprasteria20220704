import { Adresse } from './adresse';
import { Contact } from './contact';

export class Fournisseur {
  constructor(
    private _id?: number,
    private _nom?: string,
    private _contact?: Contact,
    private _adresse?: Adresse
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }
  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get contact(): Contact | undefined {
    return this._contact;
  }

  public set contact(value: Contact | undefined) {
    this._contact = value;
  }
  public get adresse(): Adresse | undefined {
    return this._adresse;
  }

  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }
}
