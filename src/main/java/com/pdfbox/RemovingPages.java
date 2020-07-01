package com.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class RemovingPages {

	   public static void main(String args[]) throws IOException {

	      //Loading an existing document
	      File file = new File("C:\\Users\\HP\\Desktop\\ShoppingApp\\PDFBox2020-06-23 02-16-11.pdf");
	      PDDocument document = PDDocument.load(file);
	       
	      //Listing the number of existing pages
	      int noOfPages= document.getNumberOfPages();
	      System.out.println(noOfPages);
	       
	      //Removing the pages
	      document.removePage(2);
	      
	      System.out.println("page removed");

	      //Saving the document
	      document.save("C:\\Users\\HP\\Desktop\\ShoppingApp\\PDFBox2020-06-23 02-16-11.pdf");

	      //Closing the document
	      document.close();

	   }
	}
