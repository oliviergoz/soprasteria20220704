import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Fournisseur } from 'src/app/model/fournisseur';
import { CustomValidator } from 'src/app/validators/custom-validator';

@Component({
  selector: 'app-formulaire-code',
  templateUrl: './formulaire-code.component.html',
  styleUrls: ['./formulaire-code.component.css'],
})
export class FormulaireCodeComponent implements OnInit {
  form: FormGroup;
  fournisseur: Fournisseur = new Fournisseur(1, 'aaa');

  constructor() {
    this.form = new FormGroup({
      prenomCtrl: new FormControl(this.fournisseur.id, [
        Validators.required,
        Validators.minLength(2),
      ]),
      nomCtrl: new FormControl(this.fournisseur.nom, [
        Validators.required,
        CustomValidator.pasToto,
        CustomValidator.pasTexteFournis('tutu'),
      ]),
      passwordGroup: new FormGroup(
        {
          passwordCtrl: new FormControl('', Validators.required),
          confirmCtrl: new FormControl(''),
        },
        this.equals
      ),
    });
  }

  equals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    let password = group.controls['passwordCtrl'].value;
    let confirm = group.get('confirmCtrl')?.value;
    return password == confirm ? null : { equals: true };
  }

  ngOnInit(): void {}

  submit() {
    let data = {
      prenom: this.form.get('prenomCtrl')?.value,
      nom: this.form.get('nomCtrl')?.value,
      password: this.form.get('passwordGroup.passwordCtrl')?.value,
    };
    console.log(data);
  }
}
