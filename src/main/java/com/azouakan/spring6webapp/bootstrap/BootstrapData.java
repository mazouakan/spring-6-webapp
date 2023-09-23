package com.azouakan.spring6webapp.bootstrap;

import com.azouakan.spring6webapp.domain.Author;
import com.azouakan.spring6webapp.domain.Book;
import com.azouakan.spring6webapp.domain.Publisher;
import com.azouakan.spring6webapp.repositories.AuthorRepository;
import com.azouakan.spring6webapp.repositories.BookRepository;
import com.azouakan.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("45678923");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Some Publisher Name");
        publisher.setState("Ile de France");
        publisher.setCity("Paris");
        publisher.setZip("75000");
        publisher.setAddress("42 boulevard Saint-Marcel");

        Publisher publisherSaved =  publisherRepository.save(publisher);

        Publisher antidata = new Publisher();
        antidata.setPublisherName("Antidata");
        antidata.setState("Ile de france");
        antidata.setCity("Paris");
        antidata.setZip("75000");
        antidata.setAddress("29 rue de l'Espérance");

        Publisher antidataSaved = publisherRepository.save(antidata);

        dddSaved.setPublisher(publisherSaved);
        noEJBSaved.setPublisher(antidataSaved);
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);


        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());


    }
}
