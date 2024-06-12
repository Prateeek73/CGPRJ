import {Pipe, PipeTransform} from '@angular/core';

//Implement your Code here
@Pipe({
   name: 'nameLength'
})
export class ShowLen  implements PipeTransform {
   //Implement your Code here
   transform(value: string): number {
       return value.length;
   }
}