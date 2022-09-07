import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from 'src/app/model/produit';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.css'],
})
export class ProduitListComponent implements OnInit {
  observalbeProduits: Observable<Produit[]>;

  constructor(private produitService: ProduitService) {
    this.observalbeProduits = this.produitService.getAll();
  }

  ngOnInit(): void {}

  delete(id: number) {
    this.produitService.deleteById(id).subscribe(() => {
      this.observalbeProduits = this.produitService.getAll();
    });
  }
}
