package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.CycleRecord;
import cc.mrbird.febs.cos.service.ICycleRecordService;
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
@RequestMapping("/cos/cycle-record")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CycleRecordController {

    private final ICycleRecordService cycleRecordService;

    /**
     * 分页查询产品周期详情
     *
     * @param page        分页对象
     * @param cycleRecord 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<CycleRecord> page, CycleRecord cycleRecord) {
        return R.ok();
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(cycleRecordService.list());
    }

    /**
     * 新增产品周期详情
     *
     * @param cycleRecord 参数
     * @return 结果
     */
    @PostMapping
    public R save(CycleRecord cycleRecord) {
        cycleRecord.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(cycleRecordService.save(cycleRecord));
    }

    /**
     * 修改产品周期详情
     *
     * @param cycleRecord 参数
     * @return 结果
     */
    @PutMapping
    public R edit(CycleRecord cycleRecord) {
        return R.ok(cycleRecordService.updateById(cycleRecord));
    }

    /**
     * 删除产品周期详情
     *
     * @param ids 主键ID
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(cycleRecordService.removeByIds(ids));
    }
}
