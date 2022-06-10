import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'pizzas', loadChildren: () => import('./maincomponent/components/pizzas/pizzas.module').then(m => m.PizzasModule) }, 
{ path: '', loadChildren: () => import('./maincomponent/components/home/home.module').then(m => m.HomeModule) }]
// { path: 'details/:id', loadChildren: () => import('./maincomponent/components/details/details.module').then(m => m.DetailsModule) }]
// { path: 'details', loadChildren: () => import('./maincomponent/components/pizzas-details/pizzas-details.module').then(m => m.PizzasDetailsModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }