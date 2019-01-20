import { Component, OnInit, Input, ViewChild } from '@angular/core';

@Component({
  selector: 'app-for-sale-view-description',
  templateUrl: './for-sale-view-description.component.html',
  styleUrls: ['./for-sale-view-description.component.css']
})
export class ForSaleViewDescriptionComponent implements OnInit {
  @Input() productDescription: any;
  @ViewChild('childModel') childModels;

  public productDescriptionData: any;
  constructor() { }

  ngOnInit() {

  }


  openModel(productValues) {
    this.productDescriptionData = productValues;
    this.childModels.nativeElement.click();
  }

}
