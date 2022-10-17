package main

import (
	"fmt"
	"math/rand"
	"sort"
	"strconv"
	"sync"
)

var wg sync.WaitGroup

func remove(slice []Book, s int) []Book {
	return append(slice[:s], slice[s+1:]...)
}

type Book struct {
	name   string
	public bool
}

func randBool() bool {
	r := rand.Intn(1)
	if r == 1 {
		return true
	}

	return false
}
func newBook(name string, public bool) *Book {
	return &Book{name, public}
}

func (library *Library) initLibrary(count int) {
	for i := 0; i < count; i += 1 {
		book := *newBook("book"+strconv.Itoa(i), randBool())
		library.books = append(library.books, book)
	}
}

type Reader struct {
	name     string
	books    []Book
	position int //0 home; 1 read room
}

type Library struct {
	books []Book
	mutex sync.Mutex
}

func (library *Library) operation(reader *Reader) {

	operation := 0

	if reader.position == 1 {
		operation = 2
	} else {
		if len(reader.books) > 0 {
			fmt.Println("Reader %s put books to Library:", reader.name)
			fmt.Printf("book:")
			for i := range reader.books {
				fmt.Printf("%s, ", reader.books[i])
				library.books = append(library.books, reader.books[i])
				reader.books = remove(reader.books, i)
				sort.SliceStable(library.books[:], func(i, j int) bool {
					return library.books[i].name < library.books[j].name
				})
			}
			fmt.Printf("\n")
		}

		operation = rand.Intn(1)
	}

	switch operation {
	case 0: //read in reading room
		fmt.Printf("Reader %s get books from library and comming to read in reading room\n books: ", reader.name)
		countBook := rand.Intn(5)
		for i := 0; i < countBook; i += 1 {
			ri := rand.Intn(len(library.books))
			reader.books = append(reader.books, library.books[ri])
			library.books = remove(library.books, ri)

			fmt.Printf("%s, ", library.books[ri].name)
		}
		fmt.Printf("\n")

		reader.position = 1
	case 1:
		fmt.Printf("Reader %s get books from library and comming to read at home\n books: ", reader.name)
		countBook := rand.Intn(5)
		for i := 0; i < countBook; i += 1 {
			ri := rand.Intn(len(library.books))
			if library.books[ri].public == true {
				reader.books = append(reader.books, library.books[ri])
				library.books = remove(library.books, ri)
				fmt.Printf("%s, ", library.books[ri].name)
			}
		}
		fmt.Printf("\n")

		reader.position = 0
	case 2: //go out from read room
		fmt.Printf("Reader %s go out from read room and put books to Library\n books: ", reader.name)
		for i := 0; i < len(reader.books); i++ {
			if reader.books[i].public == false {
				fmt.Printf("%s, ", reader.books[i].name)
				library.books = append(library.books, reader.books[i])
				reader.books = remove(reader.books, i)
				i -= 1
			}
		}
		fmt.Printf("\n")

		sort.SliceStable(library.books[:], func(i, j int) bool {
			return library.books[i].name < library.books[j].name
		})
		if len(reader.books) > 0 {
			fmt.Println("Reader %s comming home to read", reader.name)
		}

		reader.position = 0
	}

	wg.Done()

}

func main() {
	readers := make([]Reader, 3)

	readers[0].name = "A"
	readers[1].name = "B"
	readers[2].name = "C"

	library := Library{}
	library.initLibrary(100)

	for i := 0; i < 100; i += 1 {
		library.mutex.Lock()
		wg.Add(1)
		go library.operation(&readers[i%3])
		wg.Wait()
		library.mutex.Unlock()
	}
}
