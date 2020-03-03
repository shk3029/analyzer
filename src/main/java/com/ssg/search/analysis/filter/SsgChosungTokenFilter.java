package com.ssg.search.analysis.filter;

import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;

public class SsgChosungTokenFilter extends TokenFilter {

  public SsgChosungTokenFilter(TokenStream tokenStream) {
    super(tokenStream);
  }

  @Override
  public boolean incrementToken() throws IOException {
    return false;
  }
}
