package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.CommunicateInfo;
import cc.mrbird.febs.cos.service.ICommunicateInfoService;
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
@RequestMapping("/cos/communicate-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommunicateInfoController {

    private final ICommunicateInfoService communicateInfoService;

    /**
     * 分页查询在线沟通
     *
     * @param page            分页对象
     * @param communicateInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<CommunicateInfo> page, CommunicateInfo communicateInfo) {
        return R.ok();
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(communicateInfoService.list());
    }

    /**
     * 新增在线沟通
     *
     * @param communicateInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(CommunicateInfo communicateInfo) {
        communicateInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(communicateInfoService.save(communicateInfo));
    }

    /**
     * 修改在线沟通
     *
     * @param communicateInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(CommunicateInfo communicateInfo) {
        return R.ok(communicateInfoService.updateById(communicateInfo));
    }

    /**
     * 删除在线沟通
     *
     * @param ids 主键ID
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(communicateInfoService.removeByIds(ids));
    }
}
