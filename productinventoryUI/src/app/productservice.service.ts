import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

   url= 'http://localhost:8080';

  constructor(private httpservice:HttpClient) { }


  getAllProducts(){
    return this.httpservice.get(this.url+'/product/list');
  }

  addProduct(product:any){
    return this.httpservice.post(this.url+'/prodcut',product)

  }

  deleteProduct(id:any){
    return this.httpservice.delete(this.url+'/productdlete/'+id);

  }
}
