import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StaticCategoriesComponent } from './static-categories.component';

describe('StaticCategoriesComponent', () => {
  let component: StaticCategoriesComponent;
  let fixture: ComponentFixture<StaticCategoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StaticCategoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StaticCategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
