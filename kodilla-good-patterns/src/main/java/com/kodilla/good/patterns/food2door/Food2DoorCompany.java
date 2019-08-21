package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Food2DoorCompany {
    private List<Producer> producers = new ArrayList<>();

    private List<Producer> findProducers(Order order){
        return this.producers.stream()
                .filter(producer -> producer.amountOfProduct() >= order.getAmountOfProduct() &&
                        producer.getKindOfProduct().equals(order.getKindOfProduct()))
                .collect(Collectors.toList());
    }

    public void addProducer(Producer producer) {
        producers.add(producer);
    }

    public boolean doOrder(Order order){
        List<Producer> producers = findProducers(order);
        if(producers.isEmpty()){
            System.out.println("We haven't company who has this product");
            return false;
        } else {
           return producers.get(0).process(order);
        }
    }
}
