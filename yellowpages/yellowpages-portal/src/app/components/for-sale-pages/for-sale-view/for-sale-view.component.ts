import { Component, OnInit, Input, Output, EventEmitter, OnDestroy, SimpleChanges, ViewContainerRef, ViewChild } from '@angular/core';
import { BroadcastDataService } from "../../../services/broadcast-data.service";
import { UtilsService } from '../../../services/utils.service';
import { SearchService } from '../../../services/search.service';
import { SearchCriteriaModel } from '../../../models/search-criteria-model';
import { ForSaleViewDescriptionComponent } from '../for-sale-view-description/for-sale-view-description.component';

@Component({
  selector: 'app-for-sale-view',
  templateUrl: './for-sale-view.component.html',
  styleUrls: ['./for-sale-view.component.css']
})
export class ForSaleViewComponent implements OnInit, OnDestroy {
  public forSaleObjectResponseData;
  public errorResponse;

  //stored with 2 way binding of input values
  @Input() viewOptionSelected: any;
  @Input() furnitureBedRoomsSelected: any;
  @Input() areaSelected: any;
  @Input() propertyPostedSelected: any;
  @Input() localitySelected: any;
  @Input() vechileModelSelected: any;
  @Input() sortValueSelected: any;

  @Output() updateSelectedCategroyName: EventEmitter<string> = new EventEmitter<any>();

  public categorySubscriptionStatus;
  public categorySelectedSubscriptionStatus;
  public SelectedStateSubscriptionStatus;
  public SelectedStateData;
  public SelectedForSaleCategoryData;
  public categoryData;
  public selectedFurinitureBedroom;
  public selectSortValue;


  public filterObject: any = {};

  @ViewChild('childModal') childModal: ForSaleViewDescriptionComponent;


  constructor(private viewContainerRef: ViewContainerRef, private broadcastService: BroadcastDataService, private utilsService: UtilsService, private searchService: SearchService) { }

  ngOnInit() {
    this.selectedState();
    this.selectedCategory();

  }


  ngOnChanges(changes: SimpleChanges) {

    //catch any changes in model
    if (changes.vechileModelSelected) {
      this.filterObject.model = changes.vechileModelSelected.currentValue;
    }

    if (changes.sortValueSelected) {
      this.selectSortValue = changes.sortValueSelected.currentValue;
    }

    if (changes.furnitureBedRoomsSelected) {
      this.selectedFurinitureBedroom = changes.furnitureBedRoomsSelected.currentValue;
    }
  }

  selectedState() {
    this.SelectedStateSubscriptionStatus = this.broadcastService.castParentSelectedState.subscribe(statedata => {
      if (statedata) {
        this.SelectedStateData = statedata;
        this.getSaleProducts(this.SelectedStateData.state.stateId, this.SelectedStateData.city.cityId, this.SelectedForSaleCategoryData);
      }
    })

  }

  selectedCategory() {
    //parent search category
    this.categorySelectedSubscriptionStatus = this.broadcastService.castParentSelectedCategory.subscribe(categorydata => {
      if (categorydata) {
        this.SelectedForSaleCategoryData = categorydata.objectTypeId;
        this.categoryData = categorydata;
        //adding category name
        this.updateSelectedCategroyName.emit(categorydata);
        this.getSaleProducts(this.SelectedStateData.state.stateId, this.SelectedStateData.city.cityId, this.SelectedForSaleCategoryData);
      }
    })

    //for sale side menu category
    this.categorySubscriptionStatus = this.broadcastService.forSaleCategorySelected.subscribe(forSaleCategoryData => {
      if (forSaleCategoryData) {
        this.updateSelectedCategroyName.emit(forSaleCategoryData);
        this.SelectedForSaleCategoryData = forSaleCategoryData.objectTypeId;
        this.categoryData = forSaleCategoryData;
        this.getSaleProducts(this.SelectedStateData.state.stateId, this.SelectedStateData.city.cityId, this.SelectedForSaleCategoryData);
      }
    })
  }



  getSaleProducts(stateId, cityId, categoryId) {
    if (stateId && cityId && categoryId) {
      let searchCriteriaModel = new SearchCriteriaModel()
      searchCriteriaModel.categoryId = categoryId;
      searchCriteriaModel.selectedCityId = cityId;
      searchCriteriaModel.stateId = stateId;
      this.searchService.getByCriteria(searchCriteriaModel).subscribe(data => {
        this.forSaleObjectResponseData = this.utilsService.ConvertObjectToSaleView(data);
      }, error => {
        this.forSaleObjectResponseData = '';
        this.errorResponse = error;
      })
    }
  }

  openModelpageDescription(value) {
    this.childModal.openModel(value);
  }
  ngOnDestroy() {
    this.categorySubscriptionStatus.unsubscribe();
    this.categorySelectedSubscriptionStatus.unsubscribe();
    this.SelectedStateSubscriptionStatus.unsubscribe();
  }
}
