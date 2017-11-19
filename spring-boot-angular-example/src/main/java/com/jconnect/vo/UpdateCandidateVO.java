package com.jconnect.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCandidateVO {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
