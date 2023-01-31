import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { productRoutes } from './product.routing';
import { RouterModule } from '@angular/router';

//import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
//import { HttpClientModule } from '@angular/common/http';
//import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProductService } from './product.service';


import {TableModule} from 'primeng/table';
import {ToastModule} from 'primeng/toast';
import {CalendarModule} from 'primeng/calendar';
import {SliderModule} from 'primeng/slider';
import {MultiSelectModule} from 'primeng/multiselect';
import {ContextMenuModule} from 'primeng/contextmenu';
import {DialogModule} from 'primeng/dialog';
import {ButtonModule} from 'primeng/button';
import {DropdownModule} from 'primeng/dropdown';
import {ProgressBarModule} from 'primeng/progressbar';
import {InputTextModule} from 'primeng/inputtext';
import {FileUploadModule} from 'primeng/fileupload';
import {ToolbarModule} from 'primeng/toolbar';
import {RatingModule} from 'primeng/rating';
import {RadioButtonModule} from 'primeng/radiobutton';
import {InputNumberModule} from 'primeng/inputnumber';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { InputTextareaModule } from 'primeng/inputtextarea';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(productRoutes),


    FormsModule,


  ],
  providers: [ProductService]
})
export class ProductModule { }
