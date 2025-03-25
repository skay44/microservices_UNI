import { TestBed } from '@angular/core/testing';

import { AsteroidService } from './asteroid.service';

describe('EmpireService', () => {
  let service: AsteroidService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AsteroidService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
