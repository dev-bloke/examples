fn main() {
    simple_options();
    if_let();
}

fn simple_options() {
    let number = Some(5);
    let character = Some('e');
    let no_number: Option<i32> = None;
    let sum_number = 5 + number.unwrap_or_else(|| 0);
    let sum_no_number = 5 + no_number.unwrap_or_else(|| 0);
    dbg!(character.unwrap(), sum_number, sum_no_number);
}

fn if_let() {
    let config_max = Some(3u8);
    if let Some(max) = config_max {
        println!("The maximum is configured to be {}", max);
    }
}
