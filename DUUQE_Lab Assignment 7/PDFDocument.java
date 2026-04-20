public class PDFDocument implements Document {
    private String fileName;
    private String author;
    private int pageCount;
    private String name;

    @Override
    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning failed.");
            return null;
        }
    }

    @Override
    public void open() {
        System.out.println("Opening PDF Document: " + fileName + " by " + author + " (" + pageCount + " pages)");
    }

    @Override
    public String getType() {
        return "PDF";
    }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getPageCount() { return pageCount; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}