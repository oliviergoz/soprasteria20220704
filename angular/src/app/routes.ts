import { Routes } from '@angular/router';
import { FournisseurEditComponent } from './component/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { ListComponent } from './component/fournisseur/list/list.component';
import { HomeComponent } from './component/home/home.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { ProduitEditComponent } from './component/produit/produit-edit/produit-edit.component';
import { ProduitListComponent } from './component/produit/produit-list/produit-list.component';
import { FormulaireCodeComponent } from './formulaire/formulaire-code/formulaire-code.component';
import { FormulaireTemplateComponent } from './formulaire/formulaire-template/formulaire-template.component';
import { Fournisseur } from './model/fournisseur';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'fournisseur', component: ListComponent },
  { path: 'fournisseur/add', component: FournisseurEditComponent },
  { path: 'fournisseur/edit/:id', component: FournisseurEditComponent },
  { path: 'produit', component: ProduitListComponent },
  { path: 'produit/add', component: ProduitEditComponent },
  { path: 'produit/edit/:id', component: ProduitEditComponent },
  { path: 'formulaire/template', component: FormulaireTemplateComponent },
  { path: 'formulaire/code', component: FormulaireCodeComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];
