package hello_plugin.filters;


import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import hello_plugin.filters.helloFilter;
import hello_plugin.filters.helloFilterFactory;

public class helloPlugin extends Plugin implements AnalysisPlugin {

	@Override
	public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
		Map<String, AnalysisProvider<TokenFilterFactory>> extra = new HashMap<String, AnalysisProvider<TokenFilterFactory>>();
		extra.put("hello_filter", helloFilterFactory::new);
		return extra;
	}
	
	
}
