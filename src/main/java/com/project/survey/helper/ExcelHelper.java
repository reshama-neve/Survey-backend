package com.project.survey.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.project.survey.model.Response;
import com.project.survey.model.Survey;
import com.project.survey.repo.ResponseRepo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelHelper {
    public static String TYPE = "application/vnd.openmosix-officiated.spreadsheet.sheet";
    static String[] Column = { "Survey Name", "First Name", "Last Name", "Question ", "Answer1", "Answer2",
                               "Answer3", "Answer4"
                             };

    static String SHEET = "Responses";

    public static ByteArrayInputStream responseToExcel(List<Response> response) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);




            // Header
            Row headerRow = sheet.createRow(1);


            for (int col = 0; col < Column.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(Column[col]);
            }
            int rowIdx = 2;
            for (Response responses : response) {

                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue((responses.getSurvey().getName()));
                row.createCell(1).setCellValue(responses.getUser().getFirst_name());
                row.createCell(2).setCellValue(responses.getUser().getLast_name());
                row.createCell(3).setCellValue(responses.getQuestion().getQuestion_text());
//                row.createCell(2).setCellValue(responses.getResponse_id());
                row.createCell(4).setCellValue(responses.getAnswer1());
                row.createCell(5).setCellValue(responses.getAnswer2());
                row.createCell(6).setCellValue(responses.getAnswer3());
                row.createCell(7).setCellValue(responses.getAnswer4());
//                row.createCell(6).setCellValue(responses.getQuestion().getQuestion_id());
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
//            sheet.autoSizeColumn(7);



            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
