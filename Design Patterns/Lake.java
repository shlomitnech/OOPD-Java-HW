 
public class Lake extends CompositeElement {
    public Lake(String name, double diameter, String path) {
        super(name,diameter,path);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }
}
