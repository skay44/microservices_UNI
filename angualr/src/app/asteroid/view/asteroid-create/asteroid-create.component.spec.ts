import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsteroidCreateComponent } from './asteroid-create.component';

describe('EmpireCreateComponent', () => {
  let component: AsteroidCreateComponent;
  let fixture: ComponentFixture<AsteroidCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AsteroidCreateComponent]
    });
    fixture = TestBed.createComponent(AsteroidCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
