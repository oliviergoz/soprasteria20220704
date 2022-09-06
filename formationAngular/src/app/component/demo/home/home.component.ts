import { Component, OnInit } from '@angular/core';
import { DemoService } from 'src/app/demo/services/demo.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(private demoService: DemoService) {}

  ngOnInit(): void {}

  public get demo(): DemoService {
    return this.demoService;
  }

  public get message(): string {
    return this.demoService.sayHello();
  }
}
