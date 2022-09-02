export class DemoClass {
  // private _nom: string = 'olivier';

  public constructor(private _nom?: string) {}

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public sayHello(): string {
    return 'hello world';
  }
}
