public class Equation extends PaperDecorator {
    public Equation(Paper paper) {
        super(paper);
    }

    public String write() {
        return super.write() + decorateWithEquation();
    }

    public String decorateWithEquation() {
        return "Equation ";
    }
}
