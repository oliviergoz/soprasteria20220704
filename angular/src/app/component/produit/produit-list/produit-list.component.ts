import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
  message = '';
  showMessage = false;
  constructor(
    private produitService: ProduitService,
    private activatedRoute: ActivatedRoute
  ) {
    this.observalbeProduits = this.produitService.getAll();
  }

  ngOnInit(): void {
    this.showMessage = false;
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `produit ${params['id']} créé`;
        } else {
          this.message = `produit ${params['id']} modifié`;
        }
        this.showMessage = true;
      }
    });
  }

  delete(id: number) {
    this.produitService.deleteById(id).subscribe(() => {
      this.observalbeProduits = this.produitService.getAll();
    });
  }
}
