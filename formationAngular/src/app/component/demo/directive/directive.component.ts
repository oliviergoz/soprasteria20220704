import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/formation/class/produit';

@Component({
  selector: 'app-directive',
  templateUrl: './directive.component.html',
  styleUrls: ['./directive.component.css'],
})
export class DirectiveComponent implements OnInit {
  tabTexte = ['toto', 'tutu', 'tata'];

  produits = [new Produit('ttt', 111), new Produit('lll', 111)];

  constructor() {}

  ngOnInit(): void {}
}
