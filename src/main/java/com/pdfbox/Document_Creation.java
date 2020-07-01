package com.pdfbox;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;

public class Document_Creation {
    
	   public static void main (String args[]) throws IOException {
	       
	      //Creating PDF document object 
	      PDDocument document = new PDDocument();    
	       
	      //Saving the document
	      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
			LocalDateTime now = LocalDateTime.now();  
			document.save("C:\\Users\\HP\\Desktop\\ShoppingApp\\PDFBox"+dtf.format(now)+".pdf");
	         
	      System.out.println("PDF created");  
	    
	      //Closing the document  
	      document.close();

	   }  
	}
