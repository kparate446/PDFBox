package com.bridgelabz;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.common.PDMetadata;

public class MetadataRead {
	public static void main(String[] args) throws IOException {

        File myFile = new File("C:\\Users\\HP\\Desktop\\ShoppingApp\\metadata.pdf");

        try (PDDocument doc = PDDocument.load(myFile)) {
            
            PDDocumentCatalog catalog = doc.getDocumentCatalog();
            PDMetadata metadata = catalog.getMetadata();
            
            if (metadata == null) {
                
                System.err.println("No metadata in document");
                System.exit(1);
            }

            try (InputStream is = metadata.createInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr)) {
                
                br.lines().forEach(System.out::println);
            }
        }
    }
}
