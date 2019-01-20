import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sortFilterArray'
})
export class SortFilterArrayPipe implements PipeTransform {

  transform(array: any, args?: any): any {
    array.sort((a: any, b: any) => {
      if (a.listValue < b.listValue) {
        return -1;
      } else if (a.listValue > b.listValue) {
        return 1;
      } else {
        return 0;
      }
    });
    if (args) {
      array.reverse();
    }
    return array;
  }
}




  @Pipe({
    name: 'sortFilterArrayModel'
  })
  export class SortFilterArrayModelPipe implements PipeTransform {
  
    transform(array: any, args?: any): any {
      array.sort((a: any, b: any) => {
        if (a.objectTypename < b.objectTypename) {
          return -1;
        } else if (a.objectTypename > b.objectTypename) {
          return 1;
        } else {
          return 0;
        }
      });
      if (args) {
        array.reverse();
      }
      return array;
    }
  }



  @Pipe({
    name: 'sortFilterArrayCity'
  })
  export class sortFilterArrayCityPipe implements PipeTransform {
  
    transform(array: any, args?: any): any {
      console.log(array)
      array.sort((a: any, b: any) => {
        if (a.cityName < b.cityName) {
          return -1;
        } else if (a.cityName > b.cityName) {
          return 1;
        } else {
          return 0;
        }
      });
      if (args) {
        array.reverse();
      }
      return array;
    }
  }