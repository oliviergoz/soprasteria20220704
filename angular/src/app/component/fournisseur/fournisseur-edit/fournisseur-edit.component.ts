import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Adresse } from 'src/app/model/adresse';
import { Contact } from 'src/app/model/contact';
import { Fournisseur } from 'src/app/model/fournisseur';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-fournisseur-edit',
  templateUrl: './fournisseur-edit.component.html',
  styleUrls: ['./fournisseur-edit.component.css'],
})
export class FournisseurEditComponent implements OnInit {
  fournisseur: Fournisseur;

  constructor(
    private ar: ActivatedRoute,
    private fournisseurService: FournisseurService,
    private router: Router
  ) {
    this.fournisseur = new Fournisseur();
    this.fournisseur.contact = new Contact();
    this.fournisseur.adresse = new Adresse();
    console.log(this.fournisseur);
  }

  ngOnInit(): void {
    this.ar.params.subscribe((params) => {
      if (params['id']) {
        this.fournisseurService.getById(params['id']).subscribe((result) => {
          console.log(result);
          this.fournisseur = result;
        });
      }
    });
  }

  save() {
    console.log(this.fournisseur);
    if (this.fournisseur.id) {
      this.fournisseurService.update(this.fournisseur).subscribe((result) => {
        this.router.navigateByUrl('/fournisseur');
      });
    } else {
      this.fournisseurService.create(this.fournisseur).subscribe((result) => {
        this.router.navigateByUrl('/fournisseur');
      });
    }
  }
}
