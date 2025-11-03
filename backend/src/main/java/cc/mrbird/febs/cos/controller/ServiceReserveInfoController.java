package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.ServiceReserveInfo;
import cc.mrbird.febs.cos.service.IServiceReserveInfoService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/service-reserve-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServiceReserveInfoController {

    private final IServiceReserveInfoService serviceReserveInfoService;

    /**
     * 分页查询产品订单
     *
     * @param page               分页对象
     * @param serviceReserveInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<ServiceReserveInfo> page, ServiceReserveInfo serviceReserveInfo) {
        return R.ok();
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(serviceReserveInfoService.list());
    }

    /**
     * 新增产品订单
     *
     * @param serviceReserveInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(ServiceReserveInfo serviceReserveInfo) {
        serviceReserveInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(serviceReserveInfoService.save(serviceReserveInfo));
    }

    /**
     * 修改产品订单
     *
     * @param serviceReserveInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(ServiceReserveInfo serviceReserveInfo) {
        return R.ok(serviceReserveInfoService.updateById(serviceReserveInfo));
    }

    /**
     * 删除产品订单
     *
     * @param ids 主键ID
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(serviceReserveInfoService.removeByIds(ids));
    }
}
