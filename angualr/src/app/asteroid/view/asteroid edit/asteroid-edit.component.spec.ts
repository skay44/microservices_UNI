import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsteroidEditComponent } from './asteroid-edit.component';

describe('EmpireEditComponent', () => {
  let component: AsteroidEditComponent;
  let fixture: ComponentFixture<AsteroidEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AsteroidEditComponent]
    });
    fixture = TestBed.createComponent(AsteroidEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
