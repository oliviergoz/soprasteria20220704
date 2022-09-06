export class Contact {
  constructor(
    private _prenom?: string,
    private _nom?: string,
    private _mail?: string
  ) {}

  public get prenom(): string | undefined {
    return this._prenom;
  }

  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get mail(): string | undefined {
    return this._mail;
  }

  public set mail(value: string | undefined) {
    this._mail = value;
  }
}
