package com.demo.third.device.controller;

import com.demo.third.device.dto.DsTrafficWarningDto;
import com.demo.third.device.entity.DsTrafficWarningEntity;
import com.demo.third.device.vo.DsTrafficWarningVo;
import com.goo.commons.tools.page.PageData;
import com.goo.commons.tools.utils.Result;
import com.demo.third.device.service.DsTrafficWarningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author wangsh
 * @email 1057718341@qq.com
 * @date 2021-08-29 10:48:38
 */
@Api(tags = "")
@RestController
@RequestMapping("/dsTrafficWarning")
public class DsTrafficWarningController {
    @Autowired
    private DsTrafficWarningService dsTrafficWarningService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    public Result list(DsTrafficWarningVo paramsVo) {
        PageData page = dsTrafficWarningService.queryPage(paramsVo);
        return new Result().ok(page);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/find")
    public Result find(DsTrafficWarningVo paramsVo) {
        List<DsTrafficWarningDto> list = dsTrafficWarningService.find(paramsVo);
        return new Result().ok(list);
    }

    /**
     * 查看详细信息
     */
    @ApiOperation(value = "查看详细信息")
    @GetMapping("/getById")
    public Result getById(@RequestParam("id") Long id) {
        DsTrafficWarningDto dsVehicleEvent = dsTrafficWarningService.getById(id);
        return new Result().ok(dsVehicleEvent);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping
    public Result save(@RequestBody DsTrafficWarningEntity dsVehicleEvent) {
        dsTrafficWarningService.saveUpdate(dsVehicleEvent);
        return new Result();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改")
    @PutMapping
    public Result update(@RequestBody DsTrafficWarningEntity dsVehicleEvent) {
        dsTrafficWarningService.saveUpdate(dsVehicleEvent);
        return new Result();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping
    public Result delete(@RequestBody Long[] ids) {
        dsTrafficWarningService.delete(Arrays.asList(ids));
        return new Result();
    }

}
