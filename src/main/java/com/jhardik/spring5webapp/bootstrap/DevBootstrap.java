package com.jhardik.spring5webapp.bootstrap;

import com.jhardik.spring5webapp.model.Author;
import com.jhardik.spring5webapp.model.Book;
import com.jhardik.spring5webapp.model.Publisher;
import com.jhardik.spring5webapp.repositories.AuthorRepository;
import com.jhardik.spring5webapp.repositories.BookRepository;
import com.jhardik.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData() {
        Author chetan = new Author("Chetan", "Bhagat");
        Publisher navneet = new Publisher("Navneet", "Ahmedabad");
        Book halfGirlfriend = new Book("Half Girlfriend", "1234", navneet);
        chetan.getBooks().add(halfGirlfriend);
        halfGirlfriend.getAuthors().add(chetan);

        authorRepository.save(chetan);
        publisherRepository.save(navneet);
        bookRepository.save(halfGirlfriend);

        Author tushar = new Author("Tushar", "Raheja");
        Publisher vikas = new Publisher("Vikas", "Bangalore");
        Book anythingForYouMaam = new Book("Anything for you Ma`am", "2345", vikas);
        tushar.getBooks().add(anythingForYouMaam);

        authorRepository.save(tushar);
        publisherRepository.save(vikas);
        bookRepository.save(anythingForYouMaam);
    }
}
