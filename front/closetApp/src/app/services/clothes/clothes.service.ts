import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Clothes } from '@app/models/clothes';
import { Observable } from 'rxjs';
import { environment } from 'src/environment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ClothesService {
  private serverApiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getClothes(): Observable<Clothes[]> {
    return this.http.get<Clothes[]>(`${this.serverApiUrl}/clothes/all`);
  }

  public addClothes(clothes: Clothes): Observable<Clothes> {
    return this.http.post<Clothes>(`${this.serverApiUrl}/clothes/add`, clothes);
  }

  public updateClothes(cl: Clothes, id: number): Observable<Clothes> {
    return this.http.put<Clothes>(
      `${this.serverApiUrl}/clothes/update/${id}`,
      cl
    );
  }

  public getClothesById(id: number): Observable<Clothes> {
    return this.http.get<Clothes>(`${this.serverApiUrl}/clothes/find/${id}`);
  }

  public deleteClothes(id: number): Observable<void> {
    return this.http.delete<void>(`${this.serverApiUrl}/clothes/delete/${id}`);
  }

  addClothesWithPicture(
    clothes: Clothes,
    pictureFile: File
  ): Observable<Clothes> {
    console.log('kurac');
    const formData: FormData = new FormData();
    formData.append('clothes', JSON.stringify(clothes));
    formData.append('pictureFile', pictureFile, pictureFile.name);

    const httpOptions = {
      headers: new HttpHeaders({
        enctype: 'multipart/form-data',
      }),
    };

    return this.http.post<Clothes>(
      `${this.serverApiUrl}/add-file`,
      formData,
      httpOptions
    );
  }
}
