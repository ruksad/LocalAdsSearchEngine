import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostAdVerifyPhonenumberComponent } from './post-ad-verify-phonenumber.component';

describe('PostAdVerifyPhonenumberComponent', () => {
  let component: PostAdVerifyPhonenumberComponent;
  let fixture: ComponentFixture<PostAdVerifyPhonenumberComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostAdVerifyPhonenumberComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostAdVerifyPhonenumberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
