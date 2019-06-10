package com.kodilla.spring.shape;

import com.kodilla.spring.Circle;
import com.kodilla.spring.Shape;
import com.kodilla.spring.Triangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ShapesFactory {

    @Bean
    public Shape createSquare() {
        return new Square();
    }

    @Bean
    public Shape chosenShape() {
        Shape theShape;
        Random generator = new Random();
        int chosen = generator.nextInt(3);
        if (chosen == 0) {
            theShape = new Triangle();
        } else if (chosen == 1) {
            theShape = new Circle();
        } else {
            theShape = new Square();
        }
        return theShape;
    }
}
