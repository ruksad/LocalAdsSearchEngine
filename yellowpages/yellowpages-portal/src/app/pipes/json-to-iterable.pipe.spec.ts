import { JsonToIterablePipe } from './json-to-iterable.pipe';

describe('JsonToIterablePipe', () => {
  it('create an instance', () => {
    const pipe = new JsonToIterablePipe();
    expect(pipe).toBeTruthy();
  });
});
