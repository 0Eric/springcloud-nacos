package com.demo.third.device.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.third.device.dto.DsTrafficWarningDto;
import com.demo.third.device.entity.DsTrafficWarningEntity;
import com.demo.third.device.vo.DsTrafficWarningVo;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangsh
 * @email 1057718341@qq.com
 */
@Api(tags = "")
@Mapper
@Repository
public interface DsTrafficWarningDao extends BaseMapper<DsTrafficWarningEntity> {

    /**
     * 分页查询结果
     *
     * @param dsVehicleEvent
     * @return
     */
    List<DsTrafficWarningDto> getPage(DsTrafficWarningVo dsVehicleEvent);

    /**
     * 查询总数
     *
     * @param dsVehicleEvent
     * @return
     */
    Long getCount(DsTrafficWarningVo dsVehicleEvent);

    /**
     * 查询结果
     *
     * @param dsVehicleEvent
     * @return
     */
    List<DsTrafficWarningDto> find(DsTrafficWarningVo dsVehicleEvent);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    DsTrafficWarningDto getById(@Param("id") Long id);

    int updateByRoadSectionId(DsTrafficWarningEntity entity);


}
