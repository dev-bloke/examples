#[derive(Debug)]
enum WibblyWobbly {
    Wibble,
    Wobble
}

#[derive(Debug)]
enum IpAddress {
    V4(String),
    V6(String),
}

#[derive(Debug)]
enum Message {
    Move { x: i32, y: i32 },
    Write(String),
}

enum USCoin {
    Penny,
    Nickel,
    Dime,
    Quarter,
}

fn main() {
    simple_enum();
    ip_addresses();
    messages();
    us_coins();
}

fn simple_enum() {
    let wibbly = WibblyWobbly::Wibble;
    let wobbly = WibblyWobbly::Wobble;
    dbg!("wibbly={}, wobbly={}", wibbly, wobbly);
}

fn ip_addresses() {
    let home = IpAddress::V4(String::from("127.0.0.1"));
    let loopback = IpAddress::V6(String::from("::1"));
    dbg!("home={}, loopback={}.", home, loopback);
}

fn messages() {
    let write_message = Message::Write(String::from("hello"));
    let move_message = Message::Move{x: 10, y: 20};
    dbg!("write={}, move={}", write_message, move_message);
}

fn us_coins() {
    let quarter = USCoin::Quarter;
    let penny = USCoin::Penny;
    let quarter_value = value_in_cents(quarter);
    println!("A quarter is {quarter_value} cents.");
    let penny_value = value_in_cents(penny);
    println!("A penny is {penny_value} cent.");
}

fn value_in_cents(coin: USCoin) -> u8 {
    match coin {
        USCoin::Penny => {
            println!("Lucky penny!");
            1
        }
        USCoin::Nickel => 5,
        USCoin::Dime => 10,
        USCoin::Quarter => 25,
        other => 0,
    }
}