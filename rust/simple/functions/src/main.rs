fn main() {
    another();
    no_return_value(5);
    two_parameters(10,'h');
    let value = 10;
    let five_added = add_five(value);
    println!("   Adding five to {value} gives {five_added}.");
    let six_added = add_six(value);
    println!("   Adding six to {value} gives {six_added}.");
    let word = String::from("word");
    let (result, size) = multiple_return_values(word); // Note that the function owns word now.
    println!("{} is {} characters long.", result, size);
    let another_word: String = String::from("word!");
    pass_by_reference(&another_word); // No ownership transfer.
    println!("I've still got {another_word}");
}

fn another() {
    println!("1. A simple function.");
}

fn no_return_value(integer: i32) {
    println!("2. Parameter but no return value.");
    println!("   The parameter passed was {integer}.")
}

fn two_parameters(integer: i32, units: char) {
    println!("3. Two parameters but no return value.");
    println!("   The measurement was {integer}{units}.")   
}

fn add_five(integer: i32) -> i32 {
    println!("4. Parameter and return value.");
    integer + 5
}

fn add_six(integer: i32) -> i32 {
    println!("5. Parameter and return with return statement.");
    return integer + 6;
}

fn multiple_return_values(string: String) -> (String, usize) {
    let result_string = String::from(string) + " extended";
    let result_size = result_string.len();
    (result_string, result_size)
}

fn pass_by_reference(string: &String) {
    println!("I've got {string}");
}
