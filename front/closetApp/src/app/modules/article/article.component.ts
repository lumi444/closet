import { HttpErrorResponse } from '@angular/common/http';
import {
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { Clothes } from '@app/models/clothes';
import { ClothesService } from '@app/services/clothes/clothes.service';
import { SearchService } from '@app/services/search/search.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css'],
})
export class ArticleComponent implements OnInit, OnChanges {
  @Input() categoryFromParent: string = '';
  @Input() priceRange: number[] = [];
  public shirts: Clothes[] = [];
  public filteredArticles: Clothes[] = [];
  public minPrice: number = -1;
  public maxPrice: number = 35;

  constructor(
    private _clothesService: ClothesService,
    private searchService: SearchService
  ) {}

  ngOnInit(): void {
    if (this.categoryFromParent) {
      this.getShirts();
      this.filterByPriceRange();
    } else {
      this.getClothes();
      this.filterByPriceRange();
      this.searchService.searchQuery$.subscribe((query: string) => {
        this.filterArticles(query);
      });
      //this.filterArticles('');

      // this.searchService.minPrice$.subscribe((minPrice: number) => {
      //   this.minPrice = minPrice;
      //   this.filterArticles('');
      // });

      // this.searchService.maxPrice$.subscribe((maxPrice: number) => {
      //   this.maxPrice = maxPrice;
      //   this.filterArticles('');
      // });
    }
  }

  filterArticles(query: string): void {
    console.log(query);
    if (query === '') {
      this.getClothes();
      this.filterByPriceRange();
      this.shirts = this.shirts;
    } else {
      this.shirts = this.shirts.filter((article: Clothes) =>
        article.name.toLowerCase().includes(query.toLowerCase())
      );
      this.filterByPriceRange();
    }
  }

  ngOnChanges(changes: SimpleChanges) {
    this.filterByPriceRange();
    if (
      changes['categoryFromParent'] &&
      !changes['categoryFromParent'].firstChange
    ) {
      this.getShirts();
      this.filterByPriceRange();
    }
  }

  filterByPriceRange(): void {
    if (!this.priceRange || this.priceRange.length !== 2) {
      return;
    }
    const [minPrice, maxPrice] = this.priceRange;

    this.shirts = this.shirts.filter(
      (clothe) => clothe.price >= minPrice && clothe.price <= maxPrice
    );
    console.log('filtered: ' + this.shirts);
  }

  getShirts() {
    this._clothesService.getClothes().subscribe(
      (response) => {
        this.shirts = response.filter(
          (r) => r.category?.name === this.categoryFromParent
        );
        console.log(this.shirts);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    );
  }

  getClothes(): void {
    this._clothesService.getClothes().subscribe(
      (response: Clothes[]) => {
        this.shirts = response;
        console.log(this.shirts);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    );

    this.filterByPriceRange();
  }
}
