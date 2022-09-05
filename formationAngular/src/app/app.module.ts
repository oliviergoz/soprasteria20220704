import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FirstComponent } from './component/demo/first/first.component';
import { HelloComponent } from './component/demo/hello/hello.component';
import { DisplayProduitComponent } from './component/exercice/display-produit/display-produit.component';
import { ProduitComponent } from './component/exercice/produit/produit.component';
import { EditProduitComponent } from './component/exercice/edit-produit/edit-produit.component';
import { VoteComponent } from './component/exercice/vote/vote/vote.component';
import { ClassementComponent } from './component/exercice/vote/classement/classement.component';
import { DirectiveComponent } from './component/demo/directive/directive.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    HelloComponent,
    DisplayProduitComponent,
    ProduitComponent,
    EditProduitComponent,
    VoteComponent,
    ClassementComponent,
    DirectiveComponent,
  ],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
