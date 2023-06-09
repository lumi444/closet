import { Component } from '@angular/core';
import { ClothesService } from '@app/services/clothes/clothes.service';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css'],
})
export class BoardComponent {
  public recivedCategory: string = '';
  public priceRanges: number[] = [];
  filterCriteria: string[] = [];

  constructor(private _clothesService: ClothesService) {}

  receiveCategory(event: string) {
    this.recivedCategory = event;
  }

  receivePriceRange(range: number[]) {
    this.priceRanges = range;
  }

  handleFilterCriteriaChanged(criteria: string[]): void {
    this.filterCriteria = criteria;
  }
}
