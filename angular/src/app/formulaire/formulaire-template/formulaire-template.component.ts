import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-formulaire-template',
  templateUrl: './formulaire-template.component.html',
  styleUrls: ['./formulaire-template.component.css'],
})
export class FormulaireTemplateComponent implements OnInit {
  texte: string = '';
  constructor() {}

  ngOnInit(): void {}

  submit(monForm: any) {
    let form = monForm as FormGroup;
    console.log(monForm.controls['texte'].valid);
    console.log(form.valid);
  }
}
