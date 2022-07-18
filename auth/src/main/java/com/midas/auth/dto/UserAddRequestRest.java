package com.midas.auth.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class UserAddRequestRest {

    private String name;
    private String mobileNumber;
    private String email;
    private String password;
}
