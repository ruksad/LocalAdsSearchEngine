import { Injectable, OnInit } from '@angular/core';
import { LocalStorageModel } from '../models/local-storage';

@Injectable()
export class SessionStorageService implements OnInit{
  public static readonly APP_STORE:string='appStore';

  localStorage:LocalStorageModel=new LocalStorageModel();

  constructor() { }

  ngOnInit(): void {
    if(this.isAppStoreDataPresentInLocal())
    {
      console.log("data is present in the session ================ ");
      this.localStorage=Object.assign({}, JSON.parse(sessionStorage.getItem(SessionStorageService.APP_STORE)));
    }
  }

  public setObject(key:string,value:any){
    localStorage.setItem(key,JSON.stringify(value));
  }

  public saveSessionStorage():void{
    localStorage.setItem(SessionStorageService.APP_STORE,JSON.stringify(this.localStorage))
  }

  public isAppStoreDataPresentInLocal():boolean{
   let b:any=(localStorage.getItem(SessionStorageService.APP_STORE))?true:false;
   console.log("is app refreshable",b);   
    return b;
  }

  public retriveAppStoreData(){
    this.localStorage=Object.assign({}, JSON.parse(localStorage.getItem(SessionStorageService.APP_STORE)));
  }
}
