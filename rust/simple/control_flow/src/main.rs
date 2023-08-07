fn main() {
    conditional(4);
    ternary(-20);
    looping(10);
    labeled_loop(2);
    while_loop(4);
    for_loop();
    reverse_for_loop();
}

fn conditional(input: i32) {
    let number = 3;
    if number == input { // Note that the compiler bleats about brackets!
        println!("The numbers are the same.");
    } else {
        println!("The numbers are different.");
    }
}

fn ternary(number: i32) {
    let result= if number < 0 { 'Y' } else { 'N' };
    println!("Number is negative = {result}");
}

fn looping(stop: i32) {
    let mut counter = 0;
    loop {
        counter += 1;
        println!("{counter}");
        if counter == stop {
            break;
        }
    }
}

fn labeled_loop(stop: i32) {
    let mut counter = 0;
    'outer: loop {
        counter += 1;
        println!("{counter}");
        if counter == stop {
            break 'outer;
        }
    }
}

fn while_loop(stop: i32) {
    let mut counter = 0;
    while counter < stop {
        counter += 1;
        println!("{counter}");
    }
}

fn for_loop() {
    let array = ['a', 'b', 'c', 'd', 'e'];
    for character in array {
        println!("{character}");
    }
}

fn reverse_for_loop() {
    for number in (1..4).rev()  {
        println!("{number}");
    }
}