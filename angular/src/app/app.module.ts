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

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    MenuComponent,
    HomeComponent,
    FournisseurEditComponent,
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
