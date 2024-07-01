import java.util.ArrayList;
import java.util.List;

public abstract class CompositeElement extends Element {
    List<Element> itsElements = new ArrayList<Element>();

    public CompositeElement(String n, double diameter, String path) {
        super(diameter,diameter,path);
        this.name = n;
    }
    abstract public String getName();
    abstract public Habitat getHabitat();

    public void addChild(Element element) {
        itsElements.add(element);
    }

    @Override
    public void accept(ElementVisitor ev) {
        ev.visit(this);
        for(Element element : itsElements){
            element.accept(ev);
        }
    }
}
