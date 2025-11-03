package ${package.Service};

import ${package.Entity}.${entity};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.LinkedHashMap;

/**
 * @author ${author}
 */
public interface ${table.serviceName} extends IService<${entity}> {

    /**
     * 分页查询${entity}信息
     *
     * @param page 分页对象
     * @param ${entity?uncap_first} 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> get${entity}ByPage(Page<${entity}> page, ${entity} ${entity?uncap_first});
}