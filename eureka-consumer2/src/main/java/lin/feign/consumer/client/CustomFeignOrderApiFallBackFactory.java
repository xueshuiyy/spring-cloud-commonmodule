package lin.feign.consumer.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/24.
 */
@Slf4j
@Component
public class CustomFeignOrderApiFallBackFactory implements FallbackFactory<OrderClient> {
    @Override
    public OrderClient create(Throwable throwable) {
        return new OrderClient() {
            @Override
            public List<String> getOtherOrders(String userId) {
                log.info("通过用户ID:{}查询其他订单的降级方法", userId);

                List<String> feignList = new ArrayList<>();
                feignList.add("Other error 1");
                feignList.add("Other error 2");
                feignList.add("Other error 3");
                return feignList;
            }

            @Override
            public List<String> getOrders(String userId) {
                log.info("通过用户ID:{}查询订单的降级方法", userId);

                List<String> feignList = new ArrayList<>();
                feignList.add("Orders error 1");
                feignList.add("Orders error 2");
                feignList.add("Orders error 3");
                return feignList;
            }
        };
    }
}
