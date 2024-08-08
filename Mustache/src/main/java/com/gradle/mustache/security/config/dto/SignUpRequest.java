package com.gradle.mustache.security.config.dto;

import com.gradle.mustache.member.IMember;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest implements IMember {
    private Long id;
    private String name;
    private String loginId;
    private String password;
    private String email;
    private String role;
}
