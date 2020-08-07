import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { InteractionService } from './interaction.service';
import { ChildMessageComponent } from './child-message/child-message.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit, AfterViewInit {

  favoriteWebSeries: string;
  seasons: string[] = ['Breaking Bad', 'Better Call Saul', 'Dark'];

  message: string;
  newMesssage: string;

  @ViewChild(ChildMessageComponent)
  public childMessage: ChildMessageComponent;

  constructor(private interationService: InteractionService, private routeActivate: ActivatedRoute) { }

  ngOnInit(): void {
    let id = parseInt(this.routeActivate.snapshot.paramMap.get('id'));
    alert(id);
  }

  ngAfterViewInit(): void {
    this.childMessage.getMessage();
  }

  public sendMessage() {
    console.log(this.newMesssage);
    this.message = this.newMesssage;
    this.interationService.sendMessage("Got new message from Izzie!!!")
  }
} 
