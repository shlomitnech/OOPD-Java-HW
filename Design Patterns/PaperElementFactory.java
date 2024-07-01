public class PaperElementFactory {
    public static Paper createPaperElement(String code, Paper paper){
        //TODO: fix
        if (code == null) {
            return null;
        }
        else if (code.equals("tb")) {
            return new Table(paper);
        }
        else if (code.equals("eq")) {
            return new Equation(paper);
        }
        else if (code.equals("d")) {
            return new Diagram(paper);
        }
        else if (code.equals("nt")) {
            return new Note(paper);
        }
        throw new RuntimeException("wrong PaperElementType");
    }
}
