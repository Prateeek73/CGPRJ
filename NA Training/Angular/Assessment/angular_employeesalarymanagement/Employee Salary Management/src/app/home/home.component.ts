import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Home } from '../home';
import { HomeService } from '../home.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  filterList:Array<Home> = [];
  home: Home;  
  employeeId: string = "";
  flag: number | undefined;
  maxsalary : any;
  error:string='';
  status="";
  
  constructor(private homeService : HomeService ,private router : Router, private activatedRoute : ActivatedRoute) { 
    this.home = new Home("","","","",0,0)
    this.filterList = this.homeService.employeeList;
    this.activatedRoute.queryParams.subscribe(params => {
      console.log(params['flag']);
      this.flag =  params['flag'];
    });
  }
  
  ngOnInit(): void {
    // Fill the code 
  }

  addEmployee() {
    try {
      // Fill the code 
      this.validation(); 
    } catch(e:any) {
      this.error = e.message;
    }
    // Your code to add employee details if validation succeeds
    this.homeService.addEmployee(this.home);
    this.status = "Employee details added successfully";
  }

  filter() {	 	  	    	   	 	      	 	
    // Fill the code 
    this.filterList = this.homeService.filter(this.maxsalary);
  }	 	 
  
  validation() {
    // Fill the code 
    if (this.home.employeeId === "") {
      throw new Error("Provide value for employee id");
    } else if (this.home.employeeName === "") {
      throw new Error("Provide value for employee name");
    } else if (this.home.phoneNumber === "") {
      throw new Error("Provide value for phone number");
    } else if (!this.home.experience) {
      throw new Error("Provide value for experience");
    } else if (this.home.division === "") {
      throw new Error("Provide value for division");
    } else if (
      !["Nursery", "Primary", "High School", "Higher Secondary"].includes(
        this.home.division
      )
    ) {
      throw new Error("Provide appropriate division as ['Nursery', 'Primary', 'High School', 'Higher Secondary']");
    } else if (!this.home.salary) {
      throw new Error("Provide value for salary");
    }
  }
}