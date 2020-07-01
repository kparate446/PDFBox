package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDMetadata;

public class MetadataWrite {
	public static void main(String[] args) throws IOException {

        try (PDDocument doc = new PDDocument()) {

            PDPage myPage = new PDPage();

            File myFile = new File("C:\\Users\\HP\\Desktop\\ShoppingApp\\metadata.xml");
            
            try (InputStream is = Files.newInputStream(myFile.toPath())) {
                
                PDMetadata meta = new PDMetadata(doc, is);
                
                PDDocumentCatalog catalog = doc.getDocumentCatalog();
                catalog.setMetadata(meta);
//                System.out.println();
                
                doc.addPage(myPage);
            }
            
            doc.save("C:\\Users\\HP\\Desktop\\ShoppingApp\\metadata.pdf");
        }
    }
}
