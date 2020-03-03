package com.ssg.search.analysis.autocomplete.parser;

import static com.ssg.search.analysis.autocomplete.info.KoreanUnicodeInfo.START_KOREA_UNICODE;
import static com.ssg.search.analysis.autocomplete.info.KoreanUnicodeInfo.UNICODE_CHO_SUNG;
import static com.ssg.search.analysis.autocomplete.info.KoreanUnicodeInfo.UNICODE_JONG_SUNG;
import static com.ssg.search.analysis.autocomplete.info.KoreanUnicodeInfo.UNICODE_JONG_SUNG_COUNT;
import static com.ssg.search.analysis.autocomplete.info.KoreanUnicodeInfo.UNICODE_JUNG_SUNG;
import static com.ssg.search.analysis.autocomplete.info.KoreanUnicodeInfo.UNICODE_JUNG_SUNG_COUNT;

public abstract class KoreanParser {

  /** 토큰을 자음/모음으로 파싱 */
  public String parse(String token) {

    if(token == null || token.isBlank()) {
      return "";
    }

    StringBuilder result = new StringBuilder();

    char[] charArray = token.toCharArray();
    for(char ch: charArray) {
      char index = (char)(ch - START_KOREA_UNICODE);
      // 한글 유니코드 범위 : 0xAC00 ~ 0xD7AF (11184개)
      if(index >= 0 && index <= 11184) {
        //초성
        int chosungIndex = index / (UNICODE_JONG_SUNG_COUNT * UNICODE_JUNG_SUNG_COUNT);
        char chosung = UNICODE_CHO_SUNG[chosungIndex];
        // 중성
        int jungsungIndex = index % (UNICODE_JONG_SUNG_COUNT * UNICODE_JUNG_SUNG_COUNT) / UNICODE_JONG_SUNG_COUNT;
        char jungsung = UNICODE_JUNG_SUNG[jungsungIndex];
        // 종성
        int jongsungIndex = index % (UNICODE_JONG_SUNG_COUNT * UNICODE_JUNG_SUNG_COUNT) % UNICODE_JONG_SUNG_COUNT;
        char jongsung = UNICODE_JONG_SUNG[jongsungIndex];

        processForKoreanChar(result, chosung, jungsung, jongsung);
      } else {
        processForOther(result, ch);
      }
    }
    return result.toString();
  }


  protected abstract void processForKoreanChar(StringBuilder sb, char chosung, char jungsung, char jongsung);


  protected abstract void processForOther(StringBuilder sb, char eachTocken);
}
