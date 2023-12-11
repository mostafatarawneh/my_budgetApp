package com.mostafa.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.ScrollView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var et_income: TextInputEditText
    lateinit var tablelayout2: TableLayout
    lateinit var tv_personal: TextView
    lateinit var tv_invasment: TextView
    lateinit var tv_commit: TextView
    lateinit var listview: ListView
    lateinit var scrollview: ScrollView
    lateinit var scrollview_years: ScrollView
    lateinit var calcButton: Button
    lateinit var shared_prf: SharedPreferences
    lateinit var shared_prfEditor: SharedPreferences.Editor
    lateinit var tablelayout_years: TableLayout


    var divdedIncome = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intialViews()



        val df = DecimalFormat(".00")



        calcButton.setOnClickListener() {

            createRow(df)//this is inflate new row every click
            createYearsRow(df)


        }


    }

    //Todo: هون لازم تخلي التطبيق يحفظ البيانات كامله

    private fun createRow(df: DecimalFormat) {
        try {
            val tablerow = LayoutInflater.from(this).inflate(R.layout.table_row, null) as TableRow



            tablerow.findViewById<TextView>(R.id.firstTextView)
                .setText(df.format(et_income.text.toString().toDouble().div(3)))
            tablerow.findViewById<TextView>(R.id.secTextView)
                .setText(df.format(et_income.text.toString().toDouble().div(3)))
            tablerow.findViewById<TextView>(R.id.thirdTextView)
                .setText(df.format(et_income.text.toString().toDouble().div(3)))

            tablelayout2.addView(tablerow)

            scrollview.fullScroll(ScrollView.FOCUS_DOWN)

            val removeButton = tablerow.findViewById<TableRow>(R.id.removeButton)
            removeButton.setOnClickListener {
                tablelayout2.removeView(tablerow)
            }


        } catch (e: Exception) {
            Snackbar.make(tablelayout2, e.message!!, Snackbar.LENGTH_SHORT).show()
//            tablelayout2.removeAllViews()
        }
    }

    private fun createYearsRow(df: DecimalFormat) {
        val tablerow2 = LayoutInflater.from(this).inflate(R.layout.table_row, null) as TableRow
        try {
            tablerow2.findViewById<TextView>(R.id.firstTextView).text =
                df.format(et_income.text.toString().toDouble().div(3).times(6))
            tablerow2.findViewById<TextView>(R.id.secTextView).text =
                df.format(et_income.text.toString().toDouble().div(3).times(12))
            tablerow2.findViewById<TextView>(R.id.thirdTextView).text =
                df.format(et_income.text.toString().toDouble().div(3).times(24))
            tablelayout_years.addView(tablerow2)
            scrollview_years.fullScroll(ScrollView.FOCUS_DOWN)
            val removeButton = tablerow2.findViewById<TableRow>(R.id.removeButton)
            removeButton.setOnClickListener {
                tablelayout_years.removeView(tablerow2)
            }
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveDataInInstance() {
        shared_prfEditor.putString("tablerow2", tablelayout_years.toString()).commit()
        shared_prfEditor.putString("tablerow", tablelayout2.toString()).commit()
//        shared_prfEditor.putString("invasment", tv_invasment.text.toString()).commit()
//        shared_prfEditor.putString("commit", tv_invasment.text.toString()).commit()

    }

    private fun intialViews() {
        et_income = findViewById(R.id.et_income)
        tablelayout2 = findViewById(R.id.tableLayout2)
        calcButton = findViewById(R.id.btn_calc)
        scrollview = findViewById(R.id.scrollview)
        scrollview_years = findViewById(R.id.scrollview_years)
        tablelayout_years = findViewById(R.id.tablelayout_years)
//        listview = findViewById(R.id.listview)
//        tv_personal = findViewById(R.id.)
//        tv_invasment = findViewById(R.id.invesmant_tv)
//        tv_commit = findViewById(R.id.commit_tv)
    }
}



