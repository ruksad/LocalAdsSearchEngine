import { Component, OnInit, OnDestroy } from '@angular/core';
import { BroadcastDataService } from '../../../services/broadcast-data.service';

@Component({
  selector: 'app-for-sale-categories',
  templateUrl: './for-sale-categories.component.html',
  styleUrls: ['./for-sale-categories.component.css']
})
export class ForSaleCategoriesComponent implements OnInit, OnDestroy {
  public subCategories;
  public subscribeCategoryList;
  constructor(private broadcastDataService: BroadcastDataService) { }

  ngOnInit() {
    this.subscribeCategoryList = this.broadcastDataService.castParentSelectedCategory.subscribe(data => {
      this.subCategories = data;
    })
  }
  selectCategoryObject(selectedCategory, subParentCategoryName) {
    /*  adding parent category name to the selected category 
     to find the object belong to in further uses */
    selectedCategory.categoryName = this.subCategories.categoryName;
    selectedCategory.subCategoryName = subParentCategoryName;
    //  this.broadcastDataService.cleanupForSaleCategorySelected();
    this.broadcastDataService.updateForSaleCategorySelected(selectedCategory);
  }
  ngOnDestroy() {
    this.subscribeCategoryList.unsubscribe();
  }

}
