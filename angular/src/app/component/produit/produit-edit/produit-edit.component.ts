import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Fournisseur } from 'src/app/model/fournisseur';
import { Produit } from 'src/app/model/produit';
import { FournisseurService } from 'src/app/services/fournisseur.service';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-produit-edit',
  templateUrl: './produit-edit.component.html',
  styleUrls: ['./produit-edit.component.css'],
})
export class ProduitEditComponent implements OnInit {
  produit: Produit;
  observableFournisseur: Observable<Fournisseur[]>;

  constructor(
    private produitService: ProduitService,
    private fournisseurService: FournisseurService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.observableFournisseur = this.fournisseurService.getAll();
    this.produit = new Produit();
    // this.produit.fournisseur = new Fournisseur();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.produitService.getById(params['id']).subscribe((result) => {
          this.produit = result;
        });
      }
    });
  }

  save() {
    if (this.produit.id) {
      this.produitService.update(this.produit).subscribe(() => {
        this.router.navigateByUrl('/produit');
      });
    } else {
      this.produitService.create(this.produit).subscribe(() => {
        this.router.navigateByUrl('/produit');
      });
    }
  }

  byId(obj1: Fournisseur, obj2: Fournisseur): boolean {
    return obj1 && obj2 ? obj1.id == obj2.id : obj1 == obj2;
  }
}
