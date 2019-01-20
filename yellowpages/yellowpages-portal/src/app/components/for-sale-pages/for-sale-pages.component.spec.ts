import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForSalePagesComponent } from './for-sale-pages.component';

describe('ForSalePagesComponent', () => {
  let component: ForSalePagesComponent;
  let fixture: ComponentFixture<ForSalePagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForSalePagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForSalePagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
