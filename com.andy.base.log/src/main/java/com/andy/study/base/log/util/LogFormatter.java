package com.andy.study.base.log.util;

import java.text.SimpleDateFormat;

public final class LogFormatter {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static final String FIELD_SPLIT = "\t";

    /**
     * 去掉换行
     *
     * @param orgText
     * @return
     */
    public static String removeNewLine(String orgText) {
        if (orgText == null || orgText.equals("")) {
            return "";
        }
        return orgText.replaceAll("\n|\r\n","#");
    }

    /**
     * 清除缩进
     * @param orgText
     * @return
     */
    public static String removeTab(String orgText) {
        if (orgText == null || orgText.equals("")) {
            return "";
        }
        return orgText.replace('\t', ' ');
    }
}

