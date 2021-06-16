package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Book;
import alkemy.challenge.Challenge.Alkemy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<?> getBooks(){
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.BAD_REQUEST);
    }


    @GetMapping
    public ResponseEntity<?> createBook(@RequestBody Book book){
        return new ResponseEntity<>(bookRepository.save(book), HttpStatus.CREATED);
    }

    @GetMapping("/colletctorPrice/book/{id}")
    public ResponseEntity<?> getCollectorPrice (@PathVariable long id){

        Book book = bookRepository.findById(id).get();

        if(book.getEdition()<3 && book.getEdition() > 5 ){
            book.setPrice(book.getPrice()+ book.getPrice()/2);
        }

        return new ResponseEntity<>(book.getPrice(), HttpStatus.OK);
    }


}
