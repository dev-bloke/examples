fn main() {
    unsigned_integer();
    signed_integer();
    floating_point();
    boolean();
    character();
    tuple();
    array();
}

// Scalar types

fn unsigned_integer() {
    let unsigned_int: u16 = 54321;
    println!("1. unsigned 16 bit integer u16: {unsigned_int}.")
}

fn signed_integer() {
    let signed_int: i16 = -12345;
    println!("2. signed 16 bit integer i16: {signed_int}.")
}

fn floating_point() {
    let floating: f64 = 1.2345678;
    println!("3. Floating point f64: {floating}.")
}

fn boolean() {
    let boolean: bool = true;
    println!("4. Boolean bool: {boolean}");
}

fn character() {
    let character: char = 'Z';
    println!("5. Character char: {character}");
}

fn tuple() {
    let tup: (i32, f64, u8) = (500, 6.4, 1);
    let (x, y, z) = tup;
    println!("x = {x}, y = {y}, z = {z}.");
}

fn array() {
    let months = ["January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December"];
    println!("Month 3 = {}, Month 12 = {}", months[2], months[11]);
}

