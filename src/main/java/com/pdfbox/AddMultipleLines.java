package com.pdfbox;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class AddMultipleLines {
	   public static void main(String args[]) throws IOException {

	      //Loading an existing document
	      File file = new File("C:\\Users\\HP\\Desktop\\ShoppingApp\\PDFBox2020-06-23 02-16-11.pdf");
	      PDDocument doc = PDDocument.load(file);
	       
	      //Creating a PDF Document
	      PDPage page = doc.getPage(1);  
	       
	      PDPageContentStream contentStream = new PDPageContentStream(doc, page); 
	       
	      //Begin the Content stream 
	      contentStream.beginText(); 
	       
	      //Setting the font to the Content stream
	      contentStream.setFont( PDType1Font.TIMES_ROMAN, 16 );
	       
	      //Setting the leading
	      contentStream.setLeading(14.5f);

	      //Setting the position for the line
	      contentStream.newLineAtOffset(25, 725);

	      String text1 = "This is an example of adding text to a page in the pdf document.we can add as many lines";
	      String text2 = "as we want like this using the ShowText()  method of the ContentStream class";

	      //Adding text in the form of string
	      contentStream. showText(text1);
	      contentStream.newLine();
	      contentStream. showText(text2);
	      //Ending the content stream
	      contentStream.endText();

	      System.out.println("Content added");

	      //Closing the content stream
	      contentStream.close();

	      //Saving the document
	      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
			LocalDateTime now = LocalDateTime.now();  
			doc.save("C:\\Users\\HP\\Desktop\\ShoppingApp\\PDFBoxContain"+dtf.format(now)+".pdf");

	      //Closing the document
	      doc.close();
	   }
	}
