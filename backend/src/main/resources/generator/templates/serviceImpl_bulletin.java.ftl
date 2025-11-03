package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author ${author}
 */
@Service
public class ${table.serviceImplName} extends ServiceImpl<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    /**
     * 分页查询${entity}信息
     *
     * @param page 分页对象
     * @param ${entity?uncap_first} 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> get${entity}ByPage(Page<${entity}> page, ${entity} ${entity?uncap_first}) {
        return baseMapper.get${entity}ByPage(page, ${entity?uncap_first});
    }
}