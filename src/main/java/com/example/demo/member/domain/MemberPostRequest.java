package com.example.demo.member.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

@Schema(title = "회원 요청 스키마")
public class MemberPostRequest {

    @Schema(title = "이름", description = "회원 이름", example = "홍길동", requiredMode = RequiredMode.REQUIRED)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
