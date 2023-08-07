fn main() {
    borrowing();
    ownership();
}

fn borrowing() {
    let first = String::from("Hello");
    // You can't do this, it dereferences "first"...
    // let second = first;
    let second = first.clone();
    println!("First string = {first}, second string = {second}");
    // but you can do this with scalar types.
    let third = 3;
    let fourth = third;
    println!("First integer = {third}, second integer = {fourth}");
}

fn ownership() {
    let word = String::from("Word!");
    take_ownership(word);
    // You can't do this! The other function now "owns" word.
    // println!("I've still got {word}");

}

fn take_ownership(string: String) {
    println!("I've got {string}");
}
