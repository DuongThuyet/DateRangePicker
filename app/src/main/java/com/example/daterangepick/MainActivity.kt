package com.example.daterangepick

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.savvi.rangedatepicker.CalendarPickerView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextYear = Calendar.getInstance()
        nextYear.add(Calendar.YEAR, 10)

        val lastYear = Calendar.getInstance()
        lastYear.add(Calendar.YEAR, -10)

        val list = ArrayList<Int>(1)

        calendar.deactivateDates(list)
        val arrayList = mutableListOf<Date>()
        try {
            val dateformat = SimpleDateFormat("dd-MM-yyyy")
            val strdate = "22-2-2018"
            val strdate2 = "26-2-2018"
            val newdate = dateformat.parse(strdate)
            val newdate2 = dateformat.parse(strdate2)
            arrayList.add(newdate)
            arrayList.add(newdate2)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        calendar.init(lastYear.getTime(), nextYear.getTime(), SimpleDateFormat("MMMM, YYYY", Locale.getDefault())) //
            .inMode(CalendarPickerView.SelectionMode.RANGE) //
            .withSelectedDate(Date())
            .withDeactivateDates(list)
            .withHighlightedDates(arrayList)
    }
}
