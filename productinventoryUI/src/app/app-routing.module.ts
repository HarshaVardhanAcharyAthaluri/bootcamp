import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddproductComponent } from './addproduct/addproduct.component';
import { ProductslistComponent } from './productslist/productslist.component';

const routes: Routes = [
{path:'addprodcut',component:AddproductComponent},
{path:'',component:ProductslistComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
