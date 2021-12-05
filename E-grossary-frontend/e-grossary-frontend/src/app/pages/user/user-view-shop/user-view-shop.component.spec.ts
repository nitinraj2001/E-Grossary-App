import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewShopComponent } from './user-view-shop.component';

describe('UserViewShopComponent', () => {
  let component: UserViewShopComponent;
  let fixture: ComponentFixture<UserViewShopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserViewShopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewShopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
