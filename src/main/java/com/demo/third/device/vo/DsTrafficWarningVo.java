package com.demo.third.device.vo;

import com.goo.commons.tools.page.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 交通预警
 *
 * @author wangsh
 * @email 1057718341@qq.com
 * @date 2021-02-22 10:48:38
 */
@ApiModel(value = "交通预警 ds_vehicle_event")
public class DsTrafficWarningVo extends BaseDomain implements Serializable {

    /**
     *
     */
    @ApiModelProperty(value = "", name = "id", dataType = "Long")
    private Long id;
//    /**
//     * 道路id
//     */
//    @ApiModelProperty(value = "道路id", name = "roadCodeId", dataType = "Long")
//    private Long roadCodeId;
//    /**
//     * 道路分段id
//     */
//    @ApiModelProperty(value = "道路分段id", name = "roadSectionId", dataType = "Long")
//    private Long roadSectionId;
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
    @ApiModelProperty(value = "开始时间", name = "beginTime", dataType = "Date")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", name = "endTime", dataType = "Date")
    private Date endTime;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
