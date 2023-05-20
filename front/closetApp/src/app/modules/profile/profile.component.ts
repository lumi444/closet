import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Clothes } from '@app/models/clothes';
import { ClothesService } from '@app/services/clothes/clothes.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  public inAddMode: boolean = false;
  public clothes: Clothes[] = [];
  public editId: number = -1;
  public inEditMode: boolean = false;

  constructor(private clothesService: ClothesService) {}
  ngOnInit(): void {
    this.getMyClothes('ana1');
  }

  getMyClothes(usernm: string) {
    this.clothesService.getClothes().subscribe(
      (response: Clothes[]) => {
        this.clothes = response.filter((c) => c.profile?.username === usernm);
        console.log(this.clothes);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    );
    this.inAddMode = false;
  }

  addNewItem() {
    this.inAddMode = true;
  }

  deleteClothing(clothToDelete: Clothes) {
    this.clothesService
      .deleteClothes(clothToDelete.id ? clothToDelete.id : -1)
      .subscribe(
        (response: void) => {
          location.reload();
        },
        (error: HttpErrorResponse) => {
          console.log(error.message);
        }
      );
  }

  editClothes(clothToEdit: Clothes) {
    this.inEditMode = true;
    this.editId = clothToEdit.id ? clothToEdit.id : -1;
    console.log(clothToEdit);
  }
}
