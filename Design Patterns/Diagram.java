public class Diagram extends PaperDecorator {
    public Diagram(Paper paper) {
        super(paper);
    }

    public String write() {
        return super.write() + decorateWithDiagram();
    }

    public String decorateWithDiagram() {
        return "Diagram ";
    }
}
