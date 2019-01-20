import { Pipe, PipeTransform } from '@angular/core';
import * as moment from 'moment';

@Pipe({
  name: 'filterVechiles',
  pure: false
})
export class FilterPipe implements PipeTransform {
  transform(items: Array<any>, filter: { [key: string]: any }): Array<any> {
    var originalArray = Object.assign([], items);
    if (filter.model != null) {
      let filteredData = [];
      for (let i = 0; i < filter.model.length; i++) {
        let products = items.filter((product: any) =>
          product.model.toLowerCase().indexOf(filter.model[i].toLowerCase()) === 0);
        for (let j = 0; j < products.length; j++) {
          filteredData.push(products[j]);
        }
      }
      return filteredData
    } else {
      return originalArray
    }
  }
}


@Pipe({
  name: 'sortBy',
  pure: false
})
export class sortByrPipe implements PipeTransform {
  transform(items: Array<any>, value: String): Array<any> {
    if (value) {
      if (value == 'posteddate') {
        items.sort((a, b) => {
          return a.posted_date < b.posted_date ? 1 : -1;
        })
      }
      if (value == 'lowtohigh') {
        items.sort((a, b) => {
          return +a.price > +b.price ? 1 : -1;
        })
      }
      if (value == 'hightolow') {
        items.sort((a, b) => {
          return +a.price < +b.price ? 1 : -1;
        })
      }
    }
    return items
  }
}


@Pipe({
  name: 'filterBedrooms',
  pure: false
})
export class FilterBedRoomsPipe implements PipeTransform {
  transform(items: Array<any>, value: any): Array<any> {
    console.log(value)
    if (value != 'Bedrooms') {
      console.log('in')
      let bedrooms = [];
      items.forEach(item => {
        if (item.bedrooms == value) {
          bedrooms.push(item);
        }
      })
      return bedrooms;
    } else {
      console.log('else')
      return items;
    }
  }
}
