package lin.feign.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lin.feign.consumer.client.OrderClient;
import lin.feign.consumer.command.TulingHystrixCommand;
import lin.feign.consumer.dto.UserInfoVo;
import lin.feign.consumer.exception.TulingTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/21.
 */
@RestController
@Slf4j
public class OrderConsumerController {

    /* feign调用实例 */
    @Autowired
    OrderClient orderClient;

    @RequestMapping("/query/{userId}")
    public List<String> getOrders(@PathVariable String userId) {
        return orderClient.getOrders(userId);
    }

    @RequestMapping("/queryOther/{userId}")
    public List<String> getOtherOrders(@PathVariable String userId) {
        return orderClient.getOtherOrders(userId);
    }
    /*@Autowired
    private RestTemplate restTemplate;*/

    /*@RequestMapping(method = RequestMethod.GET, value = "/query/{userId}")
    public List<String> hiService(@PathVariable("userId") String userId) {
        List<String> result = new ArrayList<>();
        try {
            result = restTemplate.getForObject("http://PROVIDER-HI/order/queryOrdersByUserId/" + userId, List.class);
        } catch (Exception e) {
            throw new TulingTimeoutException("0", "调用超时");
        }
        return result;
    }*/

    /*@HystrixCommand(fallbackMethod = "queryUserInfoFallBack")
    @RequestMapping(method = RequestMethod.GET, value = "/query/{userId}")
    public List<String> hiService(@PathVariable("userId") String userId) {
       *//* //构建调用命令模式
        TulingHystrixCommand tulingHystrixCommand = new TulingHystrixCommand("orderGroupKey", restTemplate, userId);
        List<String> orderVoList = tulingHystrixCommand.execute();

        return orderVoList;*//*
        return restTemplate.getForObject("http://PROVIDER-HI/order/queryOrdersByUserId/" + userId, List.class);
    }*/

    protected List<String> queryUserInfoFallBack(String userId) {
        log.info("触发降级方法=根据用户ID{}查询订单服务异常:{}", userId);


        List<String> orderVos = new ArrayList<>();
        orderVos.add("fallBack: error1");
        orderVos.add("fallBack: error2");
        orderVos.add("fallBack: error3");
        return orderVos;
    }
}
