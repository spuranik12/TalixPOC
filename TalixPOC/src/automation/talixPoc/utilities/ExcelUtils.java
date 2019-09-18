package automation.talixPoc.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelUtils {
	Sheet sheet;
	Workbook workbook;
	Cell cell;
	Row row;
	int cellType;

	public Map<String, String> getData(String filePath, String sheetName, int rowNumber) throws Exception {   
		String[] tabArray = null;
		Map<String, String> mapData = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			workbook = new Workbook() {
				
				@Override
				public Iterator<Sheet> iterator() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public void write(OutputStream arg0) throws IOException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public Iterator<Sheet> sheetIterator() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public void setSheetVisibility(int arg0, SheetVisibility arg1) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setSheetOrder(String arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setSheetName(int arg0, String arg1) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setSheetHidden(int arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setSheetHidden(int arg0, boolean arg1) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setSelectedTab(int arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setPrintArea(int arg0, int arg1, int arg2, int arg3, int arg4) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setPrintArea(int arg0, String arg1) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setMissingCellPolicy(MissingCellPolicy arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setHidden(boolean arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setForceFormulaRecalculation(boolean arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setFirstVisibleTab(int arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setActiveSheet(int arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void removeSheetAt(int arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void removePrintArea(int arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void removeName(Name arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void removeName(String arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void removeName(int arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public int linkExternalWorkbook(String arg0, Workbook arg1) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public boolean isSheetVeryHidden(int arg0) {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public boolean isSheetHidden(int arg0) {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public boolean isHidden() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public SpreadsheetVersion getSpreadsheetVersion() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public SheetVisibility getSheetVisibility(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public String getSheetName(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public int getSheetIndex(Sheet arg0) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public int getSheetIndex(String arg0) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public Sheet getSheetAt(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Sheet getSheet(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public String getPrintArea(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public int getNumberOfSheets() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public int getNumberOfNames() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public short getNumberOfFonts() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public int getNumCellStyles() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public List<? extends Name> getNames(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public int getNameIndex(String arg0) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public Name getNameAt(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Name getName(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public MissingCellPolicy getMissingCellPolicy() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public boolean getForceFormulaRecalculation() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public Font getFontAt(short arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public int getFirstVisibleTab() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public CreationHelper getCreationHelper() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public CellStyle getCellStyleAt(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public List<? extends PictureData> getAllPictures() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public List<? extends Name> getAllNames() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public int getActiveSheetIndex() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public Font findFont(boolean arg0, short arg1, short arg2, String arg3,
						boolean arg4, boolean arg5, short arg6, byte arg7) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Font findFont(short arg0, short arg1, short arg2, String arg3,
						boolean arg4, boolean arg5, short arg6, byte arg7) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Sheet createSheet(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Sheet createSheet() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Name createName() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Font createFont() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public DataFormat createDataFormat() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public CellStyle createCellStyle() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public void close() throws IOException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public Sheet cloneSheet(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public void addToolPack(UDFFinder arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public int addPicture(byte[] arg0, int arg1) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public int addOlePackage(byte[] arg0, String arg1, String arg2, String arg3)
						throws IOException {
					// TODO Auto-generated method stub
					return 0;
				}
			};
			sheet = workbook.getSheet(sheetName);
			int startRow = rowNumber;
			int startCol = 1;
			int ci;
			int totalCols = sheet.getRow(0).getLastCellNum();
			tabArray = new String[totalCols - 1];
			ci = 0;
			mapData = new LinkedHashMap<String, String>();
				for (int j = startCol; j < totalCols; j++){
					mapData.put(getCellData(0, j), getCellData(startRow, j));
					tabArray[ci] = getCellData(0, j) + " =" + getCellData(startRow, j);
					ci++;
				}
		}
		catch (FileNotFoundException e){
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}

		catch (IOException e){
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return(mapData);

	}

	public String getCellData(int rowNum, int colNum) throws Exception {
		try{
			if(sheet.getRow(rowNum).getCell(colNum) != null)
				return sheet.getRow(rowNum).getCell(colNum).toString();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
		return "";
	}

}
