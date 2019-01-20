import { TestBed, inject } from '@angular/core/testing';

import { LoadExternalApiService } from './load-external-api.service';

describe('LoadExternalApiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoadExternalApiService]
    });
  });

  it('should be created', inject([LoadExternalApiService], (service: LoadExternalApiService) => {
    expect(service).toBeTruthy();
  }));
});
