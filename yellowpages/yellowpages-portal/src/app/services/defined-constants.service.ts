import { Injectable } from '@angular/core';

@Injectable()
export class DefinedConstantsService {

  public static readonly SEARCH: string = '/search';
  public static readonly FOR_SALE = '/for-sale';
  public static readonly CONTENT_TYPE:string = 'Content-type';
  public static readonly ACCEPT:string = 'Accept';
  public static readonly ACCESS_CONTORLE_ALL_ORIGIN='Access-Control-Allow-Origin';
  public static readonly APPLICATION_JSON:string = 'application/json';
  public static readonly AUTHERIZATION:string ='Authorization'
  public static readonly BEARER:string='Bearer';

  public static readonly GETALLCITIES_URI:string = '/api/yellow-pages/v1/getStatesAndCities';
  public static readonly GETALLCATEGORIES_URI:string= '/api/yellow-pages/v1/find/object-type/all-categories';
  public static readonly FETCH_BY_CRITERIA_URI:string='/api/yellow-pages/v1/criteria';
  public static readonly GET_ALL_CHILD_OBJECT_CATEGORIES:string='/api/yellow-pages/v1/find/object-type/object-type';
  public static readonly POST_AD_TEMPLATE_RUI:string='/api/yellow-pages/v1/get-post-ad-template';
  public static readonly POST_AD_SAVE_URI:string='/api/yellow-pages/v1/authorize/save/object-for-object-type';
  public static readonly FEATURED_CARDS_URI:string='/api/yellow-pages/v1/featured-cards';
  public static readonly SAVE_USER_TEMPLATE_RUI:string='/api/yellow-pages/v1/get-add-user-template';
  public static readonly REGISTER_USER_URI:string='/api/yellow-pages/v1/user/registration'
  public static readonly AUTHENTICATION_URI:string='/auth';
  public static readonly GENERATE_OTP_URI:string='/api/yellow-pages/v1/otp/generateOtp';
  public static readonly VERIFY_OTP_URI:string='/api/yellow-pages/v1/otp/validateOtp';
  public static readonly ALL_ACTEGORIES_URI:string=' /api/yellow-pages/v1/categories';


  public static readonly EMPTYCATEGORY:string='EMPTYCATEGORY';
  public static readonly FURNITURE:string='FURNITURE';
  public static readonly PROPERTIES:string='PROPERTIES';
  public static readonly VEHICLES:string='VEHICLES';
  public static readonly ELECTRONICS_HOME_APPLIANCES:string='ELECTRONICS & HOME APPLIANCES';
  public static readonly PETS:string='PETS';
  public static readonly KIDS:string='KIDS';
  public static readonly SERVICES:string='SERVICES';
  public static readonly JOBS:string='JOBS';
  public static readonly BOOKS_SOFTWARE='Events & Software';
  public static readonly FASHION_BEAUTY:string='FASHION & BEAUTY';

  public  readonly FURNITURE_TEMPLATE:string='FURNITURE';
  public  readonly PROPERTIES_TEMPLATE:string='PROPERTIES';
  public  readonly VEHICLES_TEMPLATE:string='VEHICLES';
  public  readonly ELECTRONICS_HOME_APPLIANCES_TEMPLATE:string='ELECTRONICS & HOME APPLIANCES';
  public  readonly PETS_TEMPLATE:string='PETS';
  public  readonly KIDS_TEMPLATE:string='KIDS';
  public  readonly SERVICES_TEMPLATE:string='SERVICES';
  public  readonly JOBS_TEMPLATE:string='JOBS';
  public  readonly BOOKS_SOFTWARE_TEMPLATE='Events & Software';
  public  readonly FASHION_BEAUTY_TEMPLATE:string='FASHION & BEAUTY';  
  public static readonly PRICE_LOWERCASE='price';
  public static readonly PRIORITY_LOWERCASE='priority';
  public static readonly IMAGE_LOWERCASE='image';
  public static readonly POST_A_FREE_ADD_TAB='post_a_free_tab';
  public static readonly IMAGE_PATH='assets/images/';
  public static readonly POST_AN_ADD_ROUTE='/post-an-add';

  public readonly PRICE='Price';

  constructor() {}

}

