import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DrillEditComponent } from './drill-edit.component';

describe('ColonyEditComponent', () => {
  let component: DrillEditComponent;
  let fixture: ComponentFixture<DrillEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DrillEditComponent]
    });
    fixture = TestBed.createComponent(DrillEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
