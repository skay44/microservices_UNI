import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsteroidViewComponent } from './asteroid-view.component';

describe('EmpireViewComponent', () => {
  let component: AsteroidViewComponent;
  let fixture: ComponentFixture<AsteroidViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AsteroidViewComponent]
    });
    fixture = TestBed.createComponent(AsteroidViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
