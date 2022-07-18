package com.midas.auth.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserUpdatePasswordRequestRest {
    @NotNull
    private String email;
    @NotNull
    private String oldPassword;
    @NotNull
    private String newPassword;
}
