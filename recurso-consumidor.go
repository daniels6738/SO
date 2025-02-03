package main

import (
	"fmt"
	"sync"
	"time"
)

var recurso1, recurso2 sync.Mutex

func consumidor(id int) {
	for {
		fmt.Printf("Thread %d tentando acessar recurso 1\n", id)
		
		recurso1.Lock()
		
		fmt.Printf("Thread %d acessando o recurso 1\n", id)
		
		time.Sleep(3 * time.Second)
		
		recurso1.Unlock()
		
		fmt.Printf("Thread %d liberando recurso 1\n", id)
		
		

		fmt.Printf("Thread %d tentando acessar recurso 2\n", id)
		
		recurso2.Lock()
		
		fmt.Printf("Thread %d acessando o recurso 2\n", id)
		
		time.Sleep(3 * time.Second)
		
		recurso2.Unlock()
		
		fmt.Printf("Thread %d liberando recurso 2\n", id)

	}
}

func main() {
	for i := 1; i <= 5; i++ {
		go consumidor(i)
	}

	time.Sleep(20 * time.Second)
}