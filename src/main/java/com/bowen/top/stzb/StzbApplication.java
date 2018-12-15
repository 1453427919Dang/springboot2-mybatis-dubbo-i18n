package com.bowen.top.stzb;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.alibaba.druid.pool.DruidDataSource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages= {"com.bowen.top.stzb.dao"})
public class StzbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StzbApplication.class, args);
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("stzb-demo")
                .version("1.0")
                .build();
//                .description("swag")
                //服务条款网址
    }
    
    @Autowired
	private Environment env;
 
	//destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
		dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setInitialSize(2);//初始化时建立物理连接的个数
		dataSource.setMaxActive(20);//最大连接池数量
		dataSource.setMinIdle(0);//最小连接池数量
		dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
		dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
		dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
		dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
		dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
		return dataSource;
	}
	
	private CorsConfiguration buildConfig() {  
        CorsConfiguration corsConfiguration = new CorsConfiguration();  
        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等） 
        return corsConfiguration;  
    }  
  
    @Bean  
    public CorsFilter corsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        source.registerCorsConfiguration("/**", buildConfig()); // 4  
        return new CorsFilter(source);  
    }  
}
