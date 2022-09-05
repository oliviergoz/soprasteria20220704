import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Produit } from 'src/app/formation/class/produit';

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css'],
})
export class EditProduitComponent implements OnInit {
  produit: Produit = new Produit();

  @Output()
  produitEvent: EventEmitter<any> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  send() {
    this.produitEvent.emit({ nom: this.produit.nom, prix: this.produit.prix });
  }
}
