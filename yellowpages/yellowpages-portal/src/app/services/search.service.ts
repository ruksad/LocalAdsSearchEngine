import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { DefinedConstantsService } from './defined-constants.service';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/environment';
import 'rxjs/add/operator/map'
import { SearchCriteriaModel } from '../models/search-criteria-model';
import { PostAdDto } from '../models/post-ad-dto';
import { BroadcastDataService } from './broadcast-data.service';

@Injectable()
export class SearchService {


  constructor(private http: HttpClient,private broadcastDataService:BroadcastDataService) { }

  private httpHeaders: HttpHeaders=new HttpHeaders({
    'Content-Type': 'application/json',
  });

  getAllCities():Observable<any>{
    return this.http.get(environment.REST_API_LOCATION + DefinedConstantsService.GETALLCITIES_URI,{headers: this.httpHeaders});
  }

  getAllCategories(): Observable<any> {
    return this.http.get(environment.REST_API_LOCATION+DefinedConstantsService.GETALLCATEGORIES_URI,{headers: this.httpHeaders});
  }

  getByCriteria(searchCriteriaModel:SearchCriteriaModel):Observable<any>{
    console.log("criteria",searchCriteriaModel);
    let params = new HttpParams()
    .set('categoryId', JSON.stringify(searchCriteriaModel.categoryId))
    .set('selectedCityId', JSON.stringify(searchCriteriaModel.selectedCityId))
    .set('stateId', JSON.stringify(searchCriteriaModel.stateId));
    let options = { headers: this.httpHeaders, params: params };
    return this.http.get(environment.REST_API_LOCATION+DefinedConstantsService.FETCH_BY_CRITERIA_URI,options)
  }

  getAllFeaturedCards(parentId:number):Observable<any>{
    let params = new HttpParams().set('objectParentId', JSON.stringify(parentId));
    let options = { headers: this.httpHeaders, params: params };
    return this.http.get(environment.REST_API_LOCATION+DefinedConstantsService.FEATURED_CARDS_URI,options);
  }

  getPostAdTemplate(objectLevel2Id:number,objectLevel3Id:number,objectTypeName:string,objectLevel4Id:number){
    let options

    if(objectLevel4Id){
      let params = new HttpParams()
      .set('objectLevel2Id', JSON.stringify(objectLevel2Id))
      .set('objectLevel3Id', JSON.stringify(objectLevel3Id))
      .set('objectTypeName',objectTypeName)
      .set('objectLevel4Id', JSON.stringify(objectLevel4Id))
      options = { headers: this.httpHeaders, params: params };
    }else{
      let params = new HttpParams()
      .set('objectLevel2Id', JSON.stringify(objectLevel2Id))
      .set('objectLevel3Id', JSON.stringify(objectLevel3Id))
      .set('objectTypeName',objectTypeName)
      options = { headers: this.httpHeaders, params: params };
    }

    return this.http.get(environment.REST_API_LOCATION+DefinedConstantsService.POST_AD_TEMPLATE_RUI,options);
  }

  postAnAdd(postadDto:PostAdDto){
    let headers:HttpHeaders=new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': this.broadcastDataService.userAccessToken
    });
    let options = { headers: headers}
    console.log("postable dto",postadDto);
    return this.http.post(environment.REST_API_LOCATION+DefinedConstantsService.POST_AD_SAVE_URI,postadDto,options)
  }

  getAllChildObjectById(subCategoryId):Observable<any>{
    let params = new HttpParams()
    .set('parentIds', subCategoryId)
    let options = { headers: this.httpHeaders, params: params  };
    return this.http.get(environment.REST_API_LOCATION+DefinedConstantsService.GET_ALL_CHILD_OBJECT_CATEGORIES,options)
  }

  getUserRegistrationTemplate():Observable<any>{
    let options = { headers: this.httpHeaders}
    return this.http.get(environment.REST_API_LOCATION+DefinedConstantsService.SAVE_USER_TEMPLATE_RUI,options)
  }

  generateOtp(phoneNumber:string):Observable<any>{
    let params = new HttpParams()
    .set('phoneNumber', phoneNumber)
    let options = { headers: this.httpHeaders, params: params  };
    return this.http.get(environment.REST_API_LOCATION+DefinedConstantsService.GENERATE_OTP_URI,options)
  }

  verifyOtp(phoneNumber:string,OTP:string):Observable<any>{
    let params = new HttpParams()
    .set('phoneNumber', phoneNumber).set('otpnum',OTP);
    let options = { headers: this.httpHeaders, params: params  };
    return this.http.get(environment.REST_API_LOCATION+DefinedConstantsService.VERIFY_OTP_URI,options)
  }

  getAllDefindedCategories():Observable<any>{
    return this.http.get(environment.REST_API_LOCATION+DefinedConstantsService.ALL_ACTEGORIES_URI)
  }

  uploadAllFile(files:FormData){
    let headers:HttpHeaders=new HttpHeaders({     
      'Authorization': this.broadcastDataService.userAccessToken
    });
    headers.append('Content-Type', 'multipart/form-data');
    headers.append('Accept', 'application/json');
    let options = { headers: headers}
    return this.http.post(environment.REST_API_LOCATION+"/api/yellow-pages/v1/storage/uploadFiles",files,options);
  }
}

