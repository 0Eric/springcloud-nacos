package com.demo.third.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.third.device.dto.DsTrafficWarningDto;
import com.demo.third.device.entity.DsTrafficWarningEntity;
import com.demo.third.device.vo.DsTrafficWarningVo;
import com.goo.commons.tools.page.PageData;

import java.util.List;

/**
 * @author wangsh
 * @email 1057718341@qq.com
 */
public interface DsTrafficWarningService extends IService<DsTrafficWarningEntity> {

    /**
     * 分页查询
     *
     * @param paramsVo
     * @return
     */
    PageData queryPage(DsTrafficWarningVo paramsVo);

    /**
     * 查询结果
     *
     * @param paramsVo
     * @return
     */
    List<DsTrafficWarningDto> find(DsTrafficWarningVo paramsVo);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    DsTrafficWarningDto getById(Long id);

    /**
     * 保存
     *
     * @param dsVehicleEvent
     * @return
     */
    void saveUpdate(DsTrafficWarningEntity dsVehicleEvent);

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    void delete(List<Long> ids);

    /**
     * 保存事件处理
     * 拥堵等级(1-严重；2-轻微；3-畅通)
     *
     * @return
     */
    void update(Long roadSectionId, int evenType);


}

