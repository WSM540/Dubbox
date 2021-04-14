package com.wsm.rpcServier;

import com.wsm.entity.Order;
import java.util.List;
public interface RPCOrderService {
    public List<Order> findUserOrder(Integer uid);
}
