package com.divae.sk.sbsk.author;

public class AuthorNotFoundException extends RuntimeException {

    AuthorNotFoundException(String msg) {
        super(msg);
    }
}
