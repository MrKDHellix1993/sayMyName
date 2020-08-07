import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InteractionService {

  private interactionMessage: Subject<string> = new Subject<string>();
  public _intrObservbl = this.interactionMessage.asObservable();
  constructor() { }

  sendMessage(message: string) {
    this.interactionMessage.next(message);

  }
}
