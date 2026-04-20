public class DocumentRegistry {
    private PDFDocument pdfPrototype;
    private TextDocument textDocumentPrototype;
    private SpreadsheetDocument spreadsheetPrototype;

    public DocumentRegistry() {
        System.out.println("Creating a PDF Document prototype.");
        this.pdfPrototype = new PDFDocument();
        
        System.out.println("Creating a Text Document prototype.");
        this.textDocumentPrototype = new TextDocument();
        
        System.out.println("Creating a Spreadsheet Document prototype.");
        this.spreadsheetPrototype = new SpreadsheetDocument();
        
        System.out.println();
    }

    public PDFDocument createPdf() {
        return (PDFDocument) pdfPrototype.clone();
    }

    public TextDocument createText() {
        return (TextDocument) textDocumentPrototype.clone();
    }

    public SpreadsheetDocument createSpreadsheet() {
        return (SpreadsheetDocument) spreadsheetPrototype.clone();
    }
}