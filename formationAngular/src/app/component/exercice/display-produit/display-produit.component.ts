import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProduitService } from 'src/app/demo/services/produit.service';
import { Produit } from 'src/app/formation/class/produit';

@Component({
  selector: 'app-display-produit',
  templateUrl: './display-produit.component.html',
  styleUrls: ['./display-produit.component.css'],
})
export class DisplayProduitComponent implements OnInit {
  @Input()
  produit: Produit | undefined;

  constructor(
    private produitService: ProduitService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.produit = this.produitService.get(params['i']);
    });
  }
}
