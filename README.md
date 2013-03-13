AndroidSimpleBinding
====================

Bind object properties into ListView elements

Usage
-----

1. Create layout for row
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent">
    <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="New Text"
            android:id="@+id/name"
            />

    <TextView
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="New Text"
            android:id="@+id/value"/>
</LinearLayout>
```

2. Class to hold data
```java
public class MItem {
    public String name;
    public String value;
    public MItem(String aName, String aValue){
        name = aName;
        value = aValue;
    }
    public String getValue() {
        return value;
    }
    public String getName() {
        return name;
    }
}
```

3. In Activity
```java
ListView lv = (ListView) findViewById(R.id.mylist);
ArrayList<Object> values = new ArrayList<Object>();
values.add(new MItem("Name1", "Value1"));
values.add(new MItem("Name2", "Value2"));
BindingArrayAdapter adapter = new BindingArrayAdapter(this, values, R.layout.rowlayout);
lv.setAdapter(adapter);
```
