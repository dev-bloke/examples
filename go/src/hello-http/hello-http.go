package main

import (
	"fmt"
	"net/http"
)

func main() {
	http.HandleFunc("/hello", hello)
	http.HandleFunc("/headers", headers)
	http.ListenAndServe(":8080", nil)
}

func hello(writer http.ResponseWriter, request *http.Request) {
	fmt.Fprintf(writer, "<h1>Hello World</h1>\n")
	fmt.Fprintf(writer, "<p>This page was served by Go hello-http.</p>")
}

func headers(writer http.ResponseWriter, request *http.Request) {
	fmt.Fprintf(writer, "<h1>HTTP Headers</h1>")
	fmt.Fprintf(writer, "<ul>")
	for name, headers := range request.Header {
		for _, value := range headers {
			fmt.Fprintf(writer, "<li>%v: %v</li>\n", name, value)
		}
	}
	fmt.Fprintf(writer, "</ul>")
}
