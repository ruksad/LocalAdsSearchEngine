import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { DefinedConstantsService } from './defined-constants.service';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/environment';
import 'rxjs/add/operator/map'
import { forkJoin } from "rxjs/observable/forkJoin";
import { SearchCriteriaModel } from '../models/search-criteria-model';
import { PostAdDto } from '../models/post-ad-dto';

@Injectable()
export class UserLoginService {

  constructor(private http: HttpClient) { }

  
  registerUser(postadDto:PostAdDto){
    let headers:HttpHeaders=new HttpHeaders({
      'Content-Type': 'application/json',  
    });
    let options = { headers: headers}
    console.log("postable dto",postadDto);    
    return this.http.post(environment.REST_API_LOCATION+DefinedConstantsService.REGISTER_USER_URI,postadDto,options)
  }

  userLogin(username:string,password:string){
      let userdata={'username':username,'password':password}
    return this.http.post(environment.REST_API_LOCATION+DefinedConstantsService.AUTHENTICATION_URI,userdata)
  }
}
