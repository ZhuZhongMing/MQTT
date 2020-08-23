package com.smmd.common.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.IOException;


/**
 * 
 * Mybatis Plus 生成工具
 * 
 */
public class MpGeneratorSqlServer {
	public static void main(String[] args) throws IOException {
		AutoGenerator mpg = new AutoGenerator();
		// 选择 freemarker 引擎，默认 Veloctiy
		// mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		// 全局配置

		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("E://MybatisPlusGen");
		gc.setFileOverride(true);
		gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		// .setKotlin(true) 是否生成 kotlin 代码
		gc.setAuthor("朱中明");

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setEntityName("%sEntity");
		gc.setMapperName("%sMapper");
		gc.setXmlName("%sMapper");
		gc.setServiceName("%sService");
		gc.setServiceImplName("%sImpl");
		gc.setControllerName("%sController");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.SQL_SERVER);
		dsc.setTypeConvert(new MySqlTypeConvert() {
			// 自定义数据库表字段类型转换【可选】
			public DbColumnType processTypeConvert(String fieldType) {
				System.out.println("转换类型：" + fieldType);
				// 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
				return (DbColumnType) super.processTypeConvert(null, fieldType);
			}
		});
		dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dsc.setUsername("sa");
		dsc.setPassword("123456");
		//dsc.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8");
		dsc.setUrl("jdbc:sqlserver://localhost:1433;databaseName=china");
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
		strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		strategy.setInclude(new String[] { "provinces"}); // 需要生成的表
		// strategy.setExclude(new String[]{"test"}); // 排除生成的表
		// 自定义实体父类
		// strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
		// 自定义实体，公共字段
		// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
		// 自定义 mapper 父类
		// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
		// 自定义 service 父类
		// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
		// 自定义 service 实现类父类
		// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
		// 自定义 controller 父类
		// strategy.setSuperControllerClass("com.baomidou.demo.TestController");
		// 【实体】是否生成字段常量（默认 false）
		// public static final String ID = "test_id";
		// strategy.setEntityColumnConstant(true);
		// 【实体】是否为构建者模型（默认 false）
		// public User setName(String name) {this.name = name; return this;}
		// strategy.setEntityBuilderModel(true);
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.smmd.modules.SQL_Server");
		pc.setController("controller");
		pc.setEntity("entity");
		pc.setService("service");
		pc.setMapper("mapper");
		pc.setServiceImpl("service.impl");
		pc.setXml("mapper.xml");
		mpg.setPackageInfo(pc);

		// 执行生成
		mpg.execute();
	}

}