import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SearchService {
  private searchQuerySubject: BehaviorSubject<string> =
    new BehaviorSubject<string>('');
  public searchQuery$: Observable<string> =
    this.searchQuerySubject.asObservable();

  private minPriceSubject: BehaviorSubject<number> =
    new BehaviorSubject<number>(0);
  private maxPriceSubject: BehaviorSubject<number> =
    new BehaviorSubject<number>(100000);
  public minPrice$: Observable<number> = this.minPriceSubject.asObservable();
  public maxPrice$: Observable<number> = this.maxPriceSubject.asObservable();

  setSearchQuery(query: string): void {
    this.searchQuerySubject.next(query);
  }

  setPriceRange(minPrice: number, maxPrice: number): void {
    this.minPriceSubject.next(minPrice);
    this.maxPriceSubject.next(maxPrice);
  }
}
