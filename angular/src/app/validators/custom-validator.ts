import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export class CustomValidator {
  public static pasToto(control: AbstractControl): ValidationErrors | null {
    return control.value === 'toto' ? { toto: true } : null;
  }

  public static pasTexteFournis(texte: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      return control.value === texte ? { texteInterdit: true } : null;
    };
  }
}
