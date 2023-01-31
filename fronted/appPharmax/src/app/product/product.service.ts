import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Product } from './product.model';
import { environment } from 'src/environments/environment';

import { Observable, combineLatest, of } from 'rxjs';

@Injectable()
export class ProductService {

    private urlProducts = `${environment.URL_API}/products`;

    constructor(private http: HttpClient) { }





    //urlProducts

    getAllProducts():Observable<Product[]> {
        return this.http.get<Product[]>(this.urlProducts)
    }
   
    getProductById(id:string):Observable<Product> {
        return this.http.get<Product>(`${environment.URL_API}/products/${id}`)
    }

    createProduct(request:any):Observable<any> {
        return this.http.post<any>(this.urlProducts,request)
    }

    updateProduct(request:any):Observable<any> {
        return this.http.put<any>(this.urlProducts,request)
    }

    deleteProduct(id:number):Observable<any> {
        return this.http.delete<any>(`${environment.URL_API}/products/${id}`)
    }



}