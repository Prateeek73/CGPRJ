import { Injectable } from '@angular/core';
import { Home } from './home';

@Injectable({
  providedIn: 'root'
})

export class HomeService {
    
  employeeList:Array<any>=[];
  filterList:Array<any>=[];

  constructor() { }
    addEmployee(obj:Home) {
      // Fill the code
      this.employeeList.push(obj);
    }

    filter(maxsalary : number) {
      // Fill the code
      return this.employeeList.filter(employee => employee.salary <= maxsalary);
    }
}
	 	  	  	 			  	   	 	
	 	  	  	 			  	   	 	

