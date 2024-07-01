public class ElementsCountVisitor implements ElementVisitor{
    int totalElements = 0;

    public int getTotalElements() {
        return totalElements;
    }

    @Override
    public void visit(Kid k) {
        totalElements += 1;
    }
    @Override
    public void visit(Tree t) {
        totalElements += 1;    }

    @Override
    public void visit(Flag f) {
        totalElements += 1;    }

    @Override
    public void visit(Kite k) {
        totalElements += 1;    }

    @Override
    public void visit(Boat b) {
        totalElements += 1;
    }

    @Override
    public void visit(CompositeElement c) {
        totalElements += 1;
    }
}
