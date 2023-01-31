


import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  {
    path: '',
    // component: AdminComponent,
    children: [
      {
        path: '',
        redirectTo: 'products',
        pathMatch: 'full'
      },

      {
        path: 'products',
        loadChildren: () => import('./product/product.module').then(module => module.ProductModule)

      },
      {
        path: 'sales',
        loadChildren: () => import('./sale/sale.module').then(module => module.SaleModule)

      }

    ]
  },
  { path: '**', redirectTo: 'products' },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
