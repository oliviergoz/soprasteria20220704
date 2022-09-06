import { Routes } from '@angular/router';
import { BonjourAvecParametreComponent } from './component/demo/bonjour-avec-parametre/bonjour-avec-parametre.component';
import { HelloComponent } from './component/demo/hello/hello.component';
import { HomeComponent } from './component/demo/home/home.component';
import { PageNotFoundComponent } from './component/demo/page-not-found/page-not-found.component';
import { DisplayProduitComponent } from './component/exercice/display-produit/display-produit.component';
import { ProduitsComponent } from './component/exercice/produits/produits.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ProduitsComponent },
  { path: 'bonjour/:prenom', component: BonjourAvecParametreComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'produit/:i', component: DisplayProduitComponent },
  { path: '**', component: PageNotFoundComponent },
];
