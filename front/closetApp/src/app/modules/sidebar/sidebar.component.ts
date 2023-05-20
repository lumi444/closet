import { trigger } from '@angular/animations';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Category } from '@app/models/category';
import { CategoryService } from '@app/services/categories/category.service';

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
  public categories: Category[] = [];
  panelOpenState = false;

  constructor(private categoryService: CategoryService) {}
  ngOnInit(): void {
    this.getCategories();
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
}
