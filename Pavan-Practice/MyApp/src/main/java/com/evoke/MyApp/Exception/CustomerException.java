package com.evoke.MyApp.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerException {
    private int status;
    private String message;
    private Long timestamp;

}
