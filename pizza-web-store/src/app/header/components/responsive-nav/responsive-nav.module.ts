import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResponsiveNavComponent } from './responsive-nav.component';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import { PizzasRoutingModule } from 'src/app/maincomponent/components/pizzas/pizzas-routing.module';



@NgModule({
  declarations: [
    ResponsiveNavComponent
  ],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    PizzasRoutingModule
  ],
  exports: [
    ResponsiveNavComponent
  ]
})
export class ResponsiveNavModule { }
