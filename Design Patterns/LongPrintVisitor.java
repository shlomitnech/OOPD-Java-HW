public class LongPrintVisitor implements ElementVisitor {
    @Override
    public void visit(Kid k) {
        int age = 2023 - k.getBirthYear();
        System.out.print("A " + age + " year old kid with " + k.getHairColor().toString().toLowerCase() + " hair. ");
    }
    @Override
    public void visit(Tree t) {
        System.out.print("A tree with an amount of " + t.getLeavesAmount() + " leaves. ");
    }

    @Override
    public void visit(Flag f) {
        System.out.print("A flag with color: " + f.getColor().toString().toLowerCase() + " of height " + f.getCarrierHeight() + ". ");
    }

    @Override
    public void visit(Kite k) {
        System.out.print("A kite of color: " + k.getColor().toString().toLowerCase() + ". ");
    }

    @Override
    public void visit(Boat b) {
        System.out.print("A boat made of " + b.getMaterial().toString().toLowerCase() + " material. ");    }

    @Override
    public void visit(CompositeElement c) {
        if (c.getClass().getName().equals("Lake")) {
            System.out.print("A lake named " + c.getName() + " containing: ");
        }
        else if (c.getClass().getName().equals("Island")) {
            if (c.itsElements.isEmpty()) {
                System.out.print("An empty island named " + c.getName() + ". ");
            }
            else
                System.out.print("An island named " + c.getName() + " containing: ");
        }

    }


}
