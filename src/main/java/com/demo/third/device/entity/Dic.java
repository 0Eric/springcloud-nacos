package com.demo.third.device.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "字典表")
@TableName("dic")
public class Dic {

    /**
     * 主键id
     */
    @TableId
    @ApiModelProperty(value = "主键", name = "id", dataType = "INTEGER")
    private String id;
    @ApiModelProperty(value = "代码", name = "code", dataType = "String")
    private String code;
    @ApiModelProperty(value = "名称", name = "name", dataType = "String")
    private String name;
    @ApiModelProperty(value = "类型", name = "type", dataType = "String")
    private String type;
    @ApiModelProperty(value = "备注", name = "remark", dataType = "String")
    private String remark;


}
