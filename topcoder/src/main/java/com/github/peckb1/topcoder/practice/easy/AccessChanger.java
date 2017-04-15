package com.github.peckb1.topcoder.practice.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * You are converting old code for a new compiler version. Each "->" string should be replaced by ".",
 * but this replacement shouldn't be done inside comments. A comment is a string that starts with "//"
 * and terminates at the end of the line.
 * <p>
 * You will be given a program containing the old code. Return a containing the converted version of the code.
 */
public class AccessChanger {

    private static final String COMMENT = "//";
    private static final String OLD_FORMAT = "->";
    private static final String NEW_FORMAT = ".";

    public String[] convert(String[] program) {
        return Arrays.stream(program).map(line -> {
            StringBuilder sb = new StringBuilder();
            label:
            for (int i = 0; i < line.length() - 1; i++) {
                String substring = line.substring(i, i + OLD_FORMAT.length());
                switch (substring) {
                    case COMMENT:
                        sb.append(line.substring(i, line.length() - 1));
                        break label;
                    case OLD_FORMAT:
                        sb.append(NEW_FORMAT);
                        i++;
                        break;
                    default:
                        sb.append(line.charAt(i));
                        break;
                }
            }
            sb.append(line.charAt(line.length() - 1));
            return sb.toString();
        }).collect(Collectors.toList()).toArray(new String[program.length]);
    }

}
