package com.example.demo.member.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.Random;

@Schema(title = "회원 스키마(title)", description = "회원 스키마(description)")
public class MemberResponse {

    @Schema(title= "아이디", description = "회원 고유 아이디", example = "123", requiredMode = RequiredMode.REQUIRED)
    private Long id;

    @Schema(title= "이름", description = "회원 이름", example = "홍길동", requiredMode = RequiredMode.REQUIRED)
    private String name;

    public static MemberResponse of(Long id) {
        MemberResponse member = new MemberResponse();
        member.setId(id);
        member.setName("name-" + id);
        return member;
    }

    public static MemberResponse of(Long id, String name) {
        MemberResponse member = new MemberResponse();
        member.setId(id);
        member.setName("name-" + name);
        return member;
    }

    public static MemberResponse ofName(String name) {
        MemberResponse member = new MemberResponse();
        member.setId(new Random().nextLong(100));
        member.setName("name-" + name);
        return member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
