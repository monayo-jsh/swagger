package com.example.demo.member.controller;

import com.example.demo.member.domain.MemberPostRequest;
import com.example.demo.member.domain.MemberPutReqeust;
import com.example.demo.member.domain.MemberResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/members")
@Tag(name="회원 관리", description = "회원 관리 API 제공")
public class MemberController {

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "멤버 목록 조회",
        description = "멤버 목록 조회"
    )
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200",
                description = "성공",
                content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = MemberResponse.class)))
                }
            )
        }
    )
    public ResponseEntity<List<MemberResponse>> getMembers() {
        return ResponseEntity.ok()
                             .body(List.of(MemberResponse.of(1L),
                                           MemberResponse.of(2L),
                                           MemberResponse.of(3L)));
    }

    @GetMapping(value = "{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "멤버 상세 조회 (summary)",
        description = "멤버 상세 조회 (description)"
    )
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200",
                description = "성공",
                content = {
                    @Content(schema = @Schema(implementation = MemberResponse.class))
                }),
            @ApiResponse(responseCode = "404", description = "회원 정보 없음")
        }
    )
    public ResponseEntity<MemberResponse> getMember(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok()
                             .body(MemberResponse.of(memberId));
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "멤버 등록",
        description = "멤버 등록"
    )
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "201",
                description = "성공",
                content = {
                    @Content(schema = @Schema(implementation = MemberResponse.class))
                }
            )
        }
    )
    public ResponseEntity<MemberResponse> postMember(@RequestBody MemberPostRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(MemberResponse.ofName(request.getName()));
    }

    @PutMapping(value = "{memberId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "멤버 수정",
        description = "멤버 수정"
    )
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200",
                description = "성공",
                content = {
                    @Content(schema = @Schema(implementation = MemberResponse.class))
                }
            )
        }
    )
    public ResponseEntity<MemberResponse> putMember(@PathVariable("memberId") Long memberId, @RequestBody MemberPutReqeust request) {
        return ResponseEntity.ok()
                             .body(MemberResponse.of(memberId, request.getName()));
    }

    @DeleteMapping(value = "{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "멤버 삭제",
        description = "멤버 삭제"
    )
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200",
                description = "성공"
            )
        }
    )
    public ResponseEntity<?> deleteMember(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok()
                             .build();
    }
}
