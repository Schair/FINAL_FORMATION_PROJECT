import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'pizzas', loadChildren: () => import('./maincomponent/components/pizzas/pizzas.module').then(m => m.PizzasModule) }, 
{ path: '', loadChildren: () => import('./maincomponent/components/home/home.module').then(m => m.HomeModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
