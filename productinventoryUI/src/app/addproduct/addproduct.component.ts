import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../Product';
import { ProductserviceService } from '../productservice.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  constructor(private httpservice:ProductserviceService,private router:Router) { }

  ngOnInit(): void {
  }

  save(product:Product){
     this.httpservice.addProduct(product).subscribe(dta=>{
       if(dta){
        this.router.navigate(['/']);
       }
     });
  }
}
