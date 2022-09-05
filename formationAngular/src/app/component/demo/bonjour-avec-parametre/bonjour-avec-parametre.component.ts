import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-bonjour-avec-parametre',
  templateUrl: './bonjour-avec-parametre.component.html',
  styleUrls: ['./bonjour-avec-parametre.component.css'],
})
export class BonjourAvecParametreComponent implements OnInit {
  prenom = '';
  constructor(private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    //this.prenom = this.activatedRoute.snapshot.params['prenom'];
    this.activatedRoute.params.subscribe((params) => {
      this.prenom = params['prenom'];
    });
    //on peut ne pas avoir la valeur des parameteres
  }

  goHome() {
    console.log('goHome');
    this.router.navigateByUrl('/home');
  }
}
