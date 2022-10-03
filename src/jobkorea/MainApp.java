package jobkorea;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {

	private static final String URL = "http://www.jobkorea.co.kr/Search/?";
	
	public static void main(String[] args) throws IOException {
		String keyWord = "jquery";
		System.out.println("URL :: " + URL + getParameter(keyWord, 1));
		//1. Document�� �����´�.
		Document doc = Jsoup.connect(URL + getParameter(keyWord, 1)).get();
//		System.out.println("doc = " + doc);
		
		//2. ����� �����´�.
//		System.out.println("" + doc.toString());
		Elements elements = doc.select(".lists .lists-cnt .list-default li");
		
		//3. ���(�迭)���� ������ �����´�.
		int idx = 0;
//		for(Element element : elements) {
//
//			System.out.println(++idx + " : " + element.text());
//			System.out.println("==========================================\n\n");
//		}
		int idx1 = 0;
		for (int i=0; i<10;i++){
			Document doc1 = Jsoup.connect(URL + getParameter(keyWord, 1)).get();
			Elements elements1 = doc1.select(".lists .lists-cnt .list-default li");
			for(Element element : elements1) {
				System.out.println(++idx + " : " + element.text());
				System.out.println("==========================================\n\n");
			}
		}
	}

	
	/**
	 * URL �ϼ�
	 * @param keyWord
	 * @param page
	 * @return
	 */
	public static String getParameter(String keyWord, int page) {
		return "stext=" + keyWord + ""
				      + "&tabType=recruit"
				      + "&Page_No=" + page + "";
//				      + "&IsCoInfoSC=false"
////				      + "&IsRecruit=false"
//				      + "&ord=1"
//				      + "&Order=1"
//				      + "&page=" + page + ""
//				      + "&pageSize=100"
//				      + "&pageType=HRP";
	}
	
}
