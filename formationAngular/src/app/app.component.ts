import { Component } from '@angular/core';
import { DemoClass } from './formation/class/demo-class';
import { Fournisseur } from './formation/class/fournisseur';
import { Produit } from './formation/class/produit';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'formationAngular';
  input = '';
  lectureSeule = false;
  couleur = 'yellow';

  produit: Produit = new Produit('nom produit');

  sayHello(): string {
    return 'hello';
  }

  click() {
    this.input = 'click sur le bouton';
  }
}
