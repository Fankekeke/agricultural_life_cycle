package cc.mrbird.febs.common.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * mybatis plus 提供的代码生成器
 * 可以快速生成 Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码
 *
 * @link https://mp.baomidou.com/guide/generator.html
 */
public class CodeGenerator {

    // 数据库 URL
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/agricultural_life_cycle?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // 数据库驱动
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    // 数据库用户名
    private static final String USERNAME = "root";
    // 数据库密码
    private static final String PASSWORD = "123456";
    // @author 值
    private static final String AUTHOR = "FanK";
    // 包的基础路径
    private static final String BASE_PACKAGE_URL = "cc.mrbird.febs";
    // xml文件路径
    private static final String XML_PACKAGE_URL = "/src/main/resources/mapper/";
    // xml 文件模板
    private static final String XML_MAPPER_TEMPLATE_PATH = "generator/templates/mapper.xml";
    // mapper 文件模板（基于bulletinMapper样式）
    private static final String MAPPER_TEMPLATE_PATH = "generator/templates/mapper_bulletin.java.ftl";
    // entity 文件模板
    private static final String ENTITY_TEMPLATE_PATH = "generator/templates/entity.java";
    // service 文件模板（基于IBulletinInfoService样式）
    private static final String SERVICE_TEMPLATE_PATH = "generator/templates/service_bulletin.java.ftl";
    // serviceImpl 文件模板（基于BulletinInfoServiceImpl样式）
    private static final String SERVICE_IMPL_TEMPLATE_PATH = "generator/templates/serviceImpl_bulletin.java.ftl";
    // controller 文件模板（基于bulletinInfo模块样式）
    private static final String CONTROLLER_TEMPLATE_PATH = "generator/templates/controller_bulletin.java.ftl";
    // Vue 相关模板
    private static final String VUE_INDEX_TEMPLATE_PATH = "generator/templates/vue_index.vue.ftl";
    private static final String VUE_ADD_TEMPLATE_PATH = "generator/templates/vue_add.vue.ftl";
    private static final String VUE_EDIT_TEMPLATE_PATH = "generator/templates/vue_edit.vue.ftl";
    private static final String VUE_VIEW_TEMPLATE_PATH = "generator/templates/vue_view.vue.ftl";

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor(AUTHOR);
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(false);
        generator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(DRIVER_NAME);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);
        generator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("cos");
        packageConfig.setParent(BASE_PACKAGE_URL);
        generator.setPackageInfo(packageConfig);

        // 配置自定义代码模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(XML_MAPPER_TEMPLATE_PATH);
        templateConfig.setMapper(MAPPER_TEMPLATE_PATH);
        templateConfig.setEntity(ENTITY_TEMPLATE_PATH);
        templateConfig.setService(SERVICE_TEMPLATE_PATH);
        templateConfig.setServiceImpl(SERVICE_IMPL_TEMPLATE_PATH);
        templateConfig.setController(CONTROLLER_TEMPLATE_PATH);
        generator.setTemplate(templateConfig);

        // 自定义输出配置 - Vue页面
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // 可以在此处添加自定义参数
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        // Vue 列表页面
        focList.add(new FileOutConfig(VUE_INDEX_TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                String entityName = tableInfo.getEntityName();
                return projectPath + "/src/main/resources/generator/vue/" + entityName + ".vue";
            }
        });
        // Vue 新增页面
        focList.add(new FileOutConfig(VUE_ADD_TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = tableInfo.getEntityName();
                return projectPath + "/src/main/resources/generator/vue/" + entityName + "Add.vue";
            }
        });
        // Vue 编辑页面
        focList.add(new FileOutConfig(VUE_EDIT_TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = tableInfo.getEntityName();
                return projectPath + "/src/main/resources/generator/vue/" + entityName + "Edit.vue";
            }
        });
        // Vue 详情页面
        focList.add(new FileOutConfig(VUE_VIEW_TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = tableInfo.getEntityName();
                return projectPath + "/src/main/resources/generator/vue/" + entityName + "View.vue";
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        generator.setCfg(injectionConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名"));
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(packageConfig.getModuleName() + "_");
        generator.setStrategy(strategy);
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) return ipt;
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
