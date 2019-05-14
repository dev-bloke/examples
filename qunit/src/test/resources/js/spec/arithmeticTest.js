test("arithmetic basics", function(assert) {
    var arithmetic = new Arithmetic();
    equal(2, arithmetic.add(1,1));
    equal(0, arithmetic.subtract(1,1));
    equal(-1, arithmetic.subtract(1,2));
});