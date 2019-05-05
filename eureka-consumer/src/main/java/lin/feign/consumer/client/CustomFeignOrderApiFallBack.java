package lin.feign.consumer.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 降级方法
 * Created by smlz on 2019/4/15.
 */
//@Component
@Slf4j
public class CustomFeignOrderApiFallBack{

    public List<String> getOrders(String userId) {
        log.info("通过用户ID:{}查询订单的降级方法", userId);

        List<String> feignList = new ArrayList<>();
        feignList.add("feign1");
        feignList.add("feign2");
        feignList.add("feign3");
        return feignList;
    }
}
