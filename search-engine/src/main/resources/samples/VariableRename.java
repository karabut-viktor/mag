package samples;

import StrBuilder;

public class VariableRename {
  public static String a(String str, String middle, int length) {
    if (isEmpty(str) || isEmpty(middle)) {
        return str;
    }
  
    if (length >= str.length() || length < (middle.length()+2)) {
        return str;
    }

    int targetSting = length-middle.length();
    int startOffset = targetSting/2+targetSting%2;
    int endOffset = str.length()-targetSting/2;
    
    StrBuilder builder = new StrBuilder(length);
    builder.append(str.substring(0,startOffset));
    builder.append(middle);
    builder.append(str.substring(endOffset));
    
    return builder.toString();
  }
  
  public static String b(String renamed, String middle, int length) {
    if (isEmpty(renamed) || isEmpty(middle)) {
        return renamed;
    }
  
    if (length >= renamed.length() || length < (middle.length()+2)) {
        return renamed;
    }

    int targetSting = length-middle.length();
    int startOffset = targetSting/2+targetSting%2;
    int endOffset = renamed.length()-targetSting/2;
    
    StrBuilder builder = new StrBuilder(length);
    builder.append(renamed.substring(0,startOffset));
    builder.append(middle);
    builder.append(renamed.substring(endOffset));
    
    return builder.toString();
  }
}
