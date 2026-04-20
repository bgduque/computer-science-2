public class TextDocument implements Document {
    private String filePath;
    private String encoding;
    private int wordCount;

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
        System.out.println("Opening Text Document: " + filePath + " with encoding: " + encoding + " (" + wordCount + " words)");
    }

    @Override
    public String getType() {
        return "Text";
    }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public String getEncoding() { return encoding; }
    public void setEncoding(String encoding) { this.encoding = encoding; }
    public int getWordCount() { return wordCount; }
    public void setWordCount(int wordCount) { this.wordCount = wordCount; }
}