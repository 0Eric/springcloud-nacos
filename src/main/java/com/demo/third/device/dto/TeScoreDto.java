package com.demo.third.device.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "学科成绩")
@Data
public class TeScoreDto {

    @ApiModelProperty(value = "学科代码", name = "cid", dataType = "String")
    private String cid;
    @ApiModelProperty(value = "学科名称", name = "cname", dataType = "String")
    private String cname;
    @ApiModelProperty(value = "学科成绩", name = "score", dataType = "String")
    private String score;

}
