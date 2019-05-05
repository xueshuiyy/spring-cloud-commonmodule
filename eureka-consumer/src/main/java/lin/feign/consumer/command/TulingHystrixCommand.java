package lin.feign.consumer.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lin.feign.consumer.dto.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/24.
 */
@Slf4j
public class TulingHystrixCommand extends HystrixCommand<List<String>> {

    private String userId;

    private RestTemplate restTemplate;

    @Override
    protected List<String> run() throws Exception {
        return restTemplate.getForObject("http://PROVIDER-HI/order/queryOrdersByUserId/" + userId, List.class);
    }

    @Override
    protected List<String> getFallback() {
        log.info("触发降级方法========================>");

        List<String> orderVos = new ArrayList<>();
        orderVos.add("error1");
        orderVos.add("error2");
        orderVos.add("error3");
        return orderVos;
    }

    public TulingHystrixCommand(String commandGroupKey, RestTemplate restTemplate, String userId) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.restTemplate = restTemplate;
        this.userId = userId;
    }
}
