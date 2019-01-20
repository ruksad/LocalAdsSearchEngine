import { Injectable,EventEmitter,Output } from '@angular/core';

import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { ReplaySubject } from 'rxjs/ReplaySubject';

@Injectable()
export class BroadcastDataService {

  allCategories: any[];
  allpopularCities: any[];
  allCitiesAndStates: any[];
  allCities:any;

  userAccessToken:string='Bearer ';
  loginLogoutModal:ReplaySubject<boolean> = new ReplaySubject();
 
  //@Output() slectedCategory: EventEmitter<any> = new EventEmitter();
  @Output() forSaleCategorySelected: EventEmitter<any> = new EventEmitter();


  slectedCategory: any;

  selectedCity: any;
  /* to-way binding for state selected */
  private selectedStateData = new BehaviorSubject<any>(this.slectedCategory);
  castParentSelectedState = this.selectedStateData.asObservable();

  /* to-way binding for sale categories selected */
  private selectedCategoryData = new BehaviorSubject<any>(this.slectedCategory);
  castParentSelectedCategory = this.selectedCategoryData.asObservable();


  constructor() { }

  updateForSaleCategorySelected(object) {
    this.forSaleCategorySelected.emit(object);
  }

  updateparentSelectedCategory(object) {
    this.selectedCategoryData.next(object)
  }

  updateparentSelectedState(object) {
    this.selectedStateData.next(object)
  }
}
