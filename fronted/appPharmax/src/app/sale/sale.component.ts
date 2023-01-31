import { Component, OnInit } from '@angular/core';
import { Sale } from './sale.model';
import { SaleService } from './sale.service';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.scss']
})
export class SaleComponent implements OnInit {

  sales: Sale[]=[]
  rangeDates: Date[];
  constructor(private saleService: SaleService) { }

  ngOnInit(): void {
    this.saleService.getAllSales().subscribe(resp=>{
      this.sales = resp;
    })
  }

  salesByRangeDate(){

    console.log(this.rangeDates)
    //toISOString()
    const req= {dateStart:this.rangeDates[0].toISOString(), dateEnd:this.rangeDates[1].toISOString()}
    this.saleService.getAllSalesFilter(req).subscribe(resp=>{
      this.sales = resp;
    })
  }

}
