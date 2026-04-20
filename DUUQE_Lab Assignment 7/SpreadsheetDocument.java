public class SpreadsheetDocument implements Document {
    private String spreadsheetName;
    private int rowCount;
    private int columnCount;

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
        System.out.println("Opening Spreadsheet Document: " + spreadsheetName + " (" + rowCount + " rows, " + columnCount + " columns)");
    }

    @Override
    public String getType() {
        return "Spreadsheet";
    }

    // Getters and Setters
    public String getSpreadsheetName() { return spreadsheetName; }
    public void setSpreadsheetName(String spreadsheetName) { this.spreadsheetName = spreadsheetName; }
    public int getRowCount() { return rowCount; }
    public void setRowCount(int rowCount) { this.rowCount = rowCount; }
    public int getColumnCount() { return columnCount; }
    public void setColumnCount(int columnCount) { this.columnCount = columnCount; }
}