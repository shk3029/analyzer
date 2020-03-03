package com.ssg.search.analysis.autocomplete.parser;

import static com.ssg.search.analysis.autocomplete.info.KoreanUnicodeInfo.UNICODE_JONG_SUNG_EMPTY;

public class KoreanBasicParser extends KoreanParser {

  @Override
  protected void processForKoreanChar(StringBuilder sb, char chosung, char jungsung, char jongsung) {
    sb.append(chosung).append(jungsung);
    if (jongsung != UNICODE_JONG_SUNG_EMPTY) {
      sb.append(jongsung);
    }
  }

  @Override
  protected void processForOther(StringBuilder sb, char eachTocken) {
    sb.append(eachTocken);
  }
}
