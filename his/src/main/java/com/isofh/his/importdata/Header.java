package com.isofh.his.importdata;

public class Header {
    private String columnName;
    private String linkColumnName;
    private boolean isKey;

    public Header() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getLinkColumnName() {
        return linkColumnName;
    }

    public void setLinkColumnName(String linkColumnName) {
        this.linkColumnName = linkColumnName;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }

    public static Header parse(String fieldName) {
        Header h = new Header();
        fieldName = correctFieldName(fieldName);

        if (fieldName.contains("/k")) {
            h.setKey(true);

            fieldName = fieldName.replace("/k", "");
        }

        if (fieldName.contains("[")) {
            String[] strs = fieldName.replace("]", "").split("\\[");
            h.setColumnName(strs[0]);
            h.setLinkColumnName(strs[1]);
        } else {
            h.setColumnName(fieldName);
        }

        return h;
    }

    private static String correctFieldName(String fieldName) {
        fieldName = fieldName.trim().toLowerCase();
        String[] strs = fieldName.split("_");

        int size = strs.length;
        fieldName = strs[0];
        for (int j = 1; j < size; j++) {
            fieldName += strs[j].substring(0, 1).toUpperCase() + strs[j].substring(1);
        }
        return fieldName;
    }
}
