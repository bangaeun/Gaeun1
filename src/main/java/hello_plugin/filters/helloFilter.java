package hello_plugin.filters;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

 //TokenFilter를 확장하는 클래스를 정의
public class helloFilter extends TokenFilter {  

	private final CharTermAttribute charAttr;
	
	public helloFilter(TokenStream input) {
		super(input);
		//jamoUtil = new JamoUtil();
		charAttr = addAttribute(CharTermAttribute.class);
	}
	
	//핵심인 incrementToken()메소드, lucene은 KeywordTokenizer, StandardTokenizer등 여러 토크나이저 클래스를 지원함.
	//토크나이즈가 되면 TokenStream이 생성됨.
	//TokenStream은 분석된 토큰들을 가지고 있음.
	public final boolean incrementToken() throws IOException {
		if (input.incrementToken()) {
		//	String chosung = jamoUtil.chosung(charAttr.toString());
		//	charAttr.setEmpty().append(chosung);
			
			String hello = "hello";
			charAttr.setEmpty().append(hello);
			return true;
		}

		return false;
	}
	
}
