import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FirstComponent } from './component/demo/first/first.component';
import { HelloComponent } from './component/demo/hello/hello.component';

@NgModule({
  declarations: [AppComponent, FirstComponent, HelloComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
