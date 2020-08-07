import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { InteractionService } from '../interaction.service';

@Component({
  selector: 'app-child-message',
  templateUrl: './child-message.component.html',
  styleUrls: ['./child-message.component.scss']
})
export class ChildMessageComponent implements OnInit {

  @Input('parentMessage')
  public message : string;

  @Output()
  public childMessage = new EventEmitter<string>();
  constructor(private interactionService :InteractionService) { }
  
  ngOnInit(): void {
  }

  public sendMessage(){
    this.childMessage.emit(this.message);
  }

  public getMessage(){
    this.interactionService._intrObservbl.subscribe(
      message => {
        alert(message);
      }
   );
  }

}
