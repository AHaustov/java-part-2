package shapes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import shapes.entity.Shape;
import shapes.service.ShapeService;

import java.util.List;

public class ShapeFlow implements ApplicationRunner {

    List<Shape> lines;
    List<Shape> rectangles;
    Shape picture;
    ShapeService shapeService;

    public ShapeFlow(@Qualifier("line") List<Shape> lines,
                     @Qualifier("rectangle") List<Shape> rectangles,
                     Shape picture,
                     ShapeService shapeService) {
        this.lines = lines;
        this.rectangles = rectangles;
        this.picture = picture;
        this.shapeService = shapeService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        shapeService.print(lines);
        shapeService.print(rectangles);
        shapeService.print(picture);
    }
}
