package org.ProjetoSpringBoot.Config;

import org.ProjetoSpringBoot.Logging.InterceptorLoggingApiComidas;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final InterceptorLoggingApiComidas interceptorLoggingApiComidas;

    public WebConfig(InterceptorLoggingApiComidas interceptorLoggingApiComidas) {
		this.interceptorLoggingApiComidas = interceptorLoggingApiComidas;
	}
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorLoggingApiComidas);
    }
}