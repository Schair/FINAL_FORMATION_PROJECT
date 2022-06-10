import { NgModule } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ResponsiveNavModule } from './header/components/responsive-nav/responsive-nav.module';
import { DetailsModule } from './maincomponent/components/details/details.module';
import { HomeModule } from './maincomponent/components/home/home.module';
import { PizzasModule } from './maincomponent/components/pizzas/pizzas.module';
import { AddModule } from './maincomponent/components/add/add.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ResponsiveNavModule,
    PizzasModule,
    HomeModule,
    DetailsModule,
    MatFormFieldModule,
    AddModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
