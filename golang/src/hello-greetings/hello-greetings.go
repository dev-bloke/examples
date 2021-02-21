package main

import (
    "fmt"
	"log"
    "example.com/greetings"
)

func main() {
	setup()
	sayHello("Martin")
	sayHello("")
}

func setup() {
	log.SetPrefix("greetings: ")
    log.SetFlags(0)    
}

func sayHello(name string) {
    message, err := greetings.Hello(name)
    if err != nil {
    	log.Fatal(err)
    }
    fmt.Println(message)
}