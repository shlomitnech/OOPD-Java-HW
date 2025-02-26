 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//import PaperFactory;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose from the following options:\n" +
                "a: Art\n" +
                "p: Papers");
        String choice = scanner.nextLine();
        if (choice.equals("a")){
            artMenu(scanner);
        }
        if (choice.equals("p")){
            paperMenu(scanner);
        }
    }
    public static Painting readElementDetails(String path) throws IOException {
        Painting painting = new Painting();
        Map<String, Element> files = new HashMap();

        Files.lines(Paths.get(path))
            .map(str -> ElementDetailsFactory.getPaintingElement(str))
            .forEach(e-> painting.addElement(e));
        return painting;
    }
    public static void artMenu(Scanner scanner) throws IOException {
        System.out.println("Enter the path of the painting description");
        String path=scanner.nextLine();
        Painting root= readElementDetails(path);
        System.out.println("Choose from the following options:\n" +
                "q: quit\n" +
                "c: count elements\n" +
                "lp: long print\n" +
                "sh: short print\n" +
                "ta: total area");
        String myString;
        while (!(myString = scanner.nextLine()).equals("q")) {
            switch (myString) {
                case "c":
                    ElementsCountVisitor ecVisitor = new ElementsCountVisitor();
                    for (Element element : root.elementList) {
                        element.accept(ecVisitor);
                    }
                    System.out.println(ecVisitor.getTotalElements());
                    break;
                case "sh":
                    ShortPrintVisitor spVisitor = new ShortPrintVisitor();
                    for (Element element : root.elementList) {
                        element.accept(spVisitor);
                    }
                    break;
                case "ta":
                    AreaCalculatorVisitor acVisitor = new AreaCalculatorVisitor();
                    for (Element element : root.elementList) {
                        element.accept(acVisitor);
                    }
                    //root.elementList.forEach(e-> e.accept(acVisitor));
                    System.out.println(acVisitor.calculateArea());
                    break;
                case "lp":
                    LongPrintVisitor lpVisitor = new LongPrintVisitor();
                    for (Element element : root.elementList) {
                        element.accept(lpVisitor);
                    }
                    System.out.println();
                    break;
            }

        }
    }

    public static void paperMenu(Scanner scanner){
        System.out.println("Choose from the following paper:\n" +
                "ac: academic paper\n" +
                "cn: contract\n" +
                "jr: journal article\n" +
                "bk: book");
        // TODO: Add a Paper Factory and use it to create a Paper
        //Paper paper = null;
        PaperFactory pf = new PaperFactory();
        Paper paper = (Paper) pf.createPaper(scanner.nextLine());
        String choice="";
        while (!choice.equals("s")) {
            System.out.println("Choose from the following options:\n" +
                    "a: add element\n" +
                    "s: submit");
            choice = scanner.nextLine();
            if (choice.equals("a")) {
                paper = paperElementMenu(scanner, paper);
            }
            if (choice.equals("s")) {
                System.out.println(paper.write());

            }
        }


    }
   public static Paper paperElementMenu(Scanner scanner, Paper paper){
        System.out.println("Choose from the following elements:\n" +
                "tb: table\n" +
                "eq: equation\n" +
                "d: diagram\n" +
                "nt: note");
        // TODO: Use a Paper-Element Factory to create a decorated Hamburger
       PaperElementFactory pef = new PaperElementFactory();
       return pef.createPaperElement(scanner.nextLine(), paper);
    }
}
