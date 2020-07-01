package com.bridgelabz;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class CreateImage {
	public static void main(String[] args) throws Exception {
		try (PDDocument doc = new PDDocument()) {
			PDPage myPage = new PDPage();
			doc.addPage(myPage);
			String imgFileName = "C:\\Users\\HP\\Desktop\\Logo\\krunal.jpg";
			PDImageXObject pdImage = PDImageXObject.createFromFile(imgFileName, doc);
			
			int iw = pdImage.getWidth();
			int ih = pdImage.getHeight();
			
			float offset = 20f;
			
			try(PDPageContentStream cont = new PDPageContentStream(doc, myPage)){
				cont.drawImage(pdImage, offset, offset, iw, ih);
			}
			doc.save("C:\\Users\\HP\\Desktop\\Image.pdf");
		}
	}
}
