import { Component, OnInit, Input, DoCheck, Output, EventEmitter, ChangeDetectorRef, ChangeDetectionStrategy, ViewChild } from '@angular/core';
import { UtilsService } from '../../services/utils.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { ElementRef } from '@angular/core/src/linker/element_ref';
import { SearchService } from '../../services/search.service';
import { DefinedConstantsService } from '../../services/defined-constants.service';
import { SessionStorageService } from '../../services/session-storage.service';
import { Router,  Route, NavigationStart } from '@angular/router';
import { BroadcastDataService } from '../../services/broadcast-data.service';
import { PostAdDto } from '../../models/post-ad-dto';
import { UserLoginService } from '../../services/user-login.service';
declare var $:any;

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit,DoCheck {


  @ViewChild('mymodal') modal;
  @ViewChild('close1') close1;
  @ViewChild('close2') close2;
  @ViewChild('close3') close3;
  @ViewChild('loginOrReginster') loginModal;
  isloginModalOpen:boolean=false;
  postadDto:PostAdDto;


  @Input()
  public statesAndCities:any;
  @Output()
  public selectedCityEmit:EventEmitter<string> = new EventEmitter<string>();
  @Output()
  public postAdSlectedTabEmit:EventEmitter<boolean>=new EventEmitter();

  public popularCities:string[];
  public statesWithCity:any[];

  public selectedCity:any;
  public slelectedCityAndStatePlaceHolder:string='Select A Region';
  public selectedState:any;
  public isPostAnAdTabSelected:boolean=false;
  public searchText: string = '';
  public allCities: any;

  userName:any=''
  userTelephone:any='';
  userEmail:any='';
  userPassword:any='';

  constructor(private utilsService:UtilsService,private sessionStorageService:SessionStorageService,
  private router:Router,private broadcastDataService:BroadcastDataService,private searchService:SearchService,
  private userLoginService:UserLoginService) { }

  ngOnInit() {

    this.broadcastDataService.loginLogoutModal.subscribe(res=>{
      console.log("in modal subscription",res);
      if(res=true)
        this.closeOpenLoginModal();
      this.isloginModalOpen=res;
    })

    if(this.selectedCity == undefined && !this.sessionStorageService.localStorage.selectedCityAndStateWithAllLocalities) {
      this.modal.nativeElement.click();
    }else if(this.sessionStorageService.localStorage.selectedCityAndStateWithAllLocalities){
      this.selectState(this.sessionStorageService.localStorage.selectedCityAndStateWithAllLocalities.state);
      this.selectCity(undefined,this.sessionStorageService.localStorage.selectedCityAndStateWithAllLocalities.city.cityName)
    }
  }

  findAllCities(cities) {
    let citiesArray: any = [];

    cities.forEach(statesData => {
      statesData.cities.forEach(citiesData => {
        citiesArray.push(citiesData.cityName.toString())
      })
    })
    this.allCities = citiesArray;
    this.broadcastDataService.allCities = citiesArray;
  }


  ngDoCheck(): void {
    if (this.statesAndCities) {
      this.popularCities = this.statesAndCities.popularCities;
      this.statesWithCity = this.statesAndCities.states;
      this.findAllCities(this.statesAndCities.states)
      if (!this.selectedState)
        this.selectedState = this.statesAndCities.states[0];
    }
  }

  public selectCity($event, city){
      this.selectedCity=this.utilsService.getStateAndCityOfStateFromAllStates(city);
      this.slelectedCityAndStatePlaceHolder=this.selectedCity['city']['cityName'] +','+this.selectedCity['state']['name'];
      this.selectedCityEmit.emit(this.selectedCity);
  }

  public selectState(state){
    if(state){
      this.selectedState=state;
    }
  }

  public closeModal1() {
    this.close1.nativeElement.click();
  }

  public closeModal2() {
    this.close2.nativeElement.click();
  }

  public closeModal3() {
    this.close3.nativeElement.click();
  }

  public routeToPostAdd(){
    this.isPostAnAdTabSelected=true;
    this.postAdSlectedTabEmit.emit(this.isPostAnAdTabSelected);
    this.router.navigate([DefinedConstantsService.POST_AN_ADD_ROUTE])
  }

  closeOpenLoginModal(){
    document.getElementById("loginOrReginster").click();
  }

  register(){
    this.isloginModalOpen=false;
   // this.closeOpenLoginModal();
    this.broadcastDataService.loginLogoutModal.next(this.isloginModalOpen)
    this.postadDto.name=this.userName;
    this.userLoginService.registerUser(this.postadDto).subscribe(res=>{

    },(error)=>{},()=>{
        console.log("user is registered sucess fully"+" please go to login");
        this.userName='';
        this.userTelephone = '';
        this.userEmail = '';
        this.userPassword = '';        
    })
  }


  login(){
    this.userLoginService.userLogin(this.userName,this.userPassword).subscribe(res=>{
      this.broadcastDataService.userAccessToken=this.broadcastDataService.userAccessToken+ res['token'];
    },(error)=>{

    },()=>{
        console.log("you are success fully logged in ");
       if(this.isloginModalOpen=true){
        // this.closeOpenLoginModal();
         this.broadcastDataService.loginLogoutModal.next(false)
       } 
    })
  }

  registerTemplateFetch(){
    this.searchService.getUserRegistrationTemplate().subscribe(res=>{
      this.postadDto=new PostAdDto(res);
    },(error)=>{},()=>{
      this.assignModels();
    });
  }

  filterOutTheAttribute(attributeName:string):any{
     let attribute=this.utilsService.filterOutTheAttribute(this.postadDto.attributeDTOList,attributeName);
     return attribute[0];
  }

  assignModels(){
    this.userName=this.postadDto.name;
    this.userTelephone = this.filterOutTheAttribute('Telephone');
    this.userEmail = this.filterOutTheAttribute('email');
    this.userPassword = this.filterOutTheAttribute('password');

  }
}
