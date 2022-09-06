import { Routes } from '@angular/router';
import { FournisseurEditComponent } from './component/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { ListComponent } from './component/fournisseur/list/list.component';
import { HomeComponent } from './component/home/home.component';
import { Fournisseur } from './model/fournisseur';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'fournisseur', component: ListComponent },
  { path: 'fournisseur/add', component: FournisseurEditComponent },
  { path: 'fournisseur/edit/:id', component: FournisseurEditComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];
