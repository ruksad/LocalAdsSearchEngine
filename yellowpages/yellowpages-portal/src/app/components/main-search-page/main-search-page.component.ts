import { Component, OnInit, DoCheck } from '@angular/core';
import { SearchService } from '../../services/search.service';
import { BroadcastDataService } from '../../services/broadcast-data.service';
import { UtilsService } from '../../services/utils.service';
import { SessionStorageService } from '../../services/session-storage.service';

@Component({
  selector: 'app-main-search-page',
  templateUrl: './main-search-page.component.html',
  styleUrls: ['./main-search-page.component.css']
})
export class MainSearchPageComponent implements OnInit,DoCheck {

  private selectedCity: Object;
  allFeaturedCards: any[];
  constructor(private broadcastDataService: BroadcastDataService,
    private searchService: SearchService,
    private utilsService: UtilsService,
    private sessionStorageService: SessionStorageService) { }

  ngOnInit() {
    this.selectedCity = this.broadcastDataService.selectedCity;
    if(this.sessionStorageService.localStorage.selectedCityAndStateWithAllLocalities){
      this.fetchAlltheFeaturedCardsByCityId(this.sessionStorageService.localStorage.selectedCityAndStateWithAllLocalities.city.cityId);
    }
  }

  ngDoCheck(): void {
    if(this.selectedCity!=this.broadcastDataService.selectedCity){
      this.selectedCity=this.broadcastDataService.selectedCity;
      this.fetchAlltheFeaturedCardsByCityId(this.selectedCity['city'].cityId)
    }
  }

  fetchAlltheFeaturedCardsByCityId(cityId:number){
    this.searchService.getAllFeaturedCards(cityId).subscribe(results=>{
      this.allFeaturedCards=results;
    },(error)=>{
      this.allFeaturedCards=undefined;
    },()=>{
        this.allFeaturedCards=this.utilsService.convertObjectsToCards(this.allFeaturedCards);
        this.allFeaturedCards.sort((x,y)=>{
          if( x.priority<y.priority)
            return -1;
          if(x.priority>y.priority)
            return 1;
          return 0;
        })
        console.log("all fetrured cards are ",this.allFeaturedCards);
    })
}
}
