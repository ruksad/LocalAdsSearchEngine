import { Injectable } from '@angular/core';
import { BroadcastDataService } from './broadcast-data.service';
import { DefinedConstantsService } from './defined-constants.service';
import { FeaturedCard } from '../models/featured-cards';

import { Router } from '@angular/router';

@Injectable()
export class UtilsService {

  constructor(private broadcastDataService: BroadcastDataService, private definedConstantsService: DefinedConstantsService,
    private router: Router) { }

  getCategoryObjectFromAllCategories(objectToFindBy: String, arrayToFinObjectdIn ? : any[]): any {
    let foundObject:any;
    if (arrayToFinObjectdIn) {
     foundObject=arrayToFinObjectdIn.find(x => x['objectTypename']==objectToFindBy)
    } else {
      if(this.broadcastDataService.allCategories)
          foundObject=this.broadcastDataService.allCategories.find(x => x['objectTypename']==objectToFindBy)
      else
          throw new Error("categories are not present in broadcast data service");
    }
    return foundObject;
  }

  getStateAndCityOfStateFromAllStates(city: String): any {
    let foundObject: any;
    this.broadcastDataService.allCitiesAndStates.forEach(
      x => {
        let city1 ;
         x.cities.forEach(element => {  
         if (element.cityName == city) {
          city1= element;   
          return;
         }
        });

        if (city1){
        foundObject =  { 'city': city1,  'state': {  'name': x.name, 'stateId': x.stateId }}        
        }
      }
    )
    return foundObject;
  }


  getAllCitiesOfAState(state:string){
    let found=this.broadcastDataService.allCitiesAndStates.filter(x=>{
      if(x.name.toLowerCase()==state.toLowerCase()) return x;   })
      return found[0];
  }


  returnCategoryString(category:string):string{
    switch(category){
      case DefinedConstantsService.FURNITURE:
      return DefinedConstantsService.FURNITURE;
      case DefinedConstantsService.PROPERTIES:
      return DefinedConstantsService.PROPERTIES;
      case DefinedConstantsService.VEHICLES:
      return DefinedConstantsService.VEHICLES;
      case DefinedConstantsService.ELECTRONICS_HOME_APPLIANCES:
      return DefinedConstantsService.ELECTRONICS_HOME_APPLIANCES;
      case DefinedConstantsService.PETS:
      return DefinedConstantsService.PETS;
      case DefinedConstantsService.KIDS:
      return DefinedConstantsService.KIDS;
      case DefinedConstantsService.SERVICES:
      return DefinedConstantsService.SERVICES;
      case DefinedConstantsService.JOBS:
      return DefinedConstantsService.JOBS;
      case DefinedConstantsService.BOOKS_SOFTWARE:
      return DefinedConstantsService.BOOKS_SOFTWARE;
      case DefinedConstantsService.FASHION_BEAUTY:
      return DefinedConstantsService.FASHION_BEAUTY;
      default:
      return DefinedConstantsService.EMPTYCATEGORY;
    }
  }

