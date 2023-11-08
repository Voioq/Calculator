package com.example.calculator

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.floor
import kotlin.math.sqrt



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var first_num: String = ""
        var second_num: String = ""
        var operation: String = ""

        btn_zero.setOnClickListener{setTextFields("0")}
        btn_one.setOnClickListener{setTextFields("1")}
        btn_two.setOnClickListener{setTextFields("2")}
        btn_three.setOnClickListener{setTextFields("3")}
        btn_four.setOnClickListener{setTextFields("4")}
        btn_five.setOnClickListener{setTextFields("5")}
        btn_six.setOnClickListener{setTextFields("6")}
        btn_seven.setOnClickListener{setTextFields("7")}
        btn_eight.setOnClickListener{setTextFields("8")}
        btn_nine.setOnClickListener{setTextFields("9")}
        //только одна точка
        btn_dot.setOnClickListener{
            if (math_operation.text.toString().indexOf(".") == -1){
                setTextFields(".")
            }
        }

        //вычетание
        btn_minus.setOnClickListener{

            try{
                operation = "-"
                if (first_num == ""){
                    first_num = math_operation.text.toString()
                    math_operation.text = ""
                }
                else{
                    second_num = math_operation.text.toString()
                    stringBilder(first_num, second_num, operation)
                    first_num = result_text.text.toString()
                    math_operation.text = ""
                }
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        //сложение
        btn_plus.setOnClickListener{
            try {
                operation = "+"
                if (first_num == ""){
                    first_num = math_operation.text.toString()
                    math_operation.text = ""
                }
                else{
                    second_num = math_operation.text.toString()
                    stringBilder(first_num, second_num, operation)
                    first_num = result_text.text.toString()
                    math_operation.text = ""
                }
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        //озведение в степень
        btn_exp.setOnClickListener{
            try {
                operation = "^"
                if (first_num == ""){
                    first_num = math_operation.text.toString()
                    math_operation.text = ""
                }
                else{
                    second_num = math_operation.text.toString()
                    stringBilder(first_num, second_num, operation)
                    first_num = result_text.text.toString()
                    math_operation.text = ""
                }
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        //умножение
        btn_multiply.setOnClickListener{
            try {
                operation = "*"
                if (first_num == ""){
                    first_num = math_operation.text.toString()
                    math_operation.text = ""
                }
                else{
                    second_num = math_operation.text.toString()
                    stringBilder(first_num, second_num, operation)
                    first_num = result_text.text.toString()
                    math_operation.text = ""
                }
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        //корень
        btn_root.setOnClickListener{

            try{
                if (first_num == ""){
                    first_num = math_operation.text.toString()
                    rootOperation(first_num)
                    first_num = result_text.text.toString()
                    math_operation.text = ""
                }
                else{
                    first_num = math_operation.text.toString()
                    rootOperation(first_num)
                    first_num = result_text.text.toString()
                    math_operation.text = ""
                }
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        //деление
        btn_div.setOnClickListener{
            try {
                operation = "/"
                if (first_num == ""){
                    first_num = math_operation.text.toString()
                    math_operation.text = ""
                }
                else{
                    second_num = math_operation.text.toString()
                    stringBilder(first_num, second_num, operation)
                    first_num = result_text.text.toString()
                    math_operation.text = ""
                }
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        //кнопка равно
        btn_equal.setOnClickListener{
            try{
                second_num = math_operation.text.toString()
                stringBilder(first_num, second_num, operation)
                first_num = result_text.text.toString()
                math_operation.text = ""
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        //сброс AC
        btn_ac.setOnClickListener{
            math_operation.text = ""
            result_text.text = ""
            first_num = ""
            second_num = ""
        }
    }
    //внесение чисел
    fun setTextFields(str: String){
        math_operation.append(str)
    }

    //корень
    fun rootOperation(str_1: String){
        result_text.text = sqrt(str_1.toDouble()).toString()
    }

    //операции
    fun stringBilder(str_1: String, str_2: String, str_operation: String){
        var num_1: Double = str_1.toDouble()
        var num_2: Double = str_2.toDouble()
        Log.d("Message", "num1 = ${num_1}, num2 = ${num_2}, operation = ${str_operation}")
        if (str_operation == "-"){
            result_text.text = (num_1 - num_2).toString()
        }
        else if(str_operation == "+"){
            result_text.text = (num_1 + num_2).toString()
        }
        else if(str_operation == "^"){
            if (str_2[0] == '0'){
                num_1 = 1.0;
            }
            else{
                for (i in 0 until floor(num_2).toInt()) {
                    num_1 *= num_2
                }
            }
            result_text.text = (num_1).toString()
        }
        else if(str_operation == "*"){
            result_text.text = (num_1 * num_2).toString()
        }
        else if(str_operation == "/"){
            if (str_2[0] == '0'){
                btn_ac.performClick()
                result_text.text = "Ошибка"
            }
            else{
                result_text.text = (num_1 / num_2).toString()
            }
        }
    }
}