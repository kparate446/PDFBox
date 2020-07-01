package com.bridgelabz;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class WritePdf {
	public static void main(String[] args) throws Exception {
		// A new PDDocument is created. By default, the document has an A4 format.
		try( PDDocument doc = new PDDocument()){
			//A new page is created and added to the document
			PDPage myPage = new PDPage();
			doc.addPage(myPage);
			//To write to a PDF page, we have to create a PDPageContentStream object
			try(PDPageContentStream cont = new PDPageContentStream(doc, myPage)){
				cont.beginText();//Text is written betweeen beginText() methods.
				//We set the font and text leading.
				cont.setFont(PDType1Font.TIMES_ROMAN, 12);
				cont.setLeading(14.5f);
				//We start a new line of text with newLineAtOffset() method. The origin of a page is at the bottom-left corner
				cont.newLineAtOffset(25, 700);
				//The text is written with showText() method
				String line = "Hello World";
				cont.showText(line);
				//With the newLine() method, we move to the start of the next line of text
				cont.newLine();

				cont.endText();//Text is written betweeen endText() methods.
				cont.close();// Stream must be closed before saving document.
			}

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
			LocalDateTime now = LocalDateTime.now();  
//			System.out.println(dtf.format(now));     

			doc.save("C:\\Users\\HP\\Desktop\\ShoppingApp\\HelloWorld"+dtf.format(now)+".pdf");
		}
	}
}
