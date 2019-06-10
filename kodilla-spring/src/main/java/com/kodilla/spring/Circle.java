package com.kodilla.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Circle  implements Shape {

    @Override
    public String getShapeName() {
        return "This is a circle";
    }
}
