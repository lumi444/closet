import { Component } from '@angular/core';
import { ClothesService } from '@app/services/clothes/clothes.service';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css'],
})
export class BoardComponent {
  public recivedCategory: string = '';

  constructor(private _clothesService: ClothesService) {}

  receiveCategory(event: string) {
    this.recivedCategory = event;
  }
}
