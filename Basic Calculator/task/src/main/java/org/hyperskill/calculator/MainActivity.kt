package org.hyperskill.calculator

import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val model = ModelImp(0.0,0.0)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainTextField:EditText = findViewById(R.id.displayEditText)
        mainTextField.inputType = InputType.TYPE_NULL
        //look really bad, need to fix
        addNumButtonEventListener(mainTextField, findViewById(R.id.button0))
        addNumButtonEventListener(mainTextField, findViewById(R.id.button1))
        addNumButtonEventListener(mainTextField, findViewById(R.id.button2))
        addNumButtonEventListener(mainTextField, findViewById(R.id.button3))
        addNumButtonEventListener(mainTextField, findViewById(R.id.button4))
        addNumButtonEventListener(mainTextField, findViewById(R.id.button5))
        addNumButtonEventListener(mainTextField, findViewById(R.id.button6))
        addNumButtonEventListener(mainTextField, findViewById(R.id.button7))
        addNumButtonEventListener(mainTextField, findViewById(R.id.button8))
        addNumButtonEventListener(mainTextField, findViewById(R.id.button9))
        addDotButtonEventListener(mainTextField,findViewById(R.id.dotButton))
        addClearButtonEventListener(model, mainTextField,findViewById(R.id.clearButton))
        addOperationButtonEventListener(model, mainTextField,findViewById(R.id.divideButton),Operation.DIV)
        addOperationButtonEventListener(model, mainTextField,findViewById(R.id.multiplyButton),Operation.MUL)
        addOperationButtonEventListener(model, mainTextField,findViewById(R.id.addButton),Operation.ADD)
//        addOperationButtonEventListener(model, mainTextField,findViewById(R.id.subtractButton),Operation.SUB)
        addSubEventListener(model, mainTextField,findViewById(R.id.subtractButton))

//        addDivButtonEventListener(model, mainTextField,findViewById(R.id.divideButton))
        addEqualButtonEventListener(model,mainTextField, findViewById(R.id.equalButton))
    }

}
fun main(){
    println(toPrettyNum("-01"))
}