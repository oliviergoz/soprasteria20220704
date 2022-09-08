import { Routes } from '@angular/router';
import { Component1Component } from './component1/component1.component';
import { Component2Component } from './component2/component2.component';
import { Component3Component } from './component3/component3.component';
import { Component4Component } from './component4/component4.component';

export const routes: Routes = [
  { path: 'comp1', component: Component1Component },
  { path: 'comp2', component: Component2Component },
  { path: 'comp3', component: Component3Component, outlet: 'secondary' },
  { path: 'comp4', component: Component4Component, outlet: 'secondary' },
];
