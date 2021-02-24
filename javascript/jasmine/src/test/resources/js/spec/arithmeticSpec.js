describe("Arithmetic", function() {
  
  var arithmetic;

  beforeEach(function() {
    arithmetic = new Arithmetic();
  });

  it("should be able to add two numbers", function() {
    var added = arithmetic.add(1,1);
	expect(added).toEqual(2);
  });

  it("should be able to subtract two numbers", function() {
    var subtracted = arithmetic.subtract(1,1);
    expect(subtracted).toEqual(0);
  });
  
  it("should be able to subtract two numbers and return a negative result", function() {
    var subtracted = arithmetic.subtract(1,2);
    expect(subtracted).toEqual(-1);
  });

});
