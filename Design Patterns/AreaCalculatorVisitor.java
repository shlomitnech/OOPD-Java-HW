public class AreaCalculatorVisitor implements ElementVisitor {

    double areaSum = 0;

    public int calculateArea() {
        return (int) Math.round(areaSum);
    }

    @Override
    public void visit(Kid k) {
        double radius = k.getWidth()/2;
        double CircArea = (radius*radius*Math.PI);
        double RectLength = k.getLength()-k.getWidth(); //
        double Area = RectLength * k.getWidth()+CircArea;
        areaSum += Area;
    }
    @Override
    public void visit(Tree t) {
        areaSum += (t.getLength() * t.getWidth()) / 2;
//        double triangleArea = (t.getWidth() * t.getWidth()) / 4;
//        double rectangleArea = (t.getWidth() / 2) * (t.getWidth() / 2);
//        areaSum += triangleArea + rectangleArea;
    }

    @Override
    public void visit(Flag f) {
        areaSum += f.getLength() * f.getWidth();
    }

    @Override
    public void visit(Kite k) {
        areaSum += (k.getLength() * k.getWidth()) / 2;
    }

    @Override
    public void visit(Boat b) {
//        double radius = b.getWidth() / 2;
//        double semiCircArea = (radius * radius * Math.PI) / 2;
//        double rectLength = b.getLength() - b.getWidth();
//        double area = rectLength * b.getWidth() + semiCircArea;
//        areaSum += area;
        double radius = b.getWidth()/2;
        double semiCircArea = (radius*radius*Math.PI)/2;
        double RectLength = b.getLength()-radius;
        double Area = RectLength * b.getWidth()+semiCircArea;
        areaSum += Area;
    }

    @Override
    public void visit(CompositeElement c) {
        if (c.getClass().getName().equals("Lake")) {
            double radius = c.getWidth()/2;
            double Area = (radius*radius*Math.PI);
            areaSum += Area;
        }
        else if (c.getClass().getName().equals("Island")) {
            double radius = c.getWidth()/2;
            areaSum += Math.PI * radius * radius;
        }
//        if (c instanceof Lake) {
//            double radius = c.getWidth() / 2;
//            double area = radius * radius * Math.PI;
//            areaSum += area;
//        } else if (c instanceof Island) {
//            double radius = c.getWidth() / 2;
//            double area = radius * radius * Math.PI;
//            areaSum += area;
//        }
    }
}
