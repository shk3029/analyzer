package com.ssg.search.analysis.plugin;

import com.ssg.search.analysis.filter.SsgChosungTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class SsgChosungTokenFilterFactory extends AbstractTokenFilterFactory {

  public SsgChosungTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
    super(indexSettings, name, settings);
  }

  @Override
  public TokenStream create(TokenStream tokenStream) {
    return new SsgChosungTokenFilter(tokenStream);
  }
}
