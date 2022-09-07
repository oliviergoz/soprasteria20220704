import { Fournisseur } from './fournisseur';

export class Produit {
  constructor(
    private _id?: number,
    private _libelle?: string,
    private _description?: string,
    private _prixUnitaire?: number,
    private _fournisseur?: Fournisseur
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get libelle(): string | undefined {
    return this._libelle;
  }

  public set libelle(value: string | undefined) {
    this._libelle = value;
  }
  public get description(): string | undefined {
    return this._description;
  }

  public set prixUnitaire(value: number | undefined) {
    this._prixUnitaire = value;
  }
  public get prixUnitaire(): number | undefined {
    return this._prixUnitaire;
  }

  public set description(value: string | undefined) {
    this._description = value;
  }
  public get fournisseur(): Fournisseur | undefined {
    return this._fournisseur;
  }

  public set fournisseur(value: Fournisseur | undefined) {
    this._fournisseur = value;
  }
}
