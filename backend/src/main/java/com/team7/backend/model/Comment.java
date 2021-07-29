package com.team7.backend.model;

import com.google.api.client.util.Value;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
public class Comment {

    @ApiModelProperty(notes = "ID")
    private int id;

    @ApiModelProperty(notes = "Username who commented")
    private String username;

    @ApiModelProperty(notes = "ID of the commented picture")
    private String pictureId;

    @ApiModelProperty(notes = "Comment")
    private String comment;
}
