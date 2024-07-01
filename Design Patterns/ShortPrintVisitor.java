public class ShortPrintVisitor implements ElementVisitor {
    @Override
    public void visit(Kid k) {
        System.out.println(k.getFullName());
    }
    @Override
    public void visit(Tree t) {
        System.out.println(t.getFullName());
    }

    @Override
    public void visit(Flag f) {
        System.out.println(f.getFullName());
    }

    @Override
    public void visit(Kite k) {
        System.out.println(k.getFullName());
    }

    @Override
    public void visit(Boat b) {
        System.out.println(b.getFullName());
    }

    @Override
    public void visit(CompositeElement c) {
        System.out.println(c.getFullName());
    }

}
