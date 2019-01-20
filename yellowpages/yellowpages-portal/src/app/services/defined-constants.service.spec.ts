import { TestBed, inject } from '@angular/core/testing';

import { DefinedConstantsService } from './defined-constants.service';

describe('DefinedConstantsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DefinedConstantsService]
    });
  });

  it('should be created', inject([DefinedConstantsService], (service: DefinedConstantsService) => {
    expect(service).toBeTruthy();
  }));
});
