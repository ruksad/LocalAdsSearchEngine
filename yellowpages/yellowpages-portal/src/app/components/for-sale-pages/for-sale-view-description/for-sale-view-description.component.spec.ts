import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForSaleViewDescriptionComponent } from './for-sale-view-description.component';

describe('ForSaleViewDescriptionComponent', () => {
  let component: ForSaleViewDescriptionComponent;
  let fixture: ComponentFixture<ForSaleViewDescriptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForSaleViewDescriptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForSaleViewDescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
