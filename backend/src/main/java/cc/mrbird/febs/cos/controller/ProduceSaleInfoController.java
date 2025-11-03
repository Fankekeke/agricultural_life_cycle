package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.ProduceSaleInfo;
import cc.mrbird.febs.cos.service.IProduceSaleInfoService;
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
@RequestMapping("/cos/produce-sale-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProduceSaleInfoController {

    private final IProduceSaleInfoService produceSaleInfoService;

    /**
     * 分页查询产品售卖
     *
     * @param page            分页对象
     * @param produceSaleInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<ProduceSaleInfo> page, ProduceSaleInfo produceSaleInfo) {
        return R.ok();
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(produceSaleInfoService.list());
    }

    /**
     * 新增产品售卖
     *
     * @param produceSaleInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(ProduceSaleInfo produceSaleInfo) {
        produceSaleInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(produceSaleInfoService.save(produceSaleInfo));
    }

    /**
     * 修改产品售卖
     *
     * @param produceSaleInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(ProduceSaleInfo produceSaleInfo) {
        return R.ok(produceSaleInfoService.updateById(produceSaleInfo));
    }

    /**
     * 删除产品售卖
     *
     * @param ids 主键ID
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(produceSaleInfoService.removeByIds(ids));
    }
}
