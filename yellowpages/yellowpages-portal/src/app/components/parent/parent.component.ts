import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DefinedConstantsService } from '../../services/defined-constants.service';
import { SearchService } from '../../services/search.service';
import { BroadcastDataService } from '../../services/broadcast-data.service';
import { SessionStorageService } from '../../services/session-storage.service';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {

  public statesAndCities:any;
  public allCategories:any;
  public selectedCity:string;
  public selectedCategory:any;
  public isPostAnAdTabSelected:boolean;

  constructor(private router: Router, private searchService: SearchService,
    private broadcastDataService: BroadcastDataService, private sessionStorageService: SessionStorageService) {}


  ngOnInit() {

    if (!this.sessionStorageService.isAppStoreDataPresentInLocal()) {
      this.newUserFlow();
    } else {
      this.previousUserFlow();
    }
   
  }



  selectCity(event) {
    this.selectedCity = event;
    this.broadcastDataService.selectedCity=event;
    this.sessionStorageService.localStorage.selectedCityAndStateWithAllLocalities=event;
    this.sessionStorageService.saveSessionStorage();
    this.broadcastDataService.updateparentSelectedState(event);
  }

  selectCategroy(event) {
    this.selectedCategory = event;
    this.broadcastDataService.slectedCategory=event;
    this.sessionStorageService.localStorage.selectedCategory=event;
    this.sessionStorageService.saveSessionStorage();
    this.broadcastDataService.updateparentSelectedCategory(event);
  }

  newUserFlow() {
    this.searchService.getAllCities().subscribe(x => {
      this.statesAndCities = x;
      this.sessionStorageService.localStorage.allStatesAndCities = x;
      this.broadcastDataService.allCitiesAndStates = x.states;
      this.broadcastDataService.allpopularCities = x.popularCities;
    },(error=>{}),()=>{
      this.sessionStorageService.saveSessionStorage();
    });

    this.router.navigate([DefinedConstantsService.SEARCH]);

    this.searchService.getAllCategories().subscribe(x => {
        console.log("all categories ", x);
        this.allCategories = x;
        this.sessionStorageService.localStorage.allCategories = x;
        this.broadcastDataService.allCategories = x
      }, (error: any) => {},

      () => {
        this.sessionStorageService.saveSessionStorage();
      })
  }

  previousUserFlow(){
    this.sessionStorageService.retriveAppStoreData();
    this.statesAndCities= this.sessionStorageService.localStorage.allStatesAndCities;
    this.allCategories= this.sessionStorageService.localStorage.allCategories;
    this.broadcastDataService.allCitiesAndStates = this.sessionStorageService.localStorage.allStatesAndCities.states;
    this.broadcastDataService.allpopularCities   =   this.sessionStorageService.localStorage.allStatesAndCities.popularCities;
    this.broadcastDataService.allCategories= this.sessionStorageService.localStorage.allCategories;
    this.router.navigate([DefinedConstantsService.SEARCH]);
  }

  postAdTabSelected(event){
    this.isPostAnAdTabSelected=event;
  }
}
