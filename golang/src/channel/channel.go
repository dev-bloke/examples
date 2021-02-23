package main

import (
	"fmt"
	"time"
)

func printIntegerFromChannel(channel chan int) {
	num := 0
	for num >= 0 {
		num = <-channel
		fmt.Print(num, " ")
	}
}

func main() {
	channel := make(chan int)
	a := []int{8, 6, 7, 5, 3, 0, 9, -1}
	go printIntegerFromChannel(channel)
	for _, value := range a {
		channel <- value
	}
	time.Sleep(time.Millisecond * 1)
	fmt.Println("...finished.")
}
