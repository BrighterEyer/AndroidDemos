package com.bean;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by bluedragon on 18-1-31.
 */
@DatabaseTable(tableName = "student")
public class Student {
    @DatabaseField(columnName = "_id", dataType = DataType.INTEGER, generatedId = true)
    private int id;
    @DatabaseField(columnName = "name", dataType = DataType.STRING, canBeNull = false)
    private String name;
    @DatabaseField(columnName = "age", dataType = DataType.INTEGER, canBeNull = true)
    private int age;
}
