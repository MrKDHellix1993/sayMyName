import { Directive, ElementRef, OnInit } from '@angular/core';

@Directive({
  selector: '[appMyParser]'
})
export class MyParserDirective {
  
  constructor(el : ElementRef) {
    el.nativeElement.style.color = 'white';
    el.nativeElement.style.backgroundColor = 'black';
   }
  
 /*  ngOnInit(): void {
    this.e
  } */
}

