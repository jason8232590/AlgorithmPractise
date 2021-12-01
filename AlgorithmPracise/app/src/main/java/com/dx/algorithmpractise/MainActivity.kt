package com.dx.algorithmpractise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dx.algorithmpractise.orderSort.QuickSort

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //固定数组的增删改查
//        val array = IntArrayPractiseJava(5)
//        array.printAll()
//        array.insert(0, 3)
//        array.insert(0, 4)
//        array.insert(1, 5)
//        array.insert(3, 9)
//        array.insert(3, 10)
//        //array.insert(3, 11);
//        //array.insert(3, 11);
//        array.printAll()
//        array.delete(3)
//        array.printAll()
//        QuickSort.doQuickSort(intArrayOf(6, 11, 3, 9, 8),5)
        QuickSort.doQuickSort(intArrayOf(3, 2, 1, 4),4)

//        quickSort.doQuickSort(arrayOf(6, 11, 3, 9, 8),5)
    }
}