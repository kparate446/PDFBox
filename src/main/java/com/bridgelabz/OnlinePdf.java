package com.bridgelabz;

import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class OnlinePdf  {
	public static void main(String[] args) {
		final String address = "http://www.africau.edu/images/default/sample.pdf";
		try {
			final URL url = new URL(address);
			final PDDocument pdDocument = PDDocument.load(url.openStream());
			final PDFTextStripper stripper = new PDFTextStripper();
			final String pdfText = stripper.getText(pdDocument);
			System.out.println("Parsed text size is " + pdfText.length() + " characters:");
			System.out.println(pdfText);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

