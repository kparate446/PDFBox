package com.bridgelabz;

import java.util.Calendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

public class DocumentInformation {
	public static void main(String[] args) throws Exception {
		try(PDDocument doc = new PDDocument()){
			PDPage myPage = new PDPage();
			doc.addPage(myPage);
			
			PDDocumentInformation pdi = doc.getDocumentInformation();
			
			pdi.setAuthor("Bridgelabz");
			pdi.setTitle("World war II");
			pdi.setCreator("Java code");
			
			Calendar date = Calendar.getInstance();
			System.out.println(date);
			pdi.setCreationDate(date);
			pdi.setModificationDate(date);
			
			pdi.setKeywords("World war II, conflict, Allies,Axis powers");
			doc.save("C:\\Users\\HP\\Desktop\\DocumentInformation1.pdf");
		}
	}
}
