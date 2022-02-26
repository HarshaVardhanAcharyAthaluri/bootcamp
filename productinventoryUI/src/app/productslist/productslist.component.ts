import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductserviceService } from '../productservice.service';

@Component({
  selector: 'app-productslist',
  templateUrl: './productslist.component.html',
  styleUrls: ['./productslist.component.css']
})
export class ProductslistComponent implements OnInit {

  products:any;


  constructor(private productService:ProductserviceService,private route:Router){
  
  }
  
    ngOnInit(): void {
        this.productService.getAllProducts().subscribe(prodlist=>this.products = prodlist);
    }

    deleteProduct(id:any){
        this.productService.deleteProduct(id).subscribe(result=>{
          this.ngOnInit();
        },err=>{
          this.ngOnInit();
        });
    }

}
