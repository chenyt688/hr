package com.neuedu.hr.sys.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.neuedu.hr.sys.terceptor.AuthIntrceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.neuedu.hr")
@PropertySource("classpath:app.properties") //相当于<context:propetity-placeholder location="classpath:app.properties" />
@MapperScan("com.neuedu.hr.business.dao")
public class HrConfig  extends WebMvcConfigurerAdapter {
    @Autowired
    public Environment environment;
    @Autowired
    private ApplicationContext applicationContext;
    /**
     * 配置静态资源管理器
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")//配置前台请求虚拟路径
                .addResourceLocations("/assets/")//配置后台对应的资源路径位置
                .setCachePeriod(31536000);
    }
    /**
     * 配置数据库连接池
     * @return
     */
    @Bean
    public DataSource dataSource(){
        //创建druid连接池
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        druidDataSource.setUrl(environment.getProperty("jdbc.url"));
        druidDataSource.setPassword(environment.getProperty("jdbc.password"));
        druidDataSource.setUsername(environment.getProperty("jdbc.username"));
        return druidDataSource;
    }

    /**
     * 配置mybatis的SqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return factoryBean.getObject();
    }
    /**
     * 配置事务管理器
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }


    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("utf-8");
        registry.viewResolver(resolver);
    }


    /**
     * 配置拦截器
     * @param registry
     */
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthIntrceptor()).addPathPatterns("/**").excludePathPatterns("/login/**","/","login.html");
    }*/
}
