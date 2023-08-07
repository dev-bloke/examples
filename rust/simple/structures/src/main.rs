struct User {
    active: bool,
    username: String,
    email: String,
    sign_in_count: u64,
}

struct Point(i32, i32, i32);

#[derive(Debug)]
struct Rectangle {
    width: u32,
    height: u32,
}

// These methods could be in seperate impl blocks.

impl Rectangle {
    fn area(&self) -> u32 {
        self.width * self.height
    }

    fn can_hold(&self, other: &Rectangle) -> bool {
        self.width > other.width && self.height > other.height
    }
    fn square(size: u32) -> Self {
        Self {
            width: size,
            height: size,
        }
    }
}

fn main() {
    let name = String::from("A User");
    let email = String::from("address@example.com");
    let mut user1 = create_user(email, name);
    user1.email = String::from("another@example.com");
    println!("email = {}", user1.email);
    let other_name = String::from("Anne Otheruser");
    let user2 = clone_user(user1, other_name);
    println!("email = {}, username = {}", user2.email, user2.username);
    tuple_struct();
    derived_trait();
    rectangle_method();
    rectangle_can_hold();
    square_constructor();
}

fn create_user(email: String, username: String) -> User {
    User {
        active: true,
        username,
        email,
        sign_in_count: 1,
    }
}

fn clone_user(user: User, name: String) -> User {
    User {
        username: name,
        ..user
    }
}

fn tuple_struct() {
    let point = Point(0,1,0);
    println!("x={}, y={}, z={}", point.0, point.1, point.2);
}

fn derived_trait() {
    let rectangle = Rectangle {
        width: 30,
        height: 50,
    };
    dbg!(&rectangle);
}

fn rectangle_method() {
    let rectangle = Rectangle {
        width: 30,
        height: 50,
    };
    println!("The area of the rectangle is {}.", rectangle.area());
}

fn rectangle_can_hold() {
    let rectangle_1 = Rectangle {
        width: 30,
        height: 50,
    };
    let rectangle_2 = Rectangle {
        width: 10,
        height: 40,
    };
    let rectangle_3 = Rectangle {
        width: 60,
        height: 45,
    };
    println!("Can rectangle 1 hold rectangle 2? {}", rectangle_1.can_hold(&rectangle_2));
    println!("Can rectangle 1 hold rectangle 3? {}", rectangle_1.can_hold(&rectangle_3));
}

fn square_constructor() {
    let square = Rectangle::square(10);
    dbg!(&square);
}