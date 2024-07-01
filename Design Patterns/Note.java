public class Note extends PaperDecorator {
    public Note(Paper paper) {
        super(paper);
    }

    public String write() {
        return super.write() + decorateWithNote();
    }

    public String decorateWithNote() {
        return "Note ";
    }

}
