package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher ssr = new Publisher("SSR Publisher","Mannavanur","Kodaikanal" , "Tamilnadu" , "MNR");

        publisherRepository.save(ssr);
        Author logesh = new Author("logeshwaran" , "Rajagopal" );
        Book ps = new Book("Ponniyin selvan" , "PS-01");

        ps.setPublisher(ssr);
        logesh.getBooks().add(ps);
        ps.getAuthors().add(logesh);
//        ssr.getBooks().add(ps);


        authorRepository.save(logesh);
        bookRepository.save(ps);


        System.out.println(
                authorRepository.count() + " , " +
                bookRepository.count() + " , " +
                publisherRepository.count()
        );

    }
}
