package com.ssg.search.analysis.autocomplete.parser;

public class KoreanChosungParser extends KoreanParser {

  @Override
  protected void processForKoreanChar(StringBuilder sb, char chosung, char jungsung, char jongsung) {
    sb.append(chosung);
  }

  @Override
  protected void processForOther(StringBuilder sb, char eachTocken) {
    sb.append(eachTocken);
  }
}
