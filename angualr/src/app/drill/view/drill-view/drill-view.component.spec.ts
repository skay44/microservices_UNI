import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DrillViewComponent } from './drill-view.component';

describe('ColonyListComponent', () => {
  let component: DrillViewComponent;
  let fixture: ComponentFixture<DrillViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DrillViewComponent]
    });
    fixture = TestBed.createComponent(DrillViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
