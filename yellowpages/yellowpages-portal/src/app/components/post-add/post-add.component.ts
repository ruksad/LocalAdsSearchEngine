import { Component, OnInit, Attribute, ViewChild } from '@angular/core';
import { SearchService } from '../../services/search.service';
import { PostAdDto } from '../../models/post-ad-dto';
import { ActivatedRoute } from '@angular/router';
import { UtilsService } from '../../services/utils.service';
import { DefinedConstantsService } from '../../services/defined-constants.service';
import { BroadcastDataService } from '../../services/broadcast-data.service';
import * as $ from 'jquery';
import { PostAdVerifyPhonenumberComponent } from "./post-ad-verify-phonenumber/post-ad-verify-phonenumber.component";

@Component({
  selector: 'app-post-add',
  templateUrl: './post-add.component.html',
  styleUrls: ['./post-add.component.css']
})
export class PostAddComponent implements OnInit {

  postadDto: PostAdDto;

  allCategories: any[];

  selectedCategoryLevel2: any;
  selectedCategoryLevel3: any;
  selectedCategoryLevel4: any;
  categoriesPlaceHolder: string = 'Please select leaf node level post add object';

  isCategoryDropDownTobeShown: boolean = true;
  isTemplateFound: boolean = false;
  isCategoryVehicles: boolean = false;

  isCategoryForPropertiesForSaleFlats: boolean = false;
  isCategoryForPropertiesForSaleHouses: boolean = false;
  isCategoryForPropertiesForSaleLands: boolean = false;
  isCategoryForPropertiesForSaleShops: boolean = false;
  isCategoryForPropertiesForSaleOffices: boolean = false;

  isCategoryForPropertiesForRentFlats: boolean = false;
  isCategoryForPropertiesForRentHouses: boolean = false;
  isCategoryForPropertiesForRentLands: boolean = false;
  isCategoryForPropertiesForRentShops: boolean = false;
  isCategoryForPropertiesForRentOffices: boolean = false;
  isCategoryForPropertiesForRentPg: boolean = false;

  isCategoryForCycles: boolean = false
  isCategoryForMoterbikesOrScooter: boolean = false;

  isCategoryOther: boolean = false;

  model: any;
  year: any;
  color: any;
  condition: any;
  fuel: any;
  km_driven: any;
  transmission: any;

  tittle: string;
  category: string;
  price: any;
  description: any;
  images: any;
  phoneNumber: any;
  email: any;
  posted_by: any;
  cities: any;
  localities: any;

  bedRooms: any;
  carParking: any;
  furnishing: any;
  meals: any;
  facing: any;
  carpetAre: any;
  monthlyMaintenance: any;
  length: any;
  breadth: any;
  plotsize: any

  allCities: any;
  citySearchText: string = '';

  prevAttribute: string;
  mobileValidationStatus: boolean = false;
  otpErrorMessage;

  @ViewChild('verifyOTPModel') verifyOTPModels: PostAdVerifyPhonenumberComponent;

  uploadedFiles: Array<File> = new Array();

  constructor(private searchService: SearchService, private utilsService: UtilsService,
    private broadcastDataService: BroadcastDataService, private definedConstantsService: DefinedConstantsService) { }

  ngOnInit() {
    this.otpErrorMessage = null;
    if (!this.broadcastDataService.allCategories)
      throw new Error("Categories are not present in application broad cast data");

    this.allCategories = this.broadcastDataService.allCategories;

    this.allCities = this.broadcastDataService.allCities;
  }

  selectCategory(selectedCategoryLevel2: any, selectedCategoryLevel3: any, selectedCategoryLevel4?: any) {
    console.log("post add", selectedCategoryLevel2, selectedCategoryLevel3, selectedCategoryLevel4);

    this.selectedCategoryLevel2 = selectedCategoryLevel2;
    this.selectedCategoryLevel3 = selectedCategoryLevel3;
    if (selectedCategoryLevel4) {
      this.selectedCategoryLevel4 = selectedCategoryLevel4;
      this.categoriesPlaceHolder = selectedCategoryLevel4['objectTypename'];
    } else {
      this.categoriesPlaceHolder = selectedCategoryLevel3['objectTypename'];
    }
  }

  fectCategroyObject(categroy: string): any {
    let foundObjectIs: any;
    foundObjectIs = this.utilsService.getCategoryObjectFromAllCategories(categroy);
    return foundObjectIs;
  }

  fetchPostAdTemplateOnclick() {
    // this.broadcastDataService.loginLogoutModal.next(true);
    if (this.selectedCategoryLevel4) {
      this.fetchPostAdTemplate(this.selectedCategoryLevel2.objectTypeId, this.selectedCategoryLevel3.objectTypeId,
        this.selectedCategoryLevel4.objectTypename, this.selectedCategoryLevel4.objectTypeId);
    } else if (this.selectedCategoryLevel3) {
      this.fetchPostAdTemplate(this.selectedCategoryLevel2.objectTypeId, this.selectedCategoryLevel3.objectTypeId, this.selectedCategoryLevel3.objectTypename);
    }
  }

  fetchPostAdTemplate(objectLevel2Id: number, objectLevel3Id: number, objectTypeName: string, objectLevel4Id?: number) {


    this.searchService.getPostAdTemplate(objectLevel2Id, objectLevel3Id, objectTypeName, objectLevel4Id).subscribe(
      res => {
        this.postadDto = new PostAdDto(res)
        console.log("he he ", this.postadDto);
      }, (error) => { }, () => {
        this.decideUITemplate();
        this.postadDto.objectTypeId = (this.selectedCategoryLevel3.objectTypeId) ? this.selectedCategoryLevel3.objectTypeId : this.selectedCategoryLevel4.objectTypeId;
        this.postadDto.name = this.tittle;
        this.filterOutTheAttribute('object_type_name').parameterValue = objectTypeName;
        this.assignModels();
        this.isCategoryDropDownTobeShown = false;
        this.isTemplateFound = true;
      }

    )

  }


  decideUITemplate() {

    if (this.selectedCategoryLevel3.objectTypename.toLowerCase() == 'Cycles'.toLowerCase()) {
      this.isCategoryForCycles = true;
      this.isCategoryForMoterbikesOrScooter = false
    } else if (this.selectedCategoryLevel3.objectTypename.toLowerCase() == 'Motorbikes'.toLowerCase() ||
      this.selectedCategoryLevel3.objectTypename.toLowerCase() == 'Scooters'.toLowerCase()) {
      this.isCategoryForCycles = false;
      this.isCategoryForMoterbikesOrScooter = true
    } else {
      this.isCategoryForCycles = false;
      this.isCategoryForMoterbikesOrScooter = false
    }


    if (this.selectedCategoryLevel2.objectTypename.toLowerCase() == DefinedConstantsService.VEHICLES.toLowerCase()) {
      this.isCategoryVehicles = true;


      this.isCategoryForPropertiesForSaleFlats = false;
      this.isCategoryForPropertiesForSaleHouses = false;
      this.isCategoryForPropertiesForSaleLands = false;
      this.isCategoryForPropertiesForSaleShops = false;
      this.isCategoryForPropertiesForSaleOffices = false;

      this.isCategoryForPropertiesForRentFlats = false;
      this.isCategoryForPropertiesForRentHouses = false;
      this.isCategoryForPropertiesForRentPg = false;
      this.isCategoryForPropertiesForRentLands = false;
      this.isCategoryForPropertiesForRentShops = false;
      this.isCategoryForPropertiesForRentOffices = false;


      this.isCategoryOther = false;
    } else if (this.selectedCategoryLevel2.objectTypename.toLowerCase() == DefinedConstantsService.PROPERTIES.toLowerCase()) {
      this.isCategoryVehicles = false;
      this.isCategoryOther = false;
      this.decideTheFlag();

    } else {
      this.isCategoryVehicles = false;
      this.isCategoryOther = true;

      this.isCategoryForPropertiesForSaleFlats = false;
      this.isCategoryForPropertiesForSaleHouses = false;
      this.isCategoryForPropertiesForSaleLands = false;
      this.isCategoryForPropertiesForSaleShops = false;
      this.isCategoryForPropertiesForSaleOffices = false;

      this.isCategoryForPropertiesForRentFlats = false;
      this.isCategoryForPropertiesForRentHouses = false;
      this.isCategoryForPropertiesForRentLands = false;
      this.isCategoryForPropertiesForRentShops = false;
      this.isCategoryForPropertiesForRentOffices = false;
      this.isCategoryForPropertiesForRentPg = false;

    }


  }

  filterOutTheAttribute(attributeName: string): any {
    if (this.prevAttribute != attributeName) {
      this.prevAttribute = attributeName;
      let attribute = this.utilsService.filterOutTheAttribute(this.postadDto.attributeDTOList, attributeName);
      return attribute[0];
    }
  }

  assignModels() {

    this.price = this.filterOutTheAttribute('Price');
    this.model = this.filterOutTheAttribute('Model');
    this.year = this.filterOutTheAttribute('Year');
    this.color = this.filterOutTheAttribute('Color');
    this.condition = this.filterOutTheAttribute('Condition');
    this.fuel = this.filterOutTheAttribute('Fuel');
    this.km_driven = this.filterOutTheAttribute('KM DRIVEN');
    this.images = this.filterOutTheAttribute('Image');
    this.phoneNumber = this.filterOutTheAttribute('Telephone');
    this.transmission = this.filterOutTheAttribute('Transmission');
    this.email = this.filterOutTheAttribute("email");
    this.posted_by = this.filterOutTheAttribute('Posted By');

    this.bedRooms = this.filterOutTheAttribute('Bed Rooms');
    this.carParking = this.filterOutTheAttribute('Car Parking');
    this.furnishing = this.filterOutTheAttribute('Furnishing');
    this.meals = this.filterOutTheAttribute('Meals');
    this.facing = this.filterOutTheAttribute('Facing');

    this.carpetAre = this.filterOutTheAttribute('Carpet Area');
    this.monthlyMaintenance = this.filterOutTheAttribute('Monthly Maintenance');
    this.length = this.filterOutTheAttribute('Length');
    this.breadth = this.filterOutTheAttribute('Breadth');
    this.plotsize = this.filterOutTheAttribute('Plot Size');

    this.cities = this.utilsService.getAllCitiesOfAState(this.broadcastDataService.selectedCity.state.name).cities;
    this.localities = this.postadDto.localityId;

  }

  postAnAd(postAdformStatus) {
    postAdformStatus.submitted = true;
    if (postAdformStatus.valid && this.postadDto.cityId) {
      this.postadDto.name = this.tittle;
      this.searchService.postAnAdd(this.postadDto).subscribe(x => {
        console.log("saved entity", x);
      });
    } else {
      console.log('not a valid form');

    }
  }


  selectCity(event, city) {
    const cityData = this.utilsService.getStateAndCityOfStateFromAllStates(city);
    this.citySearchText = cityData.city.cityName;
    if (cityData.city.cityId) {
      this.postadDto.cityId = cityData.city.cityId;
    } else {
      this.postadDto.cityId = undefined;
    }
  }
  onCitySearchChanges(citySearchText) {
    console.log('change dected')
    if (citySearchText.length < 3) {
      this.postadDto.cityId = undefined;
    }
  }

  resetOnCategoryChange() {
    this.isCategoryVehicles = false;
    this.isCategoryOther = false;
    this.isTemplateFound = false;
    this.tittle = '';
    this.isCategoryDropDownTobeShown = true;

    this.isCategoryForPropertiesForSaleFlats = false;
    this.isCategoryForPropertiesForSaleHouses = false;
    this.isCategoryForPropertiesForSaleLands = false;
    this.isCategoryForPropertiesForSaleShops = false;
    this.isCategoryForPropertiesForSaleOffices = false;

    this.isCategoryForPropertiesForRentFlats = false;
    this.isCategoryForPropertiesForRentHouses = false;
    this.isCategoryForPropertiesForRentLands = false;
    this.isCategoryForPropertiesForRentShops = false;
    this.isCategoryForPropertiesForRentOffices = false;
    this.isCategoryForPropertiesForRentPg = false;
    this.selectedCategoryLevel2 = '';
    this.selectedCategoryLevel3 = '';
    this.selectedCategoryLevel4 = '';
    this.categoriesPlaceHolder = 'Please select leaf node level post add object';

  }

  decideTheFlag() {

    switch (this.selectedCategoryLevel4.objectTypeId) {
      case 90000049:
        this.isCategoryForPropertiesForSaleFlats = true;
        break;
      case 90000050:
        this.isCategoryForPropertiesForSaleHouses = true;
        break;
      case 90000111:
        this.isCategoryForPropertiesForSaleLands = true;
        break;
      case 90000112:
        this.isCategoryForPropertiesForSaleShops = true;
        break;
      case 90000113:
        this.isCategoryForPropertiesForSaleOffices = true;

        break;
      case 90000051:
        this.isCategoryForPropertiesForRentFlats = true;
        break;
      case 90000052:
        this.isCategoryForPropertiesForRentHouses = true;
        break;
      case 90000114:
        this.isCategoryForPropertiesForRentPg = true;
        break;
      case 90000115:
        this.isCategoryForPropertiesForRentLands = true;
        break;
      case 90000116:
        this.isCategoryForPropertiesForRentShops = true;
        break;
      case 90000117:
        this.isCategoryForPropertiesForRentOffices = true;
        break;

    }
  }

  sendOtp() {
    this.otpErrorMessage = null;
    if (this.phoneNumber.parameterValue) {
      this.searchService.generateOtp(this.phoneNumber.parameterValue).subscribe(res => {
        console.log("mobile otp is send successfully");
        this.verifyOTPModels.otpModel(this.phoneNumber.parameterValue);

      }, err => {
        console.log('error');
        this.otpErrorMessage = err.errors[0].message;
      })
    } else {
      throw new Error("mobile number is not set")
    }
  }

  /*  validateOtp(otpNumber: string) {
     if (this.phoneNumber.parameterValue) {
       this.searchService.verifyOtp(this.phoneNumber.parameterValue, otpNumber).subscribe(res => {
         console.log("otp verification", res);
 
       })
     } else {
       throw new Error("mobile number is not set")
     }
   } */

  fileChange(event, imageId) {
    let fileList: FileList = event.target.files;
    if (fileList.length > 0) {
      let file: File = fileList[0];
      let ext = file.name.split('.').pop();
      var reader = new FileReader();
      reader.onload = function (e: any) {


        $(imageId)
          .attr('src', e.target.result)
          .width(50)
          .height(100);
      };

      reader.readAsDataURL(file);
      this.uploadedFiles.push(file)
    }

  }

  uploadFile() {

    let formData: FormData = new FormData();
    this.uploadedFiles.forEach(x => {
      formData.append('files', x, x.name);
    })
    console.log("form data" + formData);


    this.searchService.uploadAllFile(formData).subscribe(res => {
      console.log("file upload", res);

    }, (error) => {
      console.log("file upload failed");

    }, () => {
      console.log("file upload succees");

    })
  }

  updateStatusVerify(event) {
    console.log(event)
    if (event === 'validate_sucess') {
      console.log(true);
      this.mobileValidationStatus = true;
    } else {
      this.mobileValidationStatus = false;
    }
  }
}
