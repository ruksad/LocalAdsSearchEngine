import { Pipe, PipeTransform } from '@angular/core';
import { TitleCasePipe } from '@angular/common';

@Pipe({
  name: 'titleCase'
})
export class TitleCasePipeTransform implements PipeTransform {
  constructor(private titleCasePipe: TitleCasePipe) { }
  transform(value: any, args?: any): any {
    if (!value) {
      return '';
    } else {
      return this.titleCasePipe.transform(value)
    }
  }

}

