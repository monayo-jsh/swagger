package com.example.demo.basket.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/basket")
@Tag(name = "장바구니 관리", description = "장바구니 관리 API 제공")
public class BasketController {

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "장바구니 목록 조회",
        description = "장바구니 목록 조회"
    )
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200",
                description = "성공"
            )
        }
    )
    public ResponseEntity<List<?>> getBasket() {
        return ResponseEntity.ok()
                             .build();
    }

}
