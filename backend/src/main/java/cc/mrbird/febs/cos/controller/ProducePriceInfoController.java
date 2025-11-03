package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.ProducePriceInfo;
import cc.mrbird.febs.cos.service.IProducePriceInfoService;
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
@RequestMapping("/cos/produce-price-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducePriceInfoController {

    private final IProducePriceInfoService producePriceInfoService;

    /**
     * 分页查询产品价格
     *
     * @param page             分页对象
     * @param producePriceInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<ProducePriceInfo> page, ProducePriceInfo producePriceInfo) {
        return R.ok();
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(producePriceInfoService.list());
    }

    /**
     * 新增产品价格
     *
     * @param producePriceInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(ProducePriceInfo producePriceInfo) {
        producePriceInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(producePriceInfoService.save(producePriceInfo));
    }

    /**
     * 修改产品价格
     *
     * @param producePriceInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(ProducePriceInfo producePriceInfo) {
        return R.ok(producePriceInfoService.updateById(producePriceInfo));
    }

    /**
     * 删除产品价格
     *
     * @param ids 主键ID
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(producePriceInfoService.removeByIds(ids));
    }
}
