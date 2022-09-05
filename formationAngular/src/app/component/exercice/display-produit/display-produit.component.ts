import { Component, Input, OnInit } from '@angular/core';
import { Produit } from 'src/app/formation/class/produit';

@Component({
  selector: 'app-display-produit',
  templateUrl: './display-produit.component.html',
  styleUrls: ['./display-produit.component.css'],
})
export class DisplayProduitComponent implements OnInit {
  @Input()
  produit: Produit | undefined;

  constructor() {}

  ngOnInit(): void {}
}
