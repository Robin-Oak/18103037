package com.robin;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static com.robin.Main.Test.isValid;

public class Main {

    public static void main(String[] args) throws IOException {
        Set<String> completed = new HashSet<>();
        Queue<String> todo = new PriorityQueue<>();
        System.out.println("Enter link of base website");
        String url;
        Scanner obj = new Scanner(System.in);
        url = obj.nextLine();
        todo.add(url);

        XSSFWorkbook thingie = new XSSFWorkbook();
        XSSFSheet site_text = thingie.createSheet(" all text from link ");
        XSSFSheet spreadsheet = thingie.createSheet(" a tags information ");
        XSSFSheet spreadsheetFaculty = thingie.createSheet(" faculty information ");
        XSSFRow row;

        Map<String, Object[]> gotten = new TreeMap<>();
        gotten.put("1", new Object[]{"link", "a tag name"});

        int tillnow = 2;
        int site_textRow = 0;
        int spreadsheetFacultyRow = 0;
        while (todo.size() != 0 && completed.size() < 1) {
            System.out.println("Processing...");
            url = todo.poll();
            if (!isValid(url) || !url.contains("pec.ac.in"))
                continue;
            Document doc;
            Elements links;
            String text;
            try {
                doc = Jsoup.connect(url).get();
                links = doc.select("a[href]");
            } catch (Exception e) {
                continue;
            }
            System.out.println(links.size());
            for (Element link : links) {
                String newUrl = "";

                if (!isValid(link.attr("href"))) {
                    newUrl = "https://pec.ac.in/" + link.attr("href");
                    if (!isValid(newUrl)) continue;
                }
                System.out.println(newUrl);
                todo.add(newUrl);
                gotten.put(Integer.toString(tillnow++), new Object[]{newUrl, link.text()});
                try {
                    text = Jsoup.connect(newUrl).get().body().text();
                    row = site_text.createRow(site_textRow++);
                    Cell cell = row.createCell(0);
                    cell.setCellValue(newUrl);
                    cell = row.createCell(1);
                    cell.setCellValue(text);
                } catch (Exception e) {
                    System.out.println("not a valid url");
                }

                if (link.toString().contains("faculty")) {
                    try {
                        Document faculty = Jsoup.connect(newUrl).get();
                        String facultyInfo = faculty.getElementsByClass("panel-body").not("col-md-10").text();
                        row = spreadsheetFaculty.createRow(spreadsheetFacultyRow++);
                        Cell cell = row.createCell(0);
                        cell.setCellValue(link.attr("href").replace("faculty", ""));
                        row = spreadsheetFaculty.createRow(spreadsheetFacultyRow++);
                        cell = row.createCell(1);
                        cell.setCellValue(facultyInfo);
                        spreadsheetFacultyRow++;
                    } catch (Exception e) {
                        System.out.println("not valid url");
                    }
                }
            }
            completed.add(url);
            System.out.println(completed.size());

        }
        Set<String> keyid = gotten.keySet();
        int rowid = 0;
        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objarray = gotten.get(key);
            int cellid = 0;

            for (Object obj : objarray) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }
        FileOutputStream finalle = new FileOutputStream(new File("C:/Users/hp/Desktop/WebCrawler_assg3.xlsx"));

        thingie.write(finalle);
        finalle.close();
        System.out.println("WebCrawler_assg3.xlsx written successfully");
    }

    static class Test {
        
        public static boolean isValid(String url) {
            
            try {
                new URL(url).toURI();
                return true;
            }
			
            catch (Exception e) {
                return false;
            }
        }
    }
}
