import { Component, OnInit } from '@angular/core';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent implements OnInit {
  constructor(private fournisseurService: FournisseurService) {}

  ngOnInit(): void {
    console.log('avant get1ll()');
    this.fournisseurService.getAll().subscribe((result) => {
      console.log(result);
    });
    console.log('message du component');
  }
}
