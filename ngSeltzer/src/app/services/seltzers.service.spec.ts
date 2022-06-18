import { TestBed } from '@angular/core/testing';

import { SeltzersService } from './seltzers.service';

describe('SeltzersService', () => {
  let service: SeltzersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeltzersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
