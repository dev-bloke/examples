package main

import (
	"flag"
	"fmt"
)

var help bool
var name = flag.String("name", "World", "The name of the person you want to greet.")
var spanish bool

func init() {
	flag.BoolVar(&help, "help", false, "Displays this help.")
	flag.BoolVar(&help, "h", false, "Displays this help.")
	flag.BoolVar(&spanish, "spanish", false, "Greet the person in Spanish")
	flag.BoolVar(&spanish, "s", false, "Greet the person in Spanish")
}

func getGreeting() string {
	if spanish {
		return "Hola"
	}
	return "Hello"
}

func main() {
	flag.Parse()
	if help {
		flag.PrintDefaults()
	} else {
		fmt.Printf("%s %s\n", getGreeting(), *name)
	}
}
