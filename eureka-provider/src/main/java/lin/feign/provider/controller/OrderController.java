package lin.feign.provider.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Administrator on 2019/4/21.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @RequestMapping("/queryOrdersByUserId/{userId}")
    public List<String> queryOrdersByUserId(@PathVariable("userId") String userId) throws InterruptedException {
        //超时降级
//        Thread.sleep(10000);

        if(userId.equals("6")) {
            throw new RuntimeException("不存在的用户");
        }

        List<String> orders = new ArrayList<>();
        orders.add("1");
        orders.add("2");
        orders.add("3");
        return orders;
    }

    @RequestMapping("/getOtherOrders/{userId}")
    public List<String> getOtherOrders(@PathVariable("userId") String userId) {
        if(userId.equals("6")) {
            throw new RuntimeException("不存在的用户");
        }

        List<String> orders = new ArrayList<>();
        orders.add("OtherOrders: 1");
        orders.add("OtherOrders: 2");
        orders.add("OtherOrders: 3");
        return orders;
    }

    @RequestMapping("/admin/{userId}")
    public List<String> getAdminOtherOrders(@PathVariable("userId") String userId) {
        List<String> orders = new ArrayList<>();
        orders.add("OtherAdmin: 1");
        orders.add("OtherAdmin: 2");
        orders.add("OtherAdmin: 3");

        return orders;
    }

    @RequestMapping("/getCookie")
    @ResponseBody
    public String testGetCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies) {
            System.out.println(cookie.getName()+"-"+cookie.getValue());
        }
        System.out.println(cookies);
        return "OK";
    }

}
