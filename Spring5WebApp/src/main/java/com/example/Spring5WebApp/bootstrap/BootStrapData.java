package com.example.Spring5WebApp.bootstrap;

import com.example.Spring5WebApp.Repositories.AuthorRepository;
import com.example.Spring5WebApp.Repositories.BookRepository;
import com.example.Spring5WebApp.Repositories.PublisherRepository;
import com.example.Spring5WebApp.domain.Author;
import com.example.Spring5WebApp.domain.Book;
import com.example.Spring5WebApp.domain.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.init.RepositoriesPopulatedEvent;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private  final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
       this.publisherRepository =publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","evans");
        Book ddd = new Book("Domain Driver Design","1212121");
        Publisher p1 = new Publisher("Oreilly","USA");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(p1);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Devlopment without EJB","3242343");
        Publisher p2 = new Publisher("Packt","India");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(p2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books :" + bookRepository.count());
        System.out.println("Number of Publishers : " + publisherRepository.count());

    }
}
