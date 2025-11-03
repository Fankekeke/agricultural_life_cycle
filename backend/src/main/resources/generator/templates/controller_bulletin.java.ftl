package ${package.Controller};


import cc.mrbird.febs.common.utils.R;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author ${author}
 */
@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ${table.controllerName} {

    private final ${table.serviceName} ${smallEntityName}Service;

    /**
     * 分页查询${entity}信息
     *
     * @param page 分页对象
     * @param ${smallEntityName} 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<${entity}> page, ${entity} ${smallEntityName}) {
        return R.ok(${smallEntityName}Service.get${entity}ByPage(page, ${entity}));
    }

    /**
     * 获取${entity}列表
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(${smallEntityName}Service.list());
    }

    /**
     * 新增${entity}信息
     *
     * @param ${smallEntityName} 参数
     * @return 结果
     */
    @PostMapping
    public R save(${entity} ${smallEntityName}) {
        <#if entityDateField??>${smallEntityName}.set${entityDateField}(DateUtil.formatDateTime(new Date()));</#if>
        return R.ok(${smallEntityName}Service.save(${smallEntityName}));
    }

    /**
     * 修改${entity}信息
     *
     * @param ${smallEntityName} 参数
     * @return 结果
     */
    @PutMapping
    public R edit(${entity} ${smallEntityName}) {
        return R.ok(${smallEntityName}Service.updateById(${smallEntityName}));
    }

    /**
     * 删除${entity}信息
     *
     * @param ids 主键ID
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(${smallEntityName}Service.removeByIds(ids));
    }
}