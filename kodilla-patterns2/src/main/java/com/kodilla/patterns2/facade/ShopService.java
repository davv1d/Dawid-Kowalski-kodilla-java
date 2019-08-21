package com.kodilla.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class ShopService {
    private final List<Order> orders = new ArrayList<>();

    @Autowired
    private Authenticator authenticator;

    @Autowired
    private ProductService productService;

    public Long openOrder(Long userId) {
        if (authenticator.isAuthenticated(userId)) {
            Long maxOrder = (long)orders.stream()
                    .mapToInt(o -> o.getOrderId().intValue())
                    .max().orElse(0);
            orders.add(new Order(maxOrder + 1, userId, productService));
            return maxOrder + 1;
        } else {
            return -1L;
        }
    }

    public void addItem(Long orderId, Long productId, double qty) {
        orders.stream()
                .filter(o->o.getOrderId().equals(orderId))
                .forEach(o->o.getItems().add(new Item(productId, qty)));
    }

    public boolean removeItem(Long orderId, Long productId) {
        Iterator<Order> orderIterator = getOrderWhichHasSpecificId(orderId);
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            int orderSize = order.getItems().size();
            for (int n = 0; n < orderSize; n++) {
                if (order.getItems().get(n).getProductId().equals(productId)) {
                    order.getItems().remove(n);
                    return true;
                }
            }
        }
        return false;
    }

    public BigDecimal calculateValue(Long orderId) {
        Iterator<Order> orderIterator = getOrderWhichHasSpecificId(orderId);
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            return order.calculateValue();
        }
        return BigDecimal.ZERO;
    }

    public boolean doPayment(Long orderId) {
        Iterator<Order> orderIterator = getOrderWhichHasSpecificId(orderId);
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            if (order.isPaid()) {
                return true;
            } else {
                Random random = new Random();
                order.setPaid(random.nextBoolean());
                return order.isPaid();
            }
        }
        return false;
    }

    public boolean verifyOrder(Long orderId) {
        Iterator<Order> orderIterator = getOrderWhichHasSpecificId(orderId);
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            boolean result = order.isPaid();
            Random random = new Random();
            if (order.isVerified()) {
                order.setVerified(result && random.nextBoolean());
            }
            return order.isVerified();
        }
        return false;
    }

    public boolean submitOrder(Long orderId) {
        Iterator<Order> orderIterator = getOrderWhichHasSpecificId(orderId);
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            if (order.isVerified()) {
                order.setSubmitted(true);
            }
            return order.isSubmitted();
        }
        return false;
    }

    public void cancelOrder(Long orderId) {
        Iterator<Order> orderIterator = getOrderWhichHasSpecificId(orderId);
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            orders.remove(order);
        }
    }

    private Iterator<Order> getOrderWhichHasSpecificId(Long orderId) {
        return orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
    }


}
