import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


import { environment } from 'src/environments/environment';

import { Observable, combineLatest, of } from 'rxjs';
import { Sale } from './sale.model';

@Injectable()
export class SaleService {

    private urlSales = `${environment.URL_API}/sales`;


    constructor(private http: HttpClient) { }


    getAllSales():Observable<Sale[]> {
        return this.http.get<Sale[]>(this.urlSales)
    }

    getAllSalesFilter(req:any):Observable<Sale[]> {
        return this.http.get<Sale[]>(`${environment.URL_API}/sales/filter?dateStart=${req.dateStart}&dateEnd=${req.dateEnd}`)
    }
   
    getSaleById(id:string):Observable<Sale> {
        return this.http.get<Sale>(`${environment.URL_API}/sales/${id}`)
    }

    createSale(request:any):Observable<any> {
        return this.http.post<any>(this.urlSales,request)
    }

    updateSale(request:any):Observable<any> {
        return this.http.put<any>(this.urlSales,request)
    }

    deleteSale(id:string):Observable<any> {
        return this.http.delete<any>(`${environment.URL_API}/sales/${id}`)
    }



}