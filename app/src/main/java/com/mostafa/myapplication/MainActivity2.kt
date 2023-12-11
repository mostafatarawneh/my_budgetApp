package com.mostafa.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mostafa.myapplication.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val addButton = findViewById<Button>(R.id.addButton)
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val numberEditText = findViewById<EditText>(R.id.numberEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)




        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val number = numberEditText.text.toString()
            val email = emailEditText.text.toString()

            val tableRow = LayoutInflater.from(this).inflate(R.layout.table_row, null) as TableRow
            tableRow.findViewById<TextView>(R.id.firstTextView).setText(number)
            tableRow.findViewById<TextView>(R.id.secTextView).setText(name)
            tableRow.findViewById<TextView>(R.id.thirdTextView).setText(email)

            val removeButton = tableRow.findViewById<TableRow>(R.id.removeButton)

            removeButton.setOnClickListener {
                tableLayout.removeView(tableRow)
            }

            tableLayout.addView(tableRow)

        }
    }
}