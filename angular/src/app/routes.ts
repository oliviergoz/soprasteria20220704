import { Routes } from '@angular/router';
import { FournisseurEditComponent } from './component/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { ListComponent } from './component/fournisseur/list/list.component';
import { HomeComponent } from './component/home/home.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { LoginComponent } from './component/login/login.component';
import { ProduitEditComponent } from './component/produit/produit-edit/produit-edit.component';
import { ProduitListComponent } from './component/produit/produit-list/produit-list.component';
import { FormulaireCodeComponent } from './formulaire/formulaire-code/formulaire-code.component';
import { FormulaireTemplateComponent } from './formulaire/formulaire-template/formulaire-template.component';
import { Fournisseur } from './model/fournisseur';
import { AuthGuardService } from './services/auth-guard.service';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'fournisseur',
    component: ListComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'fournisseur/add',
    component: FournisseurEditComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'fournisseur/edit/:id',
    component: FournisseurEditComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'produit',
    component: ProduitListComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'produit/add',
    component: ProduitEditComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'produit/edit/:id',
    component: ProduitEditComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'inscription',
    component: InscriptionComponent,
  },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];
