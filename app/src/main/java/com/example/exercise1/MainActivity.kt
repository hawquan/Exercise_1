package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eTextCarPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val eTextDownPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val eTextLoanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val eTextInterestRate = findViewById<EditText>(R.id.editTextInterestRate)

  //      val tViewLoan = findViewById<TextView>(R.id.textViewLoan)
  //      val tViewInterest = findViewById<TextView>(R.id.textViewInterest)
  //      val tViewMonthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val bCalculate = findViewById<Button>(R.id.buttonCalculate)
        val bReset = findViewById<Button>(R.id.buttonReset)

        bCalculate.setOnClickListener(View.OnClickListener {
           val tViewLoan = (eTextCarPrice.text.toString().toInt() - eTextDownPayment.text.toString().toInt()).toString()
           val tViewInterest = (tViewLoan.toInt() * eTextInterestRate.text.toString().toDouble() * eTextLoanPeriod.text.toString().toInt()).toString()
           val tViewMonthlyRepayment = ((tViewLoan.toInt()+tViewInterest.toDouble()) / eTextLoanPeriod.text.toString().toInt() / 12).toString()


            textViewLoan.setText("Loan : " + tViewLoan)
            textViewInterest.setText("Interest : " + tViewInterest)
            textViewMonthlyRepayment.setText("Monthly Repayment : " + tViewMonthlyRepayment)
        })

        bReset.setOnClickListener(View.OnClickListener {
            editTextCarPrice.text.clear()
            editTextDownPayment.text.clear()
            editTextInterestRate.text.clear()
            editTextLoanPeriod.text.clear()
            textViewLoan.setText("Loan : ")
            textViewInterest.setText("Interest : ")
            textViewMonthlyRepayment.setText("Monthly Repayment  :")
        })
    }


}
