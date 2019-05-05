package lin.feign.provider.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/4/25.
 */
@Configuration
public class MainConfig {

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);  //系统启动时加载顺序
        registrationBean.addUrlMappings("/actuator/hystrix.stream");//路径
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
