package com.example.socialmedia.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {

    private String field;
    private String source;
    private Object object;

    public UserNotFoundException(String field, String source, Object object) {
        super(String.format("%s not found with %s : %s", field, source, object));
        this.field = field;
        this.source = source;
        this.object = object;
    }
}