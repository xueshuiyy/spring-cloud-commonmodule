package lin.feign.consumer.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * Created by Administrator on 2019/4/25.
 */
public class CustomeFeignApiWithoutHystrixConfg {
    @Scope("prototype")
    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
