package com.tobeto.a.spring.intro.auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private  String email;
    private  String password;

}
