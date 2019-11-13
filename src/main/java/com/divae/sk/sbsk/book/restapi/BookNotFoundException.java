package com.divae.sk.sbsk.book.restapi;

public class BookNotFoundException extends RuntimeException {

    BookNotFoundException(String msg) {
        super(msg);
    }
}
