package com.bridgelabz;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPdf {
	public static void main(String[] args) throws Exception, IOException {
		//We load a PDF document from the src/main/resources directory
		File myFile = new File("C:\\Users\\HP\\Desktop\\Stream - Java 8 Features.pdf");
		try (PDDocument doc = PDDocument.load(myFile)){
			//PDFTextStripper is used to extract text from the PDF file.
			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(doc);
			System.out.println();
			System.out.println("Text size: " + text.length() + " characters:");
			System.out.println(text);
		}
	}
}
