package com.bzzzzz.farm.domain.review.dto.reviewanswer;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class ReviewAnswerDeleteDto {
    @Positive
    private Long reviewAnswerId;
}
