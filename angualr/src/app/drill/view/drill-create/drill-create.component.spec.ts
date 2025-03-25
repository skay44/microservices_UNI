import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DrillCreateComponent } from './drill-create.component';

describe('ColonyCreateComponent', () => {
  let component: DrillCreateComponent;
  let fixture: ComponentFixture<DrillCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DrillCreateComponent]
    });
    fixture = TestBed.createComponent(DrillCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
