import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '@models/user';

import { environment } from 'src/environment';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private serverApiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.serverApiUrl}/user/allUsers`);
  }

  public addUsers(user: User): Observable<User> {
    return this.http.post<User>(`${this.serverApiUrl}/user/add`, user);
  }

  public updateUsers(user: User): Observable<User> {
    return this.http.put<User>(`${this.serverApiUrl}/user/update`, user);
  }

  public deleteUsers(id: number): Observable<void> {
    return this.http.delete<void>(`${this.serverApiUrl}/user/delete/${id}`);
  }
}
