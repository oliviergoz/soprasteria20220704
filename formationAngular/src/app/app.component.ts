import { Component } from '@angular/core';
import { DemoClass } from './formation/class/demo-class';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'formationAngular';

  obj: DemoClass = new DemoClass();
}
