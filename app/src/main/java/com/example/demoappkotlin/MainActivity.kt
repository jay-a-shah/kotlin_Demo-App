package com.example.demoappkotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import com.example.demoappkotlin.mvc.View.MVCActivity
import com.example.demoappkotlin.mvvm.View.MVVMActivity
import com.example.demoappkotlin.WebServices.DataBindingActivity
import com.example.demoappkotlin.WebView.WebViewActivity
import com.example.demoappkotlin.WebServices.LoginScreenWithApi
import com.example.demoappkotlin.activityAndFragments.ActivityLifecycle
import com.example.demoappkotlin.activityAndFragments.DataPassingActivityOne
import com.example.demoappkotlin.activityAndFragments.ImplicitIntent
import com.example.demoappkotlin.activityAndFragments.JetPackNavigationActivity
import com.example.demoappkotlin.binding_adapter.BindingAdapterActivity
import com.example.demoappkotlin.differentLayout.LayoutActivity
import com.example.demoappkotlin.listviewpager.ListViewActivity
import com.example.demoappkotlin.utils.ZERO
import kotlin.math.pow
import kotlin.reflect.KFunction2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Android Ui and All Toast Button to transfer to basic kotlin Activity with Custom Toast
        val btnAllToast = findViewById<Button>(R.id.btnAllToast)
        btnAllToast.setOnClickListener {
            val intent = Intent(applicationContext, BasicsKotlin::class.java)
            startActivity(intent)
        }
        //Android Ui Button with Normal toast
        val btnAndroidUI = findViewById<Button>(R.id.btnAndroidUi)
        btnAndroidUI.setOnClickListener {
            val normalToast = Toast.makeText(
                applicationContext,
                getString(R.string.toast_normal),
                Toast.LENGTH_SHORT
            )
            normalToast.apply {
                setGravity(Gravity.TOP, ZERO, ZERO)
                show()
            }
            val intent = Intent(applicationContext, AndroidUI::class.java)
            startActivity(intent)
        }
        //Different Layout Activity Button
        val btnDifferentLayout = findViewById<Button>(R.id.btnDifferentLayout)
        btnDifferentLayout.setOnClickListener {
            val intent = Intent(applicationContext, LayoutActivity::class.java)
            startActivity(intent)
        }
        val btnListViewAndRecyclerView = findViewById<Button>(R.id.btnListViewAndRecyclerView)
        btnListViewAndRecyclerView.setOnClickListener {
            val intent = Intent(applicationContext, ListViewActivity::class.java)
            startActivity(intent)
        }
        val activityLifecycleBtn = findViewById<Button>(R.id.btnActivityLifecycle)
        activityLifecycleBtn.setOnClickListener {
            val intent = Intent(applicationContext, ActivityLifecycle::class.java)
            startActivity(intent)
        }
        val btnImplicitIntent = findViewById<Button>(R.id.btnImplicitIntent)
        btnImplicitIntent.setOnClickListener {
            val intent = Intent(applicationContext, ImplicitIntent::class.java)
            startActivity(intent)
        }
        val btnDataPassingActivity = findViewById<Button>(R.id.btnDataPassingActivity)
        btnDataPassingActivity.setOnClickListener {
            val intent = Intent(applicationContext, DataPassingActivityOne::class.java)
            startActivity(intent)
        }
        val btnJetPackNavComponent = findViewById<Button>(R.id.btnJetPackNavComponent)
        btnJetPackNavComponent.setOnClickListener {
            val intent = Intent(applicationContext, JetPackNavigationActivity::class.java)
            startActivity(intent)
        }
        (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
            val intent = Intent(applicationContext, ImplicitIntent::class.java)
            intent.putExtra(getString(R.string.key_implicit_intent), it)
            startActivity(intent)
        }
        val btnLoginScreenWithApi = findViewById<Button>(R.id.btnLoginScreenWithApi)
        btnLoginScreenWithApi.setOnClickListener {
            val intent = Intent(applicationContext, LoginScreenWithApi::class.java)
            startActivity(intent)
        }
        val btnWebViewActivity = findViewById<Button>(R.id.btnWebViewActivity)
        btnWebViewActivity.setOnClickListener {
            val intent = Intent(applicationContext, WebViewActivity::class.java)
            startActivity(intent)
        }
        val btnMVCActivity = findViewById<Button>(R.id.btnMVCActivity)
       btnMVCActivity.setOnClickListener {
            val intent = Intent(applicationContext, MVCActivity::class.java)
            startActivity(intent)
        }
        val btnMVVMActivity = findViewById<Button>(R.id.btnMVVMActivity)
        btnMVVMActivity.setOnClickListener {
            val intent = Intent(applicationContext, MVVMActivity::class.java)
            startActivity(intent)
        }
        val btnDataBinding = findViewById<Button>(R.id.btnDataBinding)
        btnDataBinding.setOnClickListener {
            val intent = Intent(applicationContext, DataBindingActivity::class.java)
            startActivity(intent)
        }
        val btnBindingAdapter = findViewById<Button>(R.id.btnBindingAdapter)
        btnBindingAdapter.setOnClickListener {
            val intent = Intent(applicationContext, BindingAdapterActivity::class.java)
            startActivity(intent)
        }


        //functions
        fun sum(a: Int, b: Int): Int {
            return a + b
        }

        val z = sum(2, 6)
        Log.d("Functions", z.toString())
        //Classes
        class Rectangle(var height: Double, var Breadth: Double) {
            var perimeter = (height + Breadth * 2).toString()
        }

        var rectangle = Rectangle(6.0, 2.0)
        Log.d("Class", rectangle.perimeter)
        //Operators
        var p1 = 13
        var p2 = 2
        var p3 = p1 + p2
        var p4 = p1 - p2
        var p5 = p1.toFloat() / p2
        Log.d("Operator", p3.toString())
        Log.d("Operator", p4.toString())
        Log.d("Operator", p5.toString())
        var p6 = p1 < p2
        Log.d("Operator", p6.toString())
        //Strings
        var a1 = 1
        val s1 = "a1 is $a1"
        Log.d("Strings", s1.toString())
        //Condition loop
        val isRaining = true
        if (isRaining) {
            Log.d("Condition", "It is Raining")
        } else {
            Log.d("Condition", "It is not raining")
        }
        //ternary Operator
        val t1 = 10
        val t2 = 11
        val result = if (t1 > t2) "t1 is smaller" else "t2 is smaller"
        Log.d("Condition1", result)
        //When Condition loop
        when ("Dog") {
            "Horse" -> Log.d("When", "It is Horse")
            "Goat" -> Log.d("When", "It is Goat")
            "Dog" -> Log.d("When", "It is Dog")
            else -> Log.d("When", "Nothing")
        }
        //while Loop
        val f1 = 2
        var f2 = 1
        while (f2 <= 10) {
            val f3 = f1 * f2
            f2++
            Log.d("while", f3.toString())
        }
        //Inheritance
        open class Parent() {
            val name: String = ""
            fun myMethod() {
                Log.d("Inheri", "I am in Parent")
            }
        }

        class Child : Parent() {
            val name2: String = ""
            fun myMethod2() {
                Log.d("Inheri", "I am in chile")
            }
        }

        val objchild = Child()
        objchild.myMethod2()
        objchild.myMethod()
        //Method Overriding
        open class Mobile() {
            val name: String = ""
            val size = 2
            open fun display() = Log.d("Overiding", "In Parent Class")
        }

        class Oneplus : Mobile() {
            override fun display() = Log.d("Overriding", "In sub Class")
        }

        val oneplus = Oneplus()
        oneplus.display()
        //Function Types
        fun sum1(e1: Int, e2: Int): Int {
            return e1 + e2
        }

        fun power(e1: Double, e2: Double): Double {
            return e1.pow(e2)
        }
        Log.d("Function Type", sum1(2, 4).toString())
        Log.d("Function Type", power(5.0, 2.0).toString())
        var fn: KFunction2<Double, Double, Double> = ::power
        Log.d("Function Type", fn(2.0, 3.0).toString())
        //Higher Order Function
        fun calculator(d1: Int, d2: Int, gn: (Int, Int) -> Int) {
        }
        Log.d("HigherOrderFunction", calculator(5, 5, ::sum1).toString())
        //Lambda Function
        var singleParamLambda = { x: Int -> x * x }
        var lambda2 = { x: Int, y: Int -> x + y }
        Log.d("Lambda", singleParamLambda(5).toString())
        Log.d("Lambda", lambda2(3, 5).toString())
        var multilinelambda = {
            Log.d("Lambda", "Hiii")
            var i1 = 2 + 3
            2
        }
        multilinelambda()   //here last entity will be its return type
        Log.d("Lambda", multilinelambda().toString())
        //Null Safety and Elvis Function
        var gender: String = "Male"
        var gender2: String? = null
        var isAdult: Boolean? = null
        Log.d("Null", gender)
        //Log.d("Null1", gender2?.uppercase())
        if (gender2 != null) {
            Toast.makeText(this, gender2, Toast.LENGTH_SHORT).show()
        }
        var selecteditem = gender2 ?: "NA"  //Elvis function
        Log.d("Null", selecteditem)
        //Data Class
        data class Person1(val id: Int, val name: String) {
        }

        val o1 = Person1(2, "John")
        val o2 = Person1(1, "John")
        Log.d("Data Class", o1.equals(o2).toString())
        val o3 = o1.copy(id = 3)
        Log.d("Data", o3.toString())
        //Extension Function
        class Student {
            fun isPassed(mark: Int): Boolean {
                return mark > 35
            }
        }

        fun Student.isBrilliant(mark: Int): Boolean {
            return mark > 85
        }

        val student = Student()
        Log.d("Exten", student.isBrilliant(95).toString())
        //lateinit and Lazy
        val pi: Float by lazy { 3.14f }
        val area1 = 4 * pi * 4
        Log.d("Lazy", area1.toString())
        class Country {
            lateinit var name: String
        }

        val country = Country()
        country.name = "India"
        Log.d("Lateinit", country.name)

        //Lists
        val nums = listOf<Int>(1, 2, 3, 4, 5)
        Log.d("Lists", nums.indexOf(4).toString())
        Log.d("Lists", nums.contains(4).toString())
        val nums1 = mutableListOf<Int>(1, 5, 23, 5, 6)
        Log.d("Lists", nums1.add(55).toString())
        Log.d("Lists", nums1.remove(5).toString())
        Log.d("Lists", nums1.toString())
        Log.d("Collec", nums1.addAll(nums).toString())
        Log.d("Collec", nums1.indexOf(23).toString())
        Log.d("Collec", nums1.toString())
        //Maps
        val students = mutableMapOf<Int, String>()     //Key Value Pair
        students[1] = "Jay"
        students[2] = "vishal"
        Log.d("Map", students[2].toString())
        for ((key, value) in students) {
            Log.d("Map", "$key = $value")
        }

    }
}
