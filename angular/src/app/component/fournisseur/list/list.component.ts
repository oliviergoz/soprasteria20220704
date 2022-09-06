import { Component, OnInit } from '@angular/core';
import { Fournisseur } from 'src/app/model/fournisseur';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent implements OnInit {
  fournisseurs: Fournisseur[] = [];

  constructor(private fournisseurService: FournisseurService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.fournisseurService.getAll().subscribe((result) => {
      this.fournisseurs = result;
    });
  }

  delete(id: number) {
    this.fournisseurService.deleteById(id).subscribe(() => {
      this.list();
    });
  }
}
