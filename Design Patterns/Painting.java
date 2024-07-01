 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Painting {
    Map<String, Element> pathToElementMap;
    List<Element> elementList;

    Painting(){
        elementList=new ArrayList<>();
        pathToElementMap = new HashMap<>();
    }

    public void addElement(Element element){
        pathToElementMap.put(element.getFullName(), element);
        if (element.getPath().isEmpty()){
            elementList.add(element);
        }
        else {
            CompositeElement containingElement = (CompositeElement) pathToElementMap.get(element.getPath());

            // if the containingElement is a lake
            if (containingElement.getClass().getName().equals("Lake")) {
                // we can only add elements that are of type amphibian and aquatic
                if (element.getHabitat() == Habitat.AMPHIBIAN || element.getHabitat() == Habitat.AQUATIC) {
                    containingElement.addChild(element);
                }
                else {
                    System.out.println(containingElement.getName() + " cannot contain " + element.getName());
                }
            }
            // if the containingElement is an island
            else if (containingElement.getClass().getName().equals("Island")) {
                // we can only add elements that are of type amphibian and terrestrial
                if (element.getHabitat() == Habitat.AMPHIBIAN || element.getHabitat() == Habitat.TERRESTRIAL) {
                    containingElement.addChild(element);
                }
                else {
                    System.out.println(containingElement.getName() + " cannot contain " + element.getName());
                }
            }
            // if the element itself is a composite element (island/lake), then add it to the list
            else if (element.getClass().getName().equals("Island") || containingElement.getClass().getName().equals("Lake")) {
                elementList.add(element);
            }
        }
    }

    public String getName() {
        return Painting.class.getSimpleName().toLowerCase();
    }

//    public int countElements() {
//        return this.elementList.toArray().length;
//    }
//
//    public void shortPrint() {
//
//    }

}
