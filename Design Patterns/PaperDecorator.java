public abstract class PaperDecorator implements Paper{
    private Paper itsPaper;
    public PaperDecorator(Paper paper) {
        this.itsPaper = paper;
    }

    @Override
    public String write() {
        return itsPaper.write();
    }
}
