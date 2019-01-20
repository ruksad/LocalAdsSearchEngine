import { Component, OnInit, DoCheck, Input, Output, EventEmitter } from '@angular/core';
import { UtilsService } from '../../services/utils.service';
import { DefinedConstantsService } from '../../services/defined-constants.service';
import { SearchService } from '../../services/search.service';

@Component({
  selector: 'app-search-field',
  templateUrl: './search-field.component.html',
  styleUrls: ['./search-field.component.css']
})
export class SearchFieldComponent implements OnInit,DoCheck {


  @Input()
  allCategories:any;
  @Output()
  selectedCategoryEmit:EventEmitter<any> =new EventEmitter();
  constructor(private utilsService:UtilsService, public definedConstantsService:DefinedConstantsService,public searchService:SearchService) { }

  selectedCategory:any;
  selectedInnerCategory:any;
  categoriesPlaceHolder:string='Categories';
  supportedCategories:any[];
  
  ngOnInit() {
    this.searchService.getAllDefindedCategories().subscribe(res=>{
      this.supportedCategories=res;
    })
  }

  selectCategory(category, categoryName?, ChildcategoryName?) {
    this.utilsService.navigateToForSale();

   let selectedCategoryString:any= this.utilsService.returnCategoryString(category)
   if(!(selectedCategoryString==DefinedConstantsService.EMPTYCATEGORY))
      this.selectedCategory=this.fectCategroyObject(selectedCategoryString);
    else
      this.selectedCategory=category;
    this.categoriesPlaceHolder=this.selectedCategory['objectTypename'];

    /* adding parent category name to the selected category
    to find the object belong to in further case */
    if(categoryName){
    this.selectedCategory.categoryName=categoryName;
    }else{
      this.selectedCategory.categoryName=category;
    }

    if (category.childObjectTypes != null && category.childObjectTypes.length >= 0) {
      category.subCategoryName = category.objectTypename;
    }
    if (ChildcategoryName) {
      category.subCategoryName = ChildcategoryName;
    }

    this.selectedCategoryEmit.emit(this.selectedCategory);

  }

  ngDoCheck(): void {
  }

  fectCategroyObject(category:string):any{
    let foundObjectIs:any;
    foundObjectIs=this.utilsService.getCategoryObjectFromAllCategories(category);
    return foundObjectIs;
  }

}
