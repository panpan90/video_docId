package com.sohu.mrd.test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.sohu.mrd.videoDocId.utils.FileKit;
import com.sohu.mrd.videoDocId.utils.MapKit;
/**
 * @author Jin Guopan
   @creation 2016年12月26日
 */
public class Testreport {
	public static void main(String[] args) {
		List<String> list= FileKit.read2List("data/newredisResult_2016_12_26_1");
		System.out.println("list "+list.size());
		HashSet<String> docIdset = new HashSet<String>();
		HashSet<String> urlSet = new HashSet<String>();
		HashSet<String> titleSet = new HashSet<String>();
		List<String> docIdList = new ArrayList<String>();
		List<String> urlList = new ArrayList<String>();
		List<String> titleList = new ArrayList<String>();
		for(int i=0;i<list.size();i++)
		{
			String s=list.get(i);
			String[] ss = s.split("\t", -1);
			String docId=ss[0];
			String url=ss[1];
			String title=ss[2];
			docIdset.add(docId);
			docIdList.add(docId);
			urlSet.add(url);
			urlList.add(url);
			titleSet.add(title);
			titleList.add(title);
		}
		Map<String, Integer>  map=MapKit.wordCountsort(docIdList);
		System.out.println("map "+map);
		System.out.println("docIdset "+docIdset.size());
		System.out.println("urlSet "+urlSet.size());
		System.out.println("titleSet "+titleSet.size());
	}
}
