package lin.feign.consumer.client;

import lin.feign.consumer.config.CustomeFeignApiWithoutHystrixConfg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2019/4/21.
 */
// , configuration = CustomeFeignApiWithoutHystrixConfg.class
@FeignClient(name= "provider-hi", fallbackFactory = CustomFeignOrderApiFallBackFactory.class)
public interface OrderClient {

    @RequestMapping(method = RequestMethod.GET, value = "/order/queryOrdersByUserId/{userId}", consumes = "application/json")
    public List<String> getOrders(@PathVariable("userId") String userId);

    @RequestMapping(method = RequestMethod.GET, value = "/order/getOtherOrders/{userId}", consumes = "application/json")
    public List<String> getOtherOrders(@PathVariable("userId") String userId);
}
