package com.footstep.domain.posting.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditPostingDto {

    @ApiModelProperty(value = "발자취 제목", required = true, example = "고양이")
    private String title;
    @ApiModelProperty(value = "발자취 내용", required = true, example = "귀여운 고양이")
    private String content;
    @ApiModelProperty(value = "발자취 게시일", required = true, example = "2023-01-23")
    private Date recordDate;
    private CreatePlaceDto createPlaceDto;
    @ApiModelProperty(notes = "발자취 사진", example = "http://news.samsungdisplay.com/wp-content/uploads/2018/08/1.png")
    private String imageUrl;
    @ApiModelProperty(value = "발자취 공개 여부", required = true, example = "1")
    private int visibilityStatusCode;
}
