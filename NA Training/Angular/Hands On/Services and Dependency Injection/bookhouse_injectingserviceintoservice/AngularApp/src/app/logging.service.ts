// import { Injectable } from '@angular/core';
import { Injectable ,EventEmitter} from '@angular/core';
import { Book } from './Book';

@Injectable({
  providedIn: 'root'
})
export class LoggingService {

  constructor() { }

  logData: Array<any> = [];

insertLogData(log: string){
   // Fill the code
   this.logData.push(log);
}

}
