package com.rumo.util;
public class LevelUtil {

    public final static String SEPARATOR = ".";

    public final static String ROOT = "0";

    // 0
    // 0.1
    // 0.1.2
    // 0.1.3
    // 0.4
    public static String calculateLevel(String parentLevel, int parentId) {
        if (StringUtil.isBlank(parentLevel)) {
            return ROOT;
        } else {
            return StringUtil.join(parentLevel, SEPARATOR, parentId);
        }
    }
}