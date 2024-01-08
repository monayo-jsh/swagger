package com.example.demo.member.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

@Schema(title = "회원 수정 스키마")
public class MemberPutReqeust {

    @Schema(title = "회원 이름", description = "회원 이름", requiredMode = RequiredMode.REQUIRED)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
