package com.lsh.springboot.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능테스트() {
        String name = "test";
        int amount = 10000;

        HelloResponseDto obj = new HelloResponseDto(name, amount);
        Assertions.assertThat(obj.getAmount()).isEqualTo(10000);
        Assertions.assertThat(obj.getName()).isEqualTo("test");
    }

}