import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css'],
})
export class AddFormComponent {
  form: FormGroup;

  constructor() {
    this.form = new FormGroup({
      name: new FormControl(''),
      brand: new FormControl(''),
      price: new FormControl(''),
      category: new FormControl(''),
      defaultSize: new FormControl(''),
      description: new FormControl(''),
    });
  }

  onSave() {
    if (this.form.valid) {
      const { name, brand, price, category, defaultSize, description } =
        this.form.value;

      // Access the form values and perform your desired actions
      console.log('Name:', name);
      console.log('Brand:', brand);
      console.log('Price:', price);
      console.log('Category:', category);
      console.log('Default Size:', defaultSize);
      console.log('Description:', description);

      // You can also send the form values to an API or perform other operations here
    }
  }
}
