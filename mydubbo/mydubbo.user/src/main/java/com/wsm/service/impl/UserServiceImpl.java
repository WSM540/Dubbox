package com.wsm.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wsm.entity.Order;
import com.wsm.entity.User;
import com.wsm.rpcServier.RPCOrderService;
import com.wsm.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

//正常的Spring的 @Service注解！
@Service
public class UserServiceImpl implements UserService {
    /*局部配置:
        @Reference(check = false)           //自动检查配置 true/false
        @Reference(vtimeout = 3000)         //设置超时重试
        @Reference(retries = 5)             //重试机制,指定重试次数！
        @Reference(url = "127.0.0.1:20881") //直连
        @Reference(version = "1.0.0")       //指定要调用的版本！
        @Reference(loadbalance = "roundrobin") //设置轮询规则!
    * */
//    @Reference
    @Reference(loadbalance = "roundrobin")
    private RPCOrderService rpcOrderService;

    @Override
    @HystrixCommand(fallbackMethod = "findUserByorder_fallback")    //指定降级方法！
    public User findUserByorder(Integer id) {
        //手动抛出异常,查看降级结果！
        if (id==1){
            throw new RuntimeException("异常了！");
        }
        User user = new User();
        user.setId(id);
        user.setNickname("张三");
        List<Order> userOrder = rpcOrderService.findUserOrder(id);
        user.setOrders(userOrder);
        return user;
    }

    //改降级方法要与,服务方法参数一模一样！
    public User findUserByorder_fallback(Integer id) {
        User user = new User();
        user.setId(id);
        user.setNickname("熔断方法");
        return user;
    }
}
