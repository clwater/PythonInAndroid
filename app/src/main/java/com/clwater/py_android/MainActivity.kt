package com.clwater.py_android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chaquo.python.Python
import com.clwater.py_android.ui.theme.PythonInAndroidTheme

class MainActivity : ComponentActivity() {
    private val TAG = "py_android.MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PythonInAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Python in Android")
                }
            }
        }
        val py = Python.getInstance()
        val module = py.getModule( "my_module" )

        // 2.1. Accessing variables (data members)
        val numsLength = module[ "nums_len" ]?.toInt()
        Log.d(TAG,  "Nums Length is $numsLength" )
        val ops = module[ "ops" ]!!
        Log.d(TAG,  "Operations: $ops" )
        Log.d(TAG,  "num_ops : ${ ops[ "num_ops" ] }" )
        Log.d(TAG,  "mean func : ${ ops[ "meanOp" ] }" )

        // 2.2. Calling Functions
        val sumFunc = module[ "sumOp" ]
        val sum = sumFunc?.call( intArrayOf( 12 , 25 , 32 ) )
        val powFun = module[ "powOp" ]
        val pow = powFun?.call( 5 , 2 )
        Log.d(TAG,  "Sum: $sum" )
        Log.d(TAG,  "Pow: $pow" )

        val meanFunc = ops[ "meanOp" ]
        val mean = meanFunc?.call( intArrayOf( 23 , 45 , 12 , 91 ) )
        Log.d(TAG,  "Mean: $mean" )
        // OR
//        val mean = ops.callAttr( "meanOp" , intArrayOf( 23 , 45 , 12 , 91 ) )
//        Log.d(TAG,  "Mean: $mean" )



        // Numpy
        val npSumFunc = module[ "npMatrixSum" ]
        val output = npSumFunc?.call( 2 , 3 )
        // OR
//        val output = module.callAttr( "npMatrixSum" , 2 , 3 )

        Log.d(TAG,  "Output: $output" )
        Log.d(TAG,  "Output shape: ${output!![ "shape" ] }")

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
