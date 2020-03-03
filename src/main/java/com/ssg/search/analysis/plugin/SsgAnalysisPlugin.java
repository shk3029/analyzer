package com.ssg.search.analysis.plugin;

import java.util.HashMap;
import java.util.Map;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

public class SsgAnalysisPlugin extends Plugin implements AnalysisPlugin {

/*  @Override
  public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
    return singletonMap("ssg_tokenizer", SsgTokenizerFactory::new);
  }

  @Override
  public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
    return singletonMap("ssg_analyzer", SsgAnalyzerProvider::new);
  }*/

  @Override
  public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
    Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();


    extra.put("ssg_korean_basic", SsgBasicTokenFilterFactory::new);

    extra.put("ssg_korean_chosung", SsgChosungTokenFilterFactory::new);

    return extra;
  }
}