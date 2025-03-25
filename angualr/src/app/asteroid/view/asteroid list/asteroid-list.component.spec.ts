import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsteroidListComponent } from './asteroid-list.component';

describe('EmpireListComponent', () => {
  let component: AsteroidListComponent;
  let fixture: ComponentFixture<AsteroidListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AsteroidListComponent]
    });
    fixture = TestBed.createComponent(AsteroidListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
