import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Category } from './models/category';
import { Clothes } from './models/clothes';
import { User } from './models/user';
import { CategoryService } from './services/categories/category.service';
import { ClothesService } from './services/clothes/clothes.service';
import { UserService } from './services/user/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'closetApp';

  public users: User[] = [];
  public clothes: Clothes[] = [];
  public categories: Category[] = [];

  constructor(
    private userService: UserService,
    private clothesService: ClothesService,
    private categoryService: CategoryService
  ) {}
  ngOnInit(): void {
    this.getUsers();
    this.getClothes();
    this.getCategories();
  }

  public getUsers(): void {
    this.userService.getUsers().subscribe(
      (response: User[]) => {
        this.users = response;
        console.log(this.users);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    );
  }

  public getClothes(): void {
    this.clothesService.getClothes().subscribe(
      (response: Clothes[]) => {
        this.clothes = response;
        console.log(this.clothes);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    );
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
}
