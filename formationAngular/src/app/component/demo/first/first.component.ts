import { Component, OnInit } from '@angular/core';
import { Fournisseur } from 'src/app/formation/class/fournisseur';

@Component({
  selector: 'first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css'],
})
export class FirstComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  getPrenom(): string {
    return 'toto';
  }

  getFournisseur(): Fournisseur {
    return new Fournisseur('frs1', 'frs1');
  }
}
