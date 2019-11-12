package com.divae.sk.sbsk.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Person {

    private String firstName;
    private String lastName;
}
