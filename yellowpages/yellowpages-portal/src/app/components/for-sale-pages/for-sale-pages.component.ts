import { Component, OnInit, AfterContentChecked, ChangeDetectorRef, Output ,AfterViewInit} from '@angular/core';
import { SearchService } from '../../services/search.service';
import { BroadcastDataService } from '../../services/broadcast-data.service';
import { EventEmitter } from 'protractor';
declare var $: any;

@Component({
  selector: 'app-for-sale-pages',
  templateUrl: './for-sale-pages.component.html',
  styleUrls: ['./for-sale-pages.component.css']
})
export class ForSalePagesComponent implements OnInit,AfterViewInit, AfterContentChecked {
  public selectedCategory: any;
  public furnitureBedRoomsSelected: any;
  public areaSelected: any;
  public maxarea: any;
  public minarea: any;
  public propertyPostedSelected: any;
  public localitySelected: any;
  public vechileModelSelected: any;
  public sortValueSelected: any;
  public viewOptionSelected: boolean;

  public prodductSortArray: any = [];
  public vechileObjects: any;
  public locationsList: any;
  public bedRoomsList: any;

  public objectListView: boolean = false;
  public objectListEnabled: boolean = false;
  public SelectedStateSubscriptionStatus;

  constructor(private searchService: SearchService, private broadcastService: BroadcastDataService, private cdr: ChangeDetectorRef) { }

  ngOnInit() {
    this.getSortArray();
    //this.getCarsDefinedCategory();
    this.getAreaDefinedCategory();
    this.getBedRoomsList();
    this.sortValueSelected = this.prodductSortArray[0];
    this.furnitureBedRoomsSelected=this.bedRoomsList[0].listValue;
    this.viewOptionSelected = false;
  }

  getSortArray() {
    this.prodductSortArray = [
      { id: 0, name: "Sort By", value: '' },
      { id: 1, name: "Sort by posted date", value: "posteddate" },
      { id: 2, name: "Sort by price: low to high", value: "lowtohigh" },
      { id: 3, name: "Sort by price: high to low", value: "hightolow" }
    ];
  }

  getBedRoomsList() {
    this.bedRoomsList = [
      {
        "listId": '',
        "listValue": "Bedrooms"
      },{
        "listId": 10000060,
        "listValue": "1 BHK"
      }, {
        "listId": 10000103,
        "listValue": "3.5 BHK"
      }, {
        "listId": 10000102,
        "listValue": "3 BHK"
      }, {
        "listId": 10000101,
        "listValue": "2.5 BHK"
      }, {
        "listId": 10000106,
        "listValue": "5+ BHK"
      }, {
        "listId": 10000100,
        "listValue": "2 BHK"
      }, {
        "listId": 10000105,
        "listValue": "4.5 BHK"
      }, {
        "listId": 10000061,
        "listValue": "1.5 BHK"
      }, {
        "listId": 10000104,
        "listValue": "4 BHK"
      }]
  }

  getCarsDefinedCategory(objectId) {
    this.searchService.getAllChildObjectById(objectId).subscribe(data => {
      this.vechileObjects = data;
      this.cdr.detectChanges();
      this.objectListView = true;
      this.objectListEnabled = true;
    }, error => {
      this.vechileObjects = [];
      this.objectListView = true;
    })
  }

  getAreaDefinedCategory() {
    this.SelectedStateSubscriptionStatus = this.broadcastService.castParentSelectedState.subscribe(statedata => {
      if (statedata) {
        this.locationsList = statedata.city.localityList;
      }
    })
  }



  onChangeSort(value) {
    this.sortValueSelected = value;
  }

  onChangeView(value) {
    this.viewOptionSelected = value;
  }

  ngAfterContentChecked() {
    $('#vechiles-model-multiple-checkboxes').multiselect({
      onChange: () => {
        this.vechileModelSelected = $('#vechiles-model-multiple-checkboxes').val();
      }
    });

    $('#multiple-locality-select').multiselect({
      onChange: () => {
        this.localitySelected = $('#multiple-locality-select').val();
      }
    });
   
    this.cdr.detectChanges();
  }

  ngAfterViewInit(){
    $('input').tooltip();
  }

  selectedCategroyName(event) {
    this.selectedCategory = event;
    this.objectListView = true;
    this.objectListEnabled = false;
    if (this.selectedCategory.childObjectTypes === null) {
      this.objectListView = false;
      this.getCarsDefinedCategory(this.selectedCategory.objectTypeId);
    }
  }

  onchangeBedrooms(event) {
    this.furnitureBedRoomsSelected = event;
  }

  onchangeArea() {
    if (this.minarea && this.maxarea)
      if (this.minarea < this.maxarea) {
        this.areaSelected = {
          "minarea": this.minarea,
          "maxarea": this.maxarea
        }
      } else {
        alert("Maximum area should be greater than min area");
      }
  }

  onPropertyPostedChange(value) {
    this.propertyPostedSelected = value;
  }

}


