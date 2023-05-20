import { trigger } from '@angular/animations';
import { HttpErrorResponse } from '@angular/common/http';
import {
  Component,
  ElementRef,
  EventEmitter,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MatSlider, MatSliderChange } from '@angular/material/slider';
import { Category } from '@app/models/category';
import { CategoryService } from '@app/services/categories/category.service';
import { SearchService } from '@app/services/search/search.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
  animations: [
    trigger('transformMenu', [
      // Define animations here
    ]),
  ],
})
export class SidebarComponent implements OnInit {
  @Output() emitToParentCategory = new EventEmitter<string>();
  @Output() priceRangeChange = new EventEmitter<number[]>();

  public categories: Category[] = [];
  public searchQuery: string = '';
  panelOpenState = false;
  public selectedPriceRange: number[] = [0, 100000];

  constructor(
    private categoryService: CategoryService,
    private searchService: SearchService,
    private formBuilder: FormBuilder
  ) {}
  ngOnInit(): void {
    this.getCategories();
    // this.filterForm = this.formBuilder.group({
    //   priceRange: this.priceRangeControl,
    // });
  }

  formatLabel(value: number): string {
    if (value >= 1000) {
      return Math.round(value / 1000) + 'k';
    }

    return `${value}`;
  }

  public getCategories(): void {
    this.categoryService.getCategories().subscribe(
      (response: Category[]) => {
        this.categories = response;
        console.log(this.categories);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    );
  }

  handleClick(categoryName: string) {
    console.log('Clicked category:', categoryName);
    this.emitToParentCategory.emit(categoryName);
    // Do something with the clicked value
  }

  handleSearch(): void {
    //const priceRange = this.filterForm.value.priceRange;
    // const minPrice = priceRange[0];
    // const maxPrice = priceRange[1];
    this.searchService.setSearchQuery(this.searchQuery);

    this.priceRangeChange.emit(this.selectedPriceRange);
    //this.searchService.setPriceRange(minPrice, maxPrice);
  }

  onPriceChange(event: Event): void {
    const target = event.target as HTMLInputElement;
    const maxPrice = parseInt(target.value, 10);
    if (!isNaN(maxPrice)) {
      this.selectedPriceRange[1] = maxPrice;
      console.log('zzz' + this.selectedPriceRange[1]);
    }
  }

  sliderValue: number = 0;

  onInputChange(event: any) {
    this.sliderValue = event.value;
    console.log(this.sliderValue);
  }
}
