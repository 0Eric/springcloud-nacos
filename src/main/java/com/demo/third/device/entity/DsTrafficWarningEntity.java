package com.demo.third.device.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 交通告警
 *
 * @author wangsh
 * @email 1057718341@qq.com
 * @date 2021-02-22 10:48:38
 */
@ApiModel(value = "ds_traffic_warning 交通告警")
@TableName("ds_traffic_warning")
public class DsTrafficWarningEntity implements Serializable {

    /**
     * 主键id
     */
    @TableId
    @ApiModelProperty(value = "", name = "id", dataType = "Long")
    private Long id;
    /**
     * 道路id
     */
    @ApiModelProperty(value = "道路id", name = "roadCodeId", dataType = "Long")
    private Long roadCodeId;
    /**
     * 道路分段id
     */
    @ApiModelProperty(value = "道路分段id", name = "roadSectionId", dataType = "Long")
    private Long roadSectionId;
    /**
     * 拥堵等级(1-严重；2-轻微；3-畅通)
     */
    @ApiModelProperty(value = "拥堵等级(1-严重；2-轻微；3-畅通)", name = "level", dataType = "Integer")
    private Integer level;
    /**
     * 设备类型(1-信标；2-雷达；3-相机；99-其他)
     */
    @ApiModelProperty(value = "设备类型(1-信标；2-雷达；3-相机；99-其他)", name = "deviceType", dataType = "Integer")
    private Integer deviceType;
    /**
     * 事件类型(0-未知 1-事故 2-逆行或倒车 3-超速) 4-拥堵 5-缓行 6-停车 7-变道 8-跟车太近)
     */
    @ApiModelProperty(value = "事件类型(0-未知 1-事故 2-逆行或倒车 3-超速) 4-拥堵 5-缓行 6-停车 7-变道 8-跟车太近)", name = "eventType", dataType = "Integer")
    private Integer eventType;
    /**
     * 拥堵车辆
     */
    @ApiModelProperty(value = "拥堵车辆", name = "vehicleIds", dataType = "String")
    private String vehicleIds;
    /**
     * 产生事件开始计算设备deveui
     */
    @ApiModelProperty(value = "产生事件开始计算设备deveui", name = "deveui", dataType = "String")
    private String deveui;
    /**
     * 拥堵事件数据量
     */
    @ApiModelProperty(value = "拥堵事件数据量", name = "eventNum", dataType = "Integer")
    private Integer eventNum;
    /**
     * 闪灯设备devEUI,多个以逗号分隔
     */
    @ApiModelProperty(value = "闪灯设备devEUI,多个以逗号分隔", name = "devList", dataType = "String")
    private String devList;
    /**
     * 拥堵范围
     */
    @ApiModelProperty(value = "拥堵范围", name = "lightRange", dataType = "Integer")
    private Integer lightRange;
    /**
     * 拥堵状态(1-拥堵；2-不拥堵)
     */
    @ApiModelProperty(value = "拥堵状态(1-拥堵；2-不拥堵)", name = "status", dataType = "Integer")
    private Integer status;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", name = "startTime", dataType = "Date")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", name = "endTime", dataType = "Date")
    private Date endTime;

    /**
     *
     */
    @ApiModelProperty(value = "", name = "remark", dataType = "String")
    private String remark;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", name = "creator", dataType = "Long")
    private Long creator;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createDate", dataType = "Date")
    private Date createDate;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者", name = "updater", dataType = "Long")
    private Long updater;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", name = "updateDate", dataType = "Date")
    private Date updateDate;


    public String getDeveui() {
        return deveui;
    }

    public void setDeveui(String deveui) {
        this.deveui = deveui;
    }

    public Integer getEventNum() {
        return eventNum;
    }

    public void setEventNum(Integer eventNum) {
        this.eventNum = eventNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoadCodeId() {
        return roadCodeId;
    }

    public void setRoadCodeId(Long roadCodeId) {
        this.roadCodeId = roadCodeId;
    }

    public Long getRoadSectionId() {
        return roadSectionId;
    }

    public void setRoadSectionId(Long roadSectionId) {
        this.roadSectionId = roadSectionId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public String getVehicleIds() {
        return vehicleIds;
    }

    public void setVehicleIds(String vehicleIds) {
        this.vehicleIds = vehicleIds;
    }

    public String getDevList() {
        return devList;
    }

    public void setDevList(String devList) {
        this.devList = devList;
    }

    public Integer getLightRange() {
        return lightRange;
    }

    public void setLightRange(Integer lightRange) {
        this.lightRange = lightRange;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
