import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserdataComponent } from './userdata.component';

describe('UserdataComponent', () => {
  let component: UserdataComponent;
  let fixture: ComponentFixture<UserdataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserdataComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UserdataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
