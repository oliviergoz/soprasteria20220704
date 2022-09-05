import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css'],
})
export class VoteComponent implements OnInit {
  vote = 0;
  @Input()
  equipe = '';
  @Output()
  voterEvent: EventEmitter<any> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  voter() {
    this.vote++;
    this.voterEvent.emit({ equipe: this.equipe, vote: this.vote });
  }
}
