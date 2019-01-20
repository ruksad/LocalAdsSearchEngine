import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TitleCasePipe } from '@angular/common';

import { ServiceWorkerModule } from '@angular/service-worker';
import { AppComponent } from './app.component';

import { environment } from '../environments/environment';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ParentComponent } from './components/parent/parent.component';
import { SearchFieldComponent } from './components/search-field/search-field.component';
import { StaticCategoriesComponent } from './components/static-categories/static-categories.component';
import { FeaturedCardsComponent } from './components/featured-cards/featured-cards.component';
import { MainSearchPageComponent } from './components/main-search-page/main-search-page.component';
import { DefinedConstantsService } from './services/defined-constants.service';
import { YelloPagesWebRoutingModule } from './yellowpages-routing.module';
import { SearchService } from './services/search.service';
import { HttpClientModule } from '@angular/common/http';
import { JsonToIterablePipe } from './pipes/json-to-iterable.pipe';
import { UtilsService } from './services/utils.service';
import { BroadcastDataService } from './services/broadcast-data.service';
import { ForSalePagesComponent } from './components/for-sale-pages/for-sale-pages.component';
import { ForSaleCategoriesComponent } from './components/for-sale-pages/for-sale-categories/for-sale-categories.component';
import { ForSaleViewComponent } from './components/for-sale-pages/for-sale-view/for-sale-view.component';
import { LoadExternalApiService } from './services/load-external-api.service';
import { TitleCasePipeTransform } from './pipes/title-case.pipe';
import { MomentDatePipe } from './pipes/moment-date.pipe';
import { ForSaleViewDescriptionComponent } from './components/for-sale-pages/for-sale-view-description/for-sale-view-description.component';
import { SearchFilterPipe } from './pipes/search-filter.pipe';
import { PostAddComponent } from './components/post-add/post-add.component';
import { SessionStorageService } from './services/session-storage.service';
import { UserLoginService } from './services/user-login.service';
import { SortFilterArrayPipe, SortFilterArrayModelPipe, sortFilterArrayCityPipe } from './pipes/sort-filter-array.pipe';
import { FilterPipe, sortByrPipe,FilterBedRoomsPipe } from './pipes/for-sale-products-filter.pipe';

import { NguCarouselModule } from '@ngu/carousel';
import { PostAdVerifyPhonenumberComponent } from './components/post-add/post-ad-verify-phonenumber/post-ad-verify-phonenumber.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ParentComponent,
    SearchFieldComponent,
    StaticCategoriesComponent,
    FeaturedCardsComponent,
    MainSearchPageComponent,
    JsonToIterablePipe,
    ForSalePagesComponent,
    ForSaleCategoriesComponent,
    ForSaleViewComponent,
    TitleCasePipeTransform,
    sortByrPipe,
    FilterPipe,
    MomentDatePipe,
    PostAddComponent,
    ForSaleViewDescriptionComponent,
    SearchFilterPipe,
    SortFilterArrayPipe,
    SortFilterArrayModelPipe,
    sortFilterArrayCityPipe,
    FilterBedRoomsPipe,
    PostAdVerifyPhonenumberComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    YelloPagesWebRoutingModule,
    FormsModule,
    NguCarouselModule,
    ServiceWorkerModule.register('/ngsw-worker.js', { enabled: environment.production })
  ],
  providers: [DefinedConstantsService, SearchService, UtilsService,
    BroadcastDataService, LoadExternalApiService,TitleCasePipe,
    SessionStorageService,UserLoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
