package com.example.ngay3010

import android.os.Bundle
import android.text.InputType
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var selected_radio: RadioButton;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edit = findViewById<EditText>(R.id.editTextnumber);
        var techviu = findViewById<TextView>(R.id.resultView);
        val litviu = findViewById<ListView>(R.id.hienthiketqua);
        val radiolit = findViewById<RadioGroup>(R.id.radiogrup);
        radiolit.setOnCheckedChangeListener { group, checkedId ->
             selected_radio = findViewById<RadioButton>(checkedId);
        }
        val battun = findViewById<Button>(R.id.nutgui);
        battun.setOnClickListener {
            if (edit.text.toString().toInt() < 0  || (edit.text.toString() == null)){
                techviu.setText("Khong hop le");
            }else{
                var numberz = edit.text.toString().toInt();
                val oddNumbers = mutableListOf<String>()
                if (selected_radio.id == R.id.choice1){
                    var i:Int;
                    for ( i in 0..numberz ){
                        if(i%2 == 0){
                            oddNumbers.add(i.toString());
                        }
                    }
                    var adatper = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,oddNumbers)
                    litviu.adapter = adatper
                }else if(selected_radio.id == R.id.choice2){
                    var i:Int;
                    for ( i in 0..numberz ){
                        if(i%2 == 1){
                            oddNumbers.add(i.toString());
                        }
                    }
                    var adatper = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,oddNumbers)
                    litviu.adapter = adatper
                }else{
                    // Tạo danh sách các số chính phương
                    val perfectSquares = mutableListOf<Int>()

                    // Kiểm tra các số từ 1 đến N
                    for (i in 1..numberz) {
                        val sqrt = Math.sqrt(i.toDouble()).toInt() // Tính căn bậc hai và chuyển đổi thành số nguyên
                        if (sqrt * sqrt == i) { // Kiểm tra xem bình phương của căn bậc hai có bằng số gốc không
                            perfectSquares.add(i) // Thêm số chính phương vào danh sách
                        }
                    }
                    var adatper = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,perfectSquares)
                    litviu.adapter = adatper


                }
            }
        }
    }
}