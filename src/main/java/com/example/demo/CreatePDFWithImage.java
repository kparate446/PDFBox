package com.example.demo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class CreatePDFWithImage {

	public static void main(String[] args) {

		String fileName = "C:\\Users\\HP\\Desktop\\KrunalResume.pdf";
		String imageName = "BeingCoders_com.jpg";

		try {

			PDDocument doc = new PDDocument();
			// System.out.println(doc);
			PDPage page = new PDPage();
			// System.out.println(page);
			doc.addPage(page);

			// PDXObjectImage image = new PDJpeg(doc, new FileInputStream(imageName));

			PDPageContentStream content = new PDPageContentStream(doc, page);
//			System.out.println(content);
			// content.drawImage(image, 180, 700);

			content.close();
			 System.out.println(fileName);
			doc.save(fileName);

			doc.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
