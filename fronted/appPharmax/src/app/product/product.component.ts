
import { Component, OnInit, Input } from '@angular/core';
import { Product } from './product.model';
import { ProductService } from './product.service';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { Sale } from '../sale/sale.model';
import { SaleService } from '../sale/sale.service';
import { Router } from '@angular/router';
import { BehaviorSubject, forkJoin, Observable, of, Subscription, timer } from 'rxjs';
import { catchError, concatMap, delay, map } from 'rxjs/operators';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styles: [`
  :host ::ng-deep .p-dialog .product-image {
      width: 150px;
      margin: 0 auto 2rem auto;
      display: block;
  }
`],
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  productDialog: boolean= false
  products: Product[]=[]
  product: Product= {}
  selectedProducts: Product[]=[];
  submitted: boolean= false

  saleDialog: boolean= false
  sale: Sale= {}

  //productsF: ProductF[]=[]

  constructor(private productService: ProductService, private saleService: SaleService, private router: Router,private messageService: MessageService, private confirmationService: ConfirmationService) { }

  ngOnInit() {
   // this.productService.getProducts().then(data => this.products = data);

    this.productService.getAllProducts().subscribe(data => {
      this.products = data
      this.products.forEach(item=>{
        item.dateTimeManufacture = new Date(item.dateManufacture)
        item.dateTimeExpiration = new Date(item.dateExpiration)
      })
    })
  }

  openNew() {
    this.product = {};
    this.submitted = false;
    this.productDialog = true;
  }

  deleteSelectedProducts() {
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete the selected products?',
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.products = this.products.filter(val => !this.selectedProducts.includes(val));
        this.selectedProducts = []//null;
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Products Deleted', life: 3000 });
      }
    });
  }

  editProduct(product: Product) {
    this.product = { ...product };
    this.productDialog = true;
  }

  deleteProduct(product: Product) {
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete ' + product.name + '?',
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.products = this.products.filter(val => val.id !== product.id);
        this.productService.deleteProduct(product.id).subscribe(resp=>console.log(resp))
        this.product = {};
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Deleted', life: 3000 });
      }
    });
  }

  hideDialog() {
    this.productDialog = false;
    this.submitted = false;
  }

  saveProduct() {
    this.product.dateExpiration = this.product.dateTimeManufacture.toISOString()
    this.product.dateManufacture = this.product.dateTimeManufacture.toISOString()

    console.log(this.product)
    this.submitted = true;

    if(this.product.id){
      //modifica
      this.productService.updateProduct(this.product).subscribe(resp=>{
        console.log(resp)
        this.productService.getAllProducts().subscribe(data => {
          
          this.products = data
          this.products.forEach(item=>{
            item.dateTimeManufacture = new Date(item.dateManufacture)
            item.dateTimeExpiration = new Date(item.dateExpiration)
          })
          this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Updated', life: 3000 });
        })

      })
    }else{
      //crea
      this.productService.createProduct(this.product).subscribe(resp=>{
        console.log(resp)
        this.productService.getAllProducts().subscribe(data => {
          this.products = data
          this.products.forEach(item=>{
            item.dateTimeManufacture = new Date(item.dateManufacture)
            item.dateTimeExpiration = new Date(item.dateExpiration)
          })
          this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Created', life: 3000 });
        })

      })

    }


   // this.products = [...this.products];
    this.productDialog = false;
    this.product = {};


  }



  saleProduct(product: Product) {
    this.product = { ...product };
    this.saleDialog = true;

    this.sale.product = this.product
    this.sale.quantity = 1
    this.sale.price = this.product.price
    this.sale.totalPrice = this.sale.price*this.sale.quantity 
    this.sale.dateTime = new Date()
    this.sale.date = this.sale.dateTime.toISOString()
  }
  changeQuantity(){
    this.sale.totalPrice = this.sale.price*this.sale.quantity 
  }

  saveSale(){
    this.submitted = true;



    this.saleService.createSale(this.sale).subscribe(resp=>{
      console.log(resp)

        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product sale!!', life: 3000 });
        
        this.saleDialog = false;
        this.submitted = false;

        setTimeout(()=>{this.router.navigate(['/sales']);}, 2000);
    })
  }

  hideDialogSale() {
    this.saleDialog = false;
    this.submitted = false;
  }


}
