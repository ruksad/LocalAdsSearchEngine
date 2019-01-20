import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForSaleCategoriesComponent } from './for-sale-categories.component';

describe('ForSaleCategoriesComponent', () => {
  let component: ForSaleCategoriesComponent;
  let fixture: ComponentFixture<ForSaleCategoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForSaleCategoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForSaleCategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
