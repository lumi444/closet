import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from '@app/models/order';
import { Observable } from 'rxjs';
import { environment } from 'src/environment';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  private serverApiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.serverApiUrl}/orders/all`);
  }

  public addOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(`${this.serverApiUrl}/orders/add`, order);
  }

  public updateOrder(id: number): Observable<Order> {
    return this.http.put<Order>(`${this.serverApiUrl}/orders/update/${id}`, id);
  }

  public deleteOrder(id: number): Observable<void> {
    return this.http.delete<void>(`${this.serverApiUrl}/orders/delete/${id}`);
  }
}
