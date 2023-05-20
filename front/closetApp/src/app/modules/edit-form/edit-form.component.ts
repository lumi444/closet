import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Clothes } from '@app/models/clothes';
import { ClothesService } from '@app/services/clothes/clothes.service';

@Component({
  selector: 'app-edit-form',
  templateUrl: './edit-form.component.html',
  styleUrls: ['./edit-form.component.css'],
})
export class EditFormComponent implements OnInit {
  @Input() toEdit: number = -1;
  clothToEdit: Clothes | undefined;
  form: FormGroup = new FormGroup({});

  constructor(
    private clothesService: ClothesService,
    private formBuilder: FormBuilder
  ) {}

  onSaveEdit() {
    if (this.form?.valid && this.clothToEdit) {
      const { name, size, price, category, description } = this.form.value;

      // Access the form values and perform your desired actions
      console.log('Name:', name);
      console.log('Size:', size);
      console.log('Price:', price);
      console.log('Category:', category);
      console.log('Description:', description);

      const newClothes: Clothes = {
        name: name,
        size: size,
        price: price,
        profile: { id: 11 },
        category: { id: category },
        description: description,
      };

      this.clothesService.updateClothes(newClothes, this.toEdit).subscribe(
        (response) => {
          console.log('Blaaaaaa:', response);
          // Do something with the response if needed
          location.reload();
        },
        (error) => {
          console.error('Error adding clothes:', error);
          // Handle the error if needed
        }
      );

      console.log('Blaaaaa:', newClothes);

      // You can also send the form values to an API or perform other operations here
    }
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      size: ['', Validators.required],
      price: [0, Validators.required],
      category: ['', Validators.required],
      description: ['', Validators.required],
    });

    this.getClothesToEdit(this.toEdit);
  }

  public async getClothesToEdit(id: number): Promise<void> {
    try {
      const response = await this.clothesService.getClothesById(id).toPromise();
      this.clothToEdit = response;
      console.log(this.clothToEdit);
      this.populateForm();
    } catch (error) {}
  }

  private populateForm(): void {
    if (this.clothToEdit) {
      const category = this.clothToEdit.category
        ? this.clothToEdit.category.id
        : '';

      this.form?.patchValue({
        name: this.clothToEdit.name,
        size: this.clothToEdit.size,
        price: this.clothToEdit.price,
        category: category,
        description: this.clothToEdit.description,
      });
    }
  }
}
