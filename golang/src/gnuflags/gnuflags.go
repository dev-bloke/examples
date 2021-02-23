package main

import (
	"fmt"

	"launchpad.net/gnuflag"
)

var help bool
var name = gnuflag.String("name", "World", "The name of the person you want to greet.")
var spanish bool

func init() {
	gnuflag.BoolVar(&help, "help", false, "Displays this help.")
	gnuflag.BoolVar(&help, "h", false, "Displays this help.")
	gnuflag.BoolVar(&spanish, "spanish", false, "Greet the person in Spanish")
	gnuflag.BoolVar(&spanish, "s", false, "Greet the person in Spanish")
}

func getGreeting() string {
	if spanish {
		return "Hola"
	}
	return "Hello"
}

func main() {
	gnuflag.Parse(true)
	if help {
		gnuflag.PrintDefaults()
	} else {
		fmt.Printf("%s %s\n", getGreeting(), *name)
	}
}
