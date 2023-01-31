import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { saleRoutes } from './sale.routing';
import { RouterModule } from '@angular/router';
import { SaleService } from './sale.service';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(saleRoutes),
  ],
  providers: [SaleService]
})
export class SaleModule { }