  convertObjectsToCards(allFeaturedCards: any[]): FeaturedCard[] {
    let cards: FeaturedCard[] = new Array();
    if (allFeaturedCards) {
      allFeaturedCards.forEach(x => {
        let card = new FeaturedCard();
        card.name = x.name;
        card.description = x.description;
        card.objectId = x.objectId;
        card.parentId = x.parentId;
        if(x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == DefinedConstantsService.PRICE_LOWERCASE)){
        card.price=x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == DefinedConstantsService.PRICE_LOWERCASE).parameterValues[0];
        }else{
          card.price=0;
        }
        if(x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == DefinedConstantsService.PRIORITY_LOWERCASE).parameterValues[0]){
        card.priority=x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == DefinedConstantsService.PRIORITY_LOWERCASE).parameterValues[0];
        }else{
          card.priority=-1;
        }
        card.image='assets/images/'+x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == DefinedConstantsService.IMAGE_LOWERCASE).parameterValues[0];
        cards.push(card)
      })
      cards.sort((a,b)=>a.priority-b.priority)
      return cards;
    } else
      throw new Error("Featured cards are blank")
  }

  filterOutTheAttribute(arrayToBegfiltered:any[],valueToBefiltered:string){
    let found =arrayToBegfiltered.filter(x=>{
      if(x.attributeName.toLowerCase()==valueToBefiltered.toLowerCase())
        return x;
    })    
    return found;
    
  }


  ConvertObjectToSaleView(allParameterObjects) {
    let SaleObjects = [];
    if (allParameterObjects) {
      allParameterObjects.forEach(x => {
        let object: any = {};
        object.description = x.description;
        object.objectId = x.objectId;
        object.parentId = x.parentId;
        object.name = (x.name) ? x.name : undefined

        const phonenumber = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'telephone');
        object.phonenumber = (phonenumber) ? phonenumber.parameterValues[0] : undefined;

        const model = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'model');
        object.model = (model) ? model.parameterValues[0] : '';

        const city = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'city');
        object.city = (city) ? city.parameterValues[0] : undefined;

        const color = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'color');
        object.color = (color) ? color.listValues[0] : undefined;

        const year = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'year');
        object.year = (year) ? year.listValues[0] : undefined;

        const condition = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'condition');
        object.condition = (condition) ? condition.listValues[0] : undefined;

        const fuel = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'fuel');
        object.fuel = (fuel) ? fuel.listValues[0] : undefined;

        const transmission = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'transmission');
        object.transmission = (transmission) ? transmission.listValues[0] : undefined;

        const km_driven = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'km driven');
        object.km_driven = (km_driven) ? km_driven.parameterValues[0] : undefined;

        const YOUR_EMAIL = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'email');
        object.email = (YOUR_EMAIL) ? YOUR_EMAIL.parameterValues[0] : undefined;

        const address = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'address');
        object.address = (address) ? address.parameterValues[0] : undefined;

        const price = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'price');
        object.price = (price) ? price.parameterValues[0] : undefined;

        const image = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'image');
        object.image = (image) ? 'assets/images/'+image.parameterValues[0] : undefined;

        const object_type_name = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'object_type_name');
        object.object_type_name = (object_type_name) ? object_type_name.parameterValues[0] : undefined;

        const posted_date = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'posted date');
        object.posted_date = (posted_date) ? posted_date.parameterValues[0] : undefined;
        
        const registered_since = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'registered since');
        object.registered_since = (registered_since) ? registered_since.parameterValues[0] : undefined;

        const ad_id = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'ad id');
        object.ad_id = (ad_id) ? ad_id.parameterValues[0] : undefined;

        const posted_by = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'posted by');
        object.posted_by = (posted_by) ? posted_by.parameterValues[0] : undefined;

        const status = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'status');
        object.status = (status) ? status.parameterValues[0] : undefined;

        const carpet_area = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'carpet area');
        object.carpet_area = (carpet_area) ? carpet_area.parameterValues[0] : undefined;

        const bedrooms = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'bed rooms');
        object.bedrooms = (bedrooms) ? bedrooms.listValues[0] : undefined;

        const car_parking = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'car parking');
        object.car_parking = (car_parking) ? car_parking.listValues[0] : undefined;

        const properties_listed_by = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'properties_listed_by');
        object.properties_listed_by = (properties_listed_by) ? properties_listed_by.listValues[0] : undefined;
        
        const monthly_maintenance = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'monthly maintenance');
        object.monthly_maintenance = (monthly_maintenance) ? monthly_maintenance.parameterValues[0] : undefined;

        const furnishing = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'furnishing');
        object.furnishing = (furnishing) ? furnishing.listValues[0] : undefined;

        const length = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'length');
        object.length = (length) ? length.parameterValues[0] : undefined;

        const breadth = x.parametersForAttribute.find(parameter => parameter.name.toLowerCase() == 'breadth');
        object.breadth = (breadth) ? breadth.parameterValues[0] : undefined;

        const facing = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'facing');
        object.facing = (facing) ? facing.listValues[0] : undefined;

        const meals = x.listForAttribute.find(parameter => parameter.attributeName.toLowerCase() == 'meals');
        object.meals = (meals) ? meals.listValues[0] : undefined;

      
        SaleObjects.push(object);
      })
    }
    return SaleObjects;
  }

  navigateToForSale() {
    this.router.navigate([DefinedConstantsService.FOR_SALE]);
  }
}
