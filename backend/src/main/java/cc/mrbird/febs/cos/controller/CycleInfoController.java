package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.CycleInfo;
import cc.mrbird.febs.cos.entity.UserInfo;
import cc.mrbird.febs.cos.service.ICycleInfoService;
import cc.mrbird.febs.cos.service.IUserInfoService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
@RequestMapping("/cos/cycleInfo-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CycleInfoController {

    private final ICycleInfoService cycleInfoService;

    private final IUserInfoService userInfoService;

    /**
     * 分页查询产品周期
     *
     * @param page      分页对象
     * @param cycleInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<CycleInfo> page, CycleInfo cycleInfo) {
        return R.ok();
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(cycleInfoService.list());
    }

    /**
     * 新增产品周期
     *
     * @param cycleInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(CycleInfo cycleInfo) {
        UserInfo userInfo = userInfoService.getOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUserId, cycleInfo.getUserId()));
        if (userInfo != null) {
            cycleInfo.setUserId(userInfo.getId());
        }
        cycleInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(cycleInfoService.save(cycleInfo));
    }

    /**
     * 修改产品周期
     *
     * @param cycleInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(CycleInfo cycleInfo) {
        return R.ok(cycleInfoService.updateById(cycleInfo));
    }

    /**
     * 删除产品周期
     *
     * @param ids 主键ID
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(cycleInfoService.removeByIds(ids));
    }
}
