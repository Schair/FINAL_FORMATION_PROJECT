import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PizzasComponent } from './pizzas.component';

const routes: Routes = [{ path: '', component: PizzasComponent }, { path: 'add', loadChildren: () => import('../add/add.module').then(m => m.AddModule) },
{ path: 'details/:id', loadChildren: () => import('../details/details.module').then(m => m.DetailsModule) }]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PizzasRoutingModule { }
