package com.wsm.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wsm.entity.Order;
import com.wsm.rpcServier.RPCOrderService;

import java.util.ArrayList;
import java.util.List;

//注意这里是 dubbo 的服务注解
@Service(weight = 50)
//@Service(version = "1.0.0")       //设置版本
public class RPCOrderServiceImpl implements RPCOrderService {
    //造假数据！
    private static List<Order> list = new ArrayList<>();
    static {
        list.add(new Order(1, "张三的订单1.0", 10, 1));
        list.add(new Order(2, "张三的订单1.0", 100, 1));
        list.add(new Order(3, "李四的订单1.0", 10, 2));
        list.add(new Order(4, "张三的订单1.0", 105, 1));
        list.add(new Order(5, "李四的订单1.0", 10, 2));
    }
    //根据输入用户id 获取对应的订单数据！
    @Override
    public List<Order> findUserOrder(Integer uid) {
        System.out.println("负载均衡二");
        List<Order> orders = new ArrayList<>();
        for (Order order : list) {
            if (uid == order.getUid()) {
                orders.add(order);
            }
        }
        return orders;
    }
}
