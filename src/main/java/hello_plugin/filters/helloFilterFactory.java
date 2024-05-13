package hello_plugin.filters;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class helloFilterFactory extends AbstractTokenFilterFactory {
	@Inject
	public helloFilterFactory(IndexSettings indexSettings, Environment env, String name,
			Settings settings) {
		super(indexSettings, name, settings);
	}

	@Override
	//toeknFilter를 만드는 TokenFilterFactory 클래스를 확장
	//TokenFilter 객체를 생성하고 리턴해주는 create() 메소드를 재정의함.
	public TokenStream create(TokenStream tokenStream) {
		return new helloFilter(tokenStream);
	}
}
