import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-boatride',
  templateUrl: './boatride.component.html',
  styleUrls: ['./boatride.component.css']
})
export class BoatrideComponent implements OnInit {
    boatRides = [
        {text: "Pedal boat 2 seater", price: "170"},
        {text: "Pedal boat 4 seater", price: "520"},
        {text: "Motor boat 8 seater", price: "560"},
        {text: "Motor boat 10 seater", price: "680"},
        {text: "Row boat 4 seater", price: "500"},
        {text: "Row boat 6 seater", price: "580"}
    ];
    constructor() { }

    ngOnInit(): void {
    }

}
