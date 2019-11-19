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
        val lstHighlightedDates = mutableListOf<Date>()
        val currentCal = Calendar.getInstance()
        val currentCalStr = SimpleDateFormat("dd-MM-yyyy").format(currentCal.time)

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

        val instance = Calendar.getInstance()
        instance.add(Calendar.DATE, -10)
        val startCal = instance.clone() as Calendar
        var startCalStr = SimpleDateFormat("dd-MM-yyyy").format(startCal.time)
        while (startCalStr != currentCalStr) {
            lstHighlightedDates.add(startCal.time)
            startCal.add(Calendar.DATE, 1)
            startCalStr = SimpleDateFormat("dd-MM-yyyy").format(startCal.time)
        }

        val minStartDate = Calendar.getInstance()
        minStartDate.add(Calendar.DATE, 2)

        val minEndDate = Calendar.getInstance()
        minEndDate.add(Calendar.DATE, 5)

        calendar.init(
            minStartDate.time,
            nextYear.time,
            SimpleDateFormat("MMMM, YYYY", Locale.getDefault())
        ) //
            .inMode(CalendarPickerView.SelectionMode.RANGE) //
            .withSelectedDate(minStartDate.time)
//            .withDeactivateDates(list)
//            .withHighlightedDates(lstHighlightedDates)
    }
}
