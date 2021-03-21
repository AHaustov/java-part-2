package shapes.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shapes.ShapeFlow;
import shapes.entity.Line;
import shapes.entity.Picture;
import shapes.entity.Rectangle;
import shapes.entity.Shape;
import shapes.service.ShapeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    @Bean
    @Qualifier("line")
    public Shape fourCharLine() {
        return new Line('-', 4);
    }

    @Bean
    @Qualifier("line")
    public Shape fiveCharLine() {
        return new Line('-', 5);
    }

    @Bean
    @Qualifier("line")
    public Shape sixCharLine() {
        return new Line('-', 6);
    }

    @Bean
    @Qualifier("rectangle")
    public Shape smallSquare() {
        return new Rectangle('x', 4, 4);
    }

    @Bean
    @Qualifier("rectangle")
    public Shape bigSquare() {
        return new Rectangle('x', 8, 8);
    }

    @Bean
    @Qualifier("picture")
    public Shape twoLineOneRectanglePicture() {
        List<Shape> shapes = Arrays.asList(fourCharLine(), smallSquare(), sixCharLine());
        return new Picture('@', shapes);
    }

    @Bean
    public ShapeFlow shapeFlow(@Qualifier("line") List<Shape> lines,
                               @Qualifier("rectangle") List<Shape> rectangles,
                               Shape twoLineOneRectanglePicture,
                               ShapeService shapeService) {
        return new ShapeFlow(lines, rectangles, twoLineOneRectanglePicture, shapeService);
    }
}
