import { Component, Input, OnInit } from '@angular/core';
import { Fournisseur } from 'src/app/formation/class/fournisseur';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css'],
})
export class HelloComponent implements OnInit {
  @Input()
  prenom = 'olivier';

  @Input('nom')
  lastName = '';

  @Input()
  fournisseur: Fournisseur | undefined;

  constructor() {}

  ngOnInit(): void {}
}
