package main

import (
	"fmt"
	"log"

	"example.com/greetings"
)

func init() {
	log.SetPrefix("greetings: ")
	log.SetFlags(0)
}

func main() {
	sayHello("Martin")
	sayHello("")
}

func sayHello(name string) {
	message, error := greetings.Hello(name)
	if error != nil {
		log.Fatal(error)
	}
	fmt.Println(message)
}
