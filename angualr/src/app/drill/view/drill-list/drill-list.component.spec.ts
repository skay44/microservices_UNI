import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DrillListComponent } from './drill-list.component';

describe('DrillListComponent', () => {
  let component: DrillListComponent;
  let fixture: ComponentFixture<DrillListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DrillListComponent]
    });
    fixture = TestBed.createComponent(DrillListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
