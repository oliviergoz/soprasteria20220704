import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListComponent } from './component/fournisseur/list/list.component';
import { HttpClientModule } from '@angular/common/http';
import { MenuComponent } from './component/menu/menu.component';
import { HomeComponent } from './component/home/home.component';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { FournisseurEditComponent } from './component/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { FormsModule } from '@angular/forms';
import { ProduitListComponent } from './component/produit/produit-list/produit-list.component';
import { ProduitEditComponent } from './component/produit/produit-edit/produit-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    MenuComponent,
    HomeComponent,
    FournisseurEditComponent,
    ProduitListComponent,
    ProduitEditComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
