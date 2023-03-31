package cn.wusx.springboot.config;

import cn.wusx.springboot.common.interceptor.Test1Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	/**
	 * 静态资源配置
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");// 静态资源路径 css,js,img等
		registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");// 视图
		registry.addResourceHandler("/mapper/**").addResourceLocations("classpath:/mapper/");// mapper.xml
		super.addResourceHandlers(registry);
	}
	/*
	 * 拦截器配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册自定义拦截器，添加拦截路径和排除拦截路径
		registry.addInterceptor(new Test1Interceptor()) // 添加拦截器
				.addPathPatterns("/**") // 添加拦截路径
				.excludePathPatterns(// 添加排除拦截路径
						"/hello").order(0);//执行顺序
		super.addInterceptors(registry);
	}
}
