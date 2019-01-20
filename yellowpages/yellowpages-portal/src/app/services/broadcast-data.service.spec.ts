import { TestBed, inject } from '@angular/core/testing';

import { BroadcastDataService } from './broadcast-data.service';

describe('BroadcastDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BroadcastDataService]
    });
  });

  it('should be created', inject([BroadcastDataService], (service: BroadcastDataService) => {
    expect(service).toBeTruthy();
  }));
});
