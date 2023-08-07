fn main() {
    let phrase = "Hello world!";
    let word = first_word(phrase);
    println!("The first word is {word}.");
    slice_array();
}

fn first_word(phrase: &str) -> &str {
    let bytes = phrase.as_bytes();
    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &phrase[0..i];
        }
    }
    &phrase[..]
}

fn slice_array() {
    let array = [1, 2, 3, 4, 5];
    let slice = &array[1..3];
    assert_eq!(slice, &[2, 3]);
}
