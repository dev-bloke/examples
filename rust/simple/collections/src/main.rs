fn main() {
    vectors();
    strings();
}

fn vectors() {
    let mut vector1 = Vec::new();
    let mut vector2 = vec![1, 2, 3];
    vector1.push(1);
    vector1.push(2);
    vector2.push(4);
    vector2.push(5);
    let third1 = vector1.get(2);
    match third1 {
        Some(third1) => println!("The third element of vector 1 is {third1}"),
        None => println!("There is no third element in vector 1."),
    }
    let third2 = vector2[2];
    println!("The third element of vector 2 is {third2}");
    // Note that dbg takes ownership here!
    dbg!(vector1);
    dbg!(vector2);
}

fn strings() {
    let data = "Some words here";
    let mut string = String::new();
    string = data.to_string();
    string = "Some other words".to_string();
    string = String::from("Yet some more words");
    string.push_str(" here.");
    println!("{string}");
}