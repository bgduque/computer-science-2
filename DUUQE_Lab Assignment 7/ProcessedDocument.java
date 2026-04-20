public class ProcessedDocument {
    public static void main(String[] args) {
        DocumentRegistry registry = new DocumentRegistry();

        PDFDocument doc1 = registry.createPdf();
        doc1.setFileName("annual_report_2024.pdf");
        doc1.setAuthor("Acme Corp");
        doc1.setPageCount(150);
        
        doc1.open();
        System.out.println("Type: " + doc1.getType() + ", File: " + doc1.getFileName() + ", Author: " + doc1.getAuthor() + ", Pages: " + doc1.getPageCount() + "\n");

        TextDocument doc2 = registry.createText();
        doc2.setFilePath("meeting_notes.txt");
        doc2.setEncoding("UTF-8");
        doc2.setWordCount(250);
        
        doc2.open();
        System.out.println("Type: " + doc2.getType() + ", Path: " + doc2.getFilePath() + ", Encoding: " + doc2.getEncoding() + ", Words: " + doc2.getWordCount() + "\n");

        SpreadsheetDocument doc3 = registry.createSpreadsheet();
        doc3.setSpreadsheetName("sales_data_q1.xlsx");
        doc3.setRowCount(1000);
        doc3.setColumnCount(20);
        
        doc3.open();
        System.out.println("Type: " + doc3.getType() + ", Name: " + doc3.getSpreadsheetName() + ", Rows: " + doc3.getRowCount() + ", Columns: " + doc3.getColumnCount() + "\n");

        PDFDocument doc4 = registry.createPdf();
        doc4.setFileName("summary_report.pdf");
        doc4.setAuthor("Acme Corp");
        doc4.setPageCount(30);
        
        doc4.open();
    }
}