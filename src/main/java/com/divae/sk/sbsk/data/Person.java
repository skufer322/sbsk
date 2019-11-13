package com.divae.sk.sbsk.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Person {

    // @formatter:off
    private String firstName;
    private String lastName;
    // @formatter:on
}
