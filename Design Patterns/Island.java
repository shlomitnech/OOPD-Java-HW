
public class Island extends CompositeElement {
    public Island(String name, double diameter, String path) {
        super(name,diameter,path);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }
}
