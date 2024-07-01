public class Table extends PaperDecorator {
    public Table(Paper paper) {
        super(paper);
    }

    public String write() {
        return super.write() + decorateWithTable();
    }

    public String decorateWithTable() {
        return " Table ";
    }
}
