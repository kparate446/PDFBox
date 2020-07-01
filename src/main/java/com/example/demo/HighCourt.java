package com.example.demo;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HighCourt {

	//private static Map<String, Object> mapOfRows;

	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		
		Document caseDetailsDocument = Jsoup.connect("http://karnatakajudiciary.kar.nic.in/websitenew/casedetails/case_details.php")
				.method(Method.POST)
				.timeout(10*10000)
				.data("benchid", "B")
				.data("case_types", "WP")
				.data("case_no", "78")
				.data("case_year", "2020")
				.data("submit","Get Details")
				.data("casedata", "WP 1/2020")
				.execute().parse();
		
		//Map<String, Map<String, Map<String, String>>> mapOfTables = new LinkedHashMap<>();
		Map<String, Object> mapOfTables = new LinkedHashMap<String,Object>();
		String headerString = "";
		List<String> tableHeads = new ArrayList<String>();
		
		Elements rows = caseDetailsDocument.select("div.row");
		for(int i=0; i<rows.size(); i++) {//main row loop
			//System.out.println(rows.get(i));
			if(i > 2 && rows.get(i).hasText()) {//to avoid first 3 records
				
				if(i == 3) {// first header
					headerString = rows.get(i).select("div div").first().text();
				}
				
				else if(rows.get(i).select("center span").hasText()){
					
					headerString = rows.get(i).getElementsByTag("span").first().ownText();
					
					//For 2nd table
					Elements secondAndThirdTable = rows.get(i).select("table");

					for(Element table : secondAndThirdTable) {
					Elements tableRows = table.select("tr");
						
						Object section = mapOfTables.get(headerString);
						
						ArrayList<Map<String, String>> listOfMap = new ArrayList<>();
						if(section != null)
							listOfMap = (ArrayList<Map<String, String>>) section;
						
						for(int m = 0; m < tableRows.size(); m++) {
							Map<String, String> mapOfRowValue = new LinkedHashMap<>();
							
							Elements tableHeaders = tableRows.get(m).select("th");//table headers
							if(!tableHeaders.isEmpty()) {
								tableHeads.clear();//clear the previous headers
								for(int n = 0; n < tableHeaders.size(); n++) {
									if(tableHeaders.get(n).hasText()) {
									tableHeads.add(tableHeaders.get(n).text());
									}
								}
							}
							else {
								Elements tableValues = tableRows.get(m).select("td");
								for(int o = 0; o < tableValues.size(); o++) {
									if(tableValues.get(o).hasText()) {
										mapOfRowValue.put(tableHeads.get(o)	, tableValues.get(o).text());
									}
								}
							}
							listOfMap.add(mapOfRowValue);
							
						}
						section = listOfMap;
						mapOfTables.put(headerString, section);
					}
				}
				
				else {
					Elements tableCaseDetails = rows.get(i).select("table.table");
					
					for(Element table : tableCaseDetails) {
						if(table.hasText()) {
						Elements tableRows = table.select("tr");// 6 or 3
						
						Object section = mapOfTables.get(headerString);
						
						for(int j =0; j < tableRows.size(); j++) {
							
							if(tableRows.get(j).children().size()<6) {
								Map<String, String> mapOfRowValue = new LinkedHashMap<String,String>();
								
								List<Map<String, String>> listOfMap = new ArrayList<Map<String,String>>();
								if(section != null)
									listOfMap = (List<Map<String, String>>) section;
								//listOfMap.clear(); //This is temporary solution work for only one rec
								
								Elements outerTable = tableRows.get(j).children();
								for(int p = 0; p < outerTable.size(); p++) {
									mapOfRowValue.put(tableHeads.get(p), outerTable.get(p).text());
								}
								listOfMap.add(mapOfRowValue);
								section = listOfMap;
							}
							
							else {// with 3 td -key : value
									Map<String, String> sectionMap = new LinkedHashMap<>();
								//List<Map<String, String>> sectionMap = new ArrayList<>();	
								if(section != null)
										sectionMap = (Map<String, String>) section;
								Elements tableCol = tableRows.get(j).select("td");
								for(int k = 0; k < tableCol.size(); k++) {
									//System.out.println(tableCol.get(k).text());
									sectionMap.put(tableCol.get(k).text(), tableCol.get(k+1).text());
									//sectionMap.add(mapOfRowValue);
									k++;
								}
								//sectionMap.add(mapOfRowValue);
								section=sectionMap;
							}
						}
						mapOfTables.put(headerString, section);
					}}
				}
			}
		}
		
		for(Entry<String, Object> map: mapOfTables.entrySet()) {
			
			if(map.getKey().equals("Case Details:")) {
				System.out.println(map.getKey());
				//System.out.println(map.getValue());
				Map<String, String> map1= new LinkedHashMap<>();
				map1 = (Map<String, String>) map.getValue();
				//System.out.println(map1);
				for(Entry<String, String> map2 : map1.entrySet()) {
					if(!map2.getValue().isEmpty())
					System.out.println(map2.getKey() + map2.getValue());
					//System.out.println(map2.getValue());
				}
			}
			
			else{
				System.out.println();
				System.out.println(map.getKey());
				//System.out.println(map.getValue());
				List<Map<String, String>> list = new ArrayList<>();
				list = (List<Map<String, String>>) map.getValue();
				
				for(Map<String, String> mapVal: list) {
					if(!mapVal.isEmpty()) {
						System.out.println(mapVal);
					}
				}
			}
			
		}
	
		}
	}

