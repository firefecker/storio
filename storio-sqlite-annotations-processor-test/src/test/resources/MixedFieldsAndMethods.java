package com.pushtorefresh.storio3.sqlite.annotations;

@StorIOSQLiteType(table = "table")
public class MixedFieldsAndMethods {

    @StorIOSQLiteColumn(name = "id", key = true)
    long id;

    @StorIOSQLiteColumn(name = "name")
    String name() {
        return "name";
    }
}