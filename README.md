Date Range Picker 
===================
Date Range Picker is a Calendar Picker View to show a Customized Date Range Picker with improved UI

Usage
-----
* 1. Add Calendar Picker View to XML

```xml
<com.savvi.rangedatepicker.CalendarPickerView
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/calendar_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        android:paddingBottom="16dp"
        android:scrollbarStyle="outsideOverlay"
        android:clipToPadding="false"
        app:tsquare_dividerColor="@color/transparent"
        app:tsquare_headerTextColor="@color/custom_header_text"
        /> 
 ```
 
* 2. Initialize it in Java Class
      
```java
calendar = (CalendarPickerView) findViewById(R.id.calendar_view);

        calendar.init(lastYear.getTime(), nextYear.getTime()) //
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(new Date())
// deactivates given dates, non selectable
                .withDeactivateDates(list)
// highlight dates in red color, mean they are aleady used.
                .withHighlightedDates(arrayList);
 
```
 * There are other Selection modes also SINGLE and MULTIPLE
 * Adding Deactivated Dates
  User wont able to select these dates they will be deactivated.
  for eg, if you dont want to provide services on Saturday and Sunday you can mark them deactivated in that case the date text color wil be grey..
  
 * You can aslo specify the month header by passing SimpleDateFormat object in constructor
   For eg. if we want to display year

```java

calendar.init(lastYear.getTime(), nextYear.getTime(), new SimpleDateFormat("MMMM, YYYY", Locale.getDefault()));

 ``` 
 
 * Getting Selected Dates
You can get selected dates with the below function call when your user click finish or next button (which will you implement).

```java

calendar.getSelectedDates()

 ``` 

