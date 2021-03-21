package shapes.service;

import org.springframework.stereotype.Service;
import shapes.entity.Shape;

import java.util.List;

@Service
public class ShapeService {

    public void print(Shape shape) {
        shape.draw();
    }

    public void print(List<Shape> shapes) {
        shapes.forEach(Shape::draw);
    }
}
