import { Component, OnInit, OnChanges } from '@angular/core';
import { Observable, Subject } from 'rxjs';
// import { resolve } from 'dns';

@Component({
  selector: 'app-feature',
  templateUrl: './feature.component.html',
  styleUrls: ['./feature.component.scss']
})
export class FeatureComponent implements OnInit,OnChanges {

  constructor() { }

  ngOnChanges() : void {
    debugger; 
  }

  ngOnInit(): void {

    const myPromise = new Promise(resolve => {
      setTimeout(() => {
        resolve('dog');
        resolve('cat');
        resolve('horse');
      }, 1000);
    });

    myPromise.then(result =>{
      console.log('promise: ' , result );
    });

    const myObeservsble = new Observable(observable =>{
      setTimeout(()=>{
        observable.next('dog');
        // observable.unsubscribe();
        observable.next('cat');
        observable.next('brd');
      }
      )
    });


   const obsSubcrib = myObeservsble.subscribe( res =>{
      console.log('obs result : ',res);
    });

    const mynewProms =myObeservsble.toPromise()

    mynewProms.then( res => console.log('new prom value', res));

    const mySubject = new Subject();
    mySubject.subscribe({
      next : (v) => console.log('observerA :' + v)
    });

    mySubject.subscribe({
      next : (v) => console.log('observerB :' + v)
    });

    mySubject.next(1);
    mySubject.next(2);
  }
}