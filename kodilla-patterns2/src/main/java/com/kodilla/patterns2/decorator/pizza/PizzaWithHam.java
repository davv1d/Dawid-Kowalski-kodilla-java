package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaWithHam extends AbstractPizzaOrderDecorator {
    public PizzaWithHam(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(7));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ham";
    }
}
