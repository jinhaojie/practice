package excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Excel {

    /**
     * csv文件输出的目录
     */
    static String DEST_CSV = "C:\\Users\\aihe\\Desktop\\package\\csv\\";

    public static void main(String[] args) {
        //Workbook
        //1 获取文件类型，然后创建workbook
        //2 遍历workbook内的每一行，因为要转换为csv，记得标记一个最大的单元格数目。
        //      初始化maxRowCells = 0，随着遍历将会获得最大的maxRowCells
        //      遍历完整个Excel文件之后，每一行的Excel数据也会获得出来，格式为
        //      列表加有序列表   内部为每一行的数据
        // 3 有了数组，可以直接写入CSV文件

        try {
            // 对文件进行处理，如果是文件夹，则获取文件夹下xls结尾的文件，然后对每一个xls文件进行xls => csv转换

            List<String> dirList = new ArrayList<>();
            // 要处理的excel文件目录
            String sourceFile = "/Users/mac/Desktop/yanghui/";
            File root = new File(sourceFile);
            if (root.isDirectory()) {
                File[] files = root.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return true;
                    }
                });

                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        dirList.add(files[i].getAbsolutePath());
                    }
                }
            }

            List<String> failFiles = new ArrayList<>();
            for (String path : dirList) {
                File file = new File(path);
                if (file.isDirectory()) {
                    File[] files = file.listFiles(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            String lowerCase = name.toLowerCase();
                            if (lowerCase.endsWith(".xls") || lowerCase.endsWith(".xlsx")) {
                                return true;
                            }
                            return false;
                        }
                    });

                    List<File> fileList = Arrays.asList(files);

//                    fileList.sort(new Comparator<File>() {
//                        @Override
//                        public int compare(File o1, File o2) {
//                            int o1num = Integer.valueOf(o1.getName().split("\\.")[1]);
//                            int o2num = Integer.valueOf(o2.getName().split("\\.")[1]);
//                            if (o1num > o2num) {
//                                return 1;
//                            } else if (o1num < o2num) {
//                                return -1;
//                            } else {
//                                return 0;
//                            }
//                        }
//
//                    });

                    for (File f : fileList) {

//                    System.out.println(files[i].getName());
                        try {

                            excelToCsv(f);
                        } catch (Exception e) {
                            failFiles.add(getFileNmme(f));
                        }
                    }
                }
            }
            System.out.println("解析失败的文件" + "," + failFiles.toString());



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 将xls结尾的文件转换为csv文件，注意次函数不处理csv结尾的文件，使用时需注意
     *
     * @param sourceFile
     * @throws IOException
     */
    private static void excelToCsv(File file) throws IOException {
        String sourceFile = file.getAbsolutePath();


        // 1. 获取文件的workbook对象
        Workbook workbook = getWorkBook(
                sourceFile);
        // 默认从0开始
        Sheet sheet = workbook.getSheetAt(0);

        //2. 获取数据与判断最大行长度
        List<List> rowCollection = new LinkedList<>();
//        int maxRowCells = getMaxRowCellsAndFillData2(getFileNmme(file), sheet, rowCollection);
        int maxRowCells = getMaxRowCellsAndFillData(getFileNmme(file), sheet, rowCollection);

//        // 3. 写CSV
////        File sourceFileObject = new File(sourceFile);
//        // TODO 文件名不要有xls或者xlsx
//        String fileName = DEST_CSV + new File(sourceFile).getName().replaceAll("xls","csv").replaceAll("xlsx","csv");
//        writeIntoCsvFile(rowCollection, maxRowCells, fileName);
    }

    private static String getFileNmme(File file) {

        return file.getParentFile().getName() + "/" + file.getName();
    }

    private static int getMaxRowCellsAndFillData(String fileName, Sheet sheet, List<List> rowCollection) {
        int maxRowCells = 0;

        StringBuilder sb = new StringBuilder();
        int start = 58;
        Cell startCell = null;
        for (int i = start; i < start+5; i++) {
            Row sheetRow58 = sheet.getRow(i);
            startCell = sheetRow58.getCell(2);
            String temp = getStringCellValue(startCell);
            if (temp.endsWith("修理修配劳务")) {
                start = i;
                break;
            }
        }
        Row sheetRow58 = sheet.getRow(start);
        startCell = sheetRow58.getCell(14);
        sb.append(getStringCellValue(startCell)).append(",");

        Row sheetRow59 = sheet.getRow(start + 1);

        sb
                .append(getStringCellValue(sheetRow59.getCell(14))).append(",");

        ;

        Row sheetRow63 = sheet.getRow(start + 4);
        sb
                .append(getStringCellValue(sheetRow63.getCell(14))).append(",")
        ;
        Row sheetRow70 = sheet.getRow(start + 11);
        sb
                .append(getStringCellValue(sheetRow70.getCell(14))).append(",")
        ;

        sb.append(getStringCellValue(sheetRow59.getCell(16))).append(",")
                .append(getStringCellValue(sheetRow59.getCell(17))).append(",");
        System.out.println(fileName + "," + sb.toString());

        return maxRowCells;
    }
    private static int getMaxRowCellsAndFillData2(String fileName, Sheet sheet, List<List> rowCollection) {
        int maxRowCells = 0;

        StringBuilder sb = new StringBuilder();

        Row sheetRow10 = sheet.getRow(10);
        sb.append(getStringCellValue(sheetRow10.getCell(10))).append(",");
        sb.append(getStringCellValue(sheetRow10.getCell(19))).append(",");

        Row sheetRow59 = sheet.getRow(14);

        sb
                .append(getStringCellValue(sheetRow59.getCell(9))).append(",")
        ;

        System.out.println(fileName + "," + sb.toString());

        return maxRowCells;
    }

    private static String getStringCellValue(Cell cell) {
        String result = "";
        if (cell == null) {
            return "";
        }

        if (cell.getCellType().equals(CellType.NUMERIC)) {
            result = String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCellType().equals(CellType.STRING)) {
            result = cell.getStringCellValue().replace(",", "");
            result = result.replace(" ", "").replaceAll("[\\t\\n\\r]", "");
        }
        return result;
    }

    private static Workbook getWorkBook(String s) throws IOException {
        if (s.endsWith("xls")) {
            return new HSSFWorkbook(new FileInputStream(s));
        }else if (s.endsWith("xlsx")){
            return new XSSFWorkbook(new FileInputStream(s));
        }
        return null;
    }

}
