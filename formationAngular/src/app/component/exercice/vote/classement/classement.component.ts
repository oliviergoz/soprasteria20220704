import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-classement',
  templateUrl: './classement.component.html',
  styleUrls: ['./classement.component.css'],
})
export class ClassementComponent implements OnInit {
  equipe = '';
  vote = 0;

  constructor() {}

  ngOnInit(): void {}

  recuperationVote(obj: any) {
    if (obj.vote > this.vote) {
      this.vote = obj.vote;
      this.equipe = obj.equipe;
    }
  }
}
