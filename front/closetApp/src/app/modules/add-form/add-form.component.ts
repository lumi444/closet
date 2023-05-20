import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Clothes } from '@app/models/clothes';
import { ClothesService } from '@app/services/clothes/clothes.service';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css'],
})
export class AddFormComponent {
  form: FormGroup;

  constructor(private clothesService: ClothesService, private router: Router) {
    this.form = new FormGroup({
      name: new FormControl(''),
      size: new FormControl(''),
      price: new FormControl(''),
      category: new FormControl(''),
      pic: new FormControl(''),
      description: new FormControl(''),
    });
  }

  onSave() {
    if (this.form.valid) {
      const { name, size, price, category, pic, description } = this.form.value;

      // Access the form values and perform your desired actions
      console.log('Name:', name);
      console.log('Size:', size);
      console.log('Price:', price);
      console.log('Category:', category);
      console.log('Picture:', pic);
      console.log('Description:', description);

      const newClothes: Clothes = {
        name: name,
        size: size,
        price: price,
        category: { id: category }, // Set category value as an object with id property
        picture: pic === '' ? null : pic,
        description: description,
        profile: { id: 11 }, // Set profile value as an object with id property
        // Set imageUrl value accordingly
      };

      this.clothesService.addClothes(newClothes).subscribe(
        (response) => {
          console.log('New Clothes:', response);
          // Do something with the response if needed
          location.reload();
        },
        (error) => {
          console.error('Error adding clothes:', error);
          // Handle the error if needed
        }
      );

      console.log('New Clothes:', newClothes);

      // You can also send the form values to an API or perform other operations here
    }
  }
}
