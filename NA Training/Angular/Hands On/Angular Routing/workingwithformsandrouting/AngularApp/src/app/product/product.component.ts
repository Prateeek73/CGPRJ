import { Component, OnInit } from '@angular/core';
//ADD REQUIRED IMPORTS
import { Product } from '../product.model';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  //Declare variable "model" to store object of "Product" model
  model: Product = new Product();
  //Declare "prodList" array variable
  prodList: Product[] = [];
  deleteText: string = "<<<click on this row to delete >>>";

  ngOnInit() {}

  //Implement code here
  deleteProduct(product: Product) {
    const index = this.prodList.indexOf(product);
    if (index !== -1 && confirm('Are you sure you want to delete this product?')) {
      this.prodList.splice(index, 1);
    }
  }
  addProduct() {
    console.log(this.model);  
    if (this.model.code && this.model.name && this.model.price) {
      this.prodList.push({ ...this.model });
      this.model = new Product(); // Clear the form
    }
  }
}
