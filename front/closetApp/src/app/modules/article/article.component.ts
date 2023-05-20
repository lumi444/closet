import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Clothes } from '@app/models/clothes';
import { ClothesService } from '@app/services/clothes/clothes.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css'],
})
export class ArticleComponent implements OnChanges {
  @Input() categoryFromParent: string = '';
  public shirts: Clothes[] = [];

  constructor(private _clothesService: ClothesService) {}

  ngOnChanges(changes: SimpleChanges) {
    if (
      changes['categoryFromParent'] &&
      !changes['categoryFromParent'].firstChange
    ) {
      this.getShirts();
    }
  }

  getShirts() {
    this._clothesService.getClothes().subscribe(
      (response) => {
        this.shirts = response.filter(
          (r) => r.category?.name === this.categoryFromParent
        );

        console.log(this.shirts);
        // this.decodeImages();
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    );
  }

  // decodeImages() {
  //   for (const shirt of this.shirts) {
  //     const base64String = this.arrayBufferToBase64(shirt.picture);
  //     shirt.imageUrl = 'data:image/png;base64,' + base64String;
  //     console.log(shirt.imageUrl);
  //   }
  // }

  private arrayBufferToBase64(buffer: ArrayBuffer): string {
    let binary = '';
    const bytes = new Uint8Array(buffer);
    const len = bytes.byteLength;
    for (let i = 0; i < len; i++) {
      binary += String.fromCharCode(bytes[i]);
    }
    return window.btoa(binary);
  }
}
