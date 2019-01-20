import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForSaleViewComponent } from './for-sale-view.component';

describe('ForSaleViewComponent', () => {
  let component: ForSaleViewComponent;
  let fixture: ComponentFixture<ForSaleViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForSaleViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForSaleViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
