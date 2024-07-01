public interface ElementVisitor {
    // create visits for each type of element in a Painting
    void visit(Kid k);
    void visit(Tree t);
    void visit(Flag f);
    void visit(Kite k);
    void visit(Boat b);
    void visit(CompositeElement c);
}