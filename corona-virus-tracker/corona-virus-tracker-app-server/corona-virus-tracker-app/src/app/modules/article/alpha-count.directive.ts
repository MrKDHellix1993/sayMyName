import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appAlphaCount]'
})
export class AlphaCountDirective {
  constructor(private eleRef : ElementRef) { this.getDomAccess(); }
  public getDomAccess(){
    this.eleRef.nativeElement.style.background = "yellow";
  }

}
