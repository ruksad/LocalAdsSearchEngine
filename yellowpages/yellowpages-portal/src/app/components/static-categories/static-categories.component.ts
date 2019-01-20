import { Component, OnInit } from '@angular/core';
import { DefinedConstantsService } from '../../services/defined-constants.service';
import { BroadcastDataService } from '../../services/broadcast-data.service';
import { SearchService } from '../../services/search.service';
import { SearchCriteriaModel } from '../../models/search-criteria-model';
import { UtilsService } from '../../services/utils.service';

@Component({
  selector: 'app-static-categories',
  templateUrl: './static-categories.component.html',
  styleUrls: ['./static-categories.component.css']
})
export class StaticCategoriesComponent implements OnInit {
  selectedCategory: any;

  constructor(public definedConstantsService: DefinedConstantsService,
    private broadcastDataService: BroadcastDataService,
    private searchService: SearchService,
    private utilsService: UtilsService) { }

  ngOnInit() {
  }

  fetchByCategoryInSelectedCity(superCategory: string) {
    let superCategory1 = this.utilsService.getCategoryObjectFromAllCategories(superCategory);
    this.broadcastDataService.castParentSelectedState.subscribe(selectedData => {
      if (selectedData) {
        this.utilsService.navigateToForSale();
        let selectedCategoryString: any = this.utilsService.returnCategoryString(superCategory)
        if (!(selectedCategoryString == DefinedConstantsService.EMPTYCATEGORY)) {
          this.selectedCategory = this.fectCategroyObject(selectedCategoryString);
        } else {
          this.selectedCategory = superCategory;
        }
      } else
        throw new Error("city is not selected for the category");
    })

    if(this.selectedCategory){
        /* adding parent category name to the selected category 
    to find the object belong to in further case same as parent category object */
      this.selectedCategory.categoryName=this.selectedCategory.objectTypename;
      this.broadcastDataService.updateparentSelectedCategory(this.selectedCategory);
    }
  }

  fectCategroyObject(categroy: string): any {
    let foundObjectIs: any;
    foundObjectIs = this.utilsService.getCategoryObjectFromAllCategories(categroy);
    return foundObjectIs;
  }
}
