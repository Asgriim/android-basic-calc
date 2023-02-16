package org.hyperskill.calculator

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

fun addNumButtonEventListener(textField: EditText, button: Button) {
   button.setOnClickListener {
       if (textField.text.toString() == "0"){
           textField.setText(button.text, TextView.BufferType.EDITABLE)
       }
       else {
           textField.setText(toPrettyNum(textField.text.toString() + button.text))
//           textField.append(button.text)
//           textField.setText(textField.text.toString() + b, TextView.BufferType.EDITABLE)
       }


   }
}

fun addDotButtonEventListener(textField: EditText, button: Button) {
    button.setOnClickListener {
        if(button.text !in textField.text.toString() ) {

            if (textField.text.isEmpty() || textField.text.toString() == "-") {
                textField.append("0")
            }
            textField.append(button.text)

        }

    }
}

fun addClearButtonEventListener(model: Model, textField: EditText, button: Button) {
    button.setOnClickListener {
        textField.setText("")
        textField.hint = "0"
        model.restore()
    }
}


fun addOperationButtonEventListener(model: Model,textField: EditText, button: Button,operation: Operation) {
    button.setOnClickListener {

        if (model.getLastOperation() == Operation.EQUAL){
            model.setLastOperation(operation)
            return@setOnClickListener
        }

        if(!isValidOp(model.getLastOperation(), textField.text.toString())){
            return@setOnClickListener
        }

        model.executeLastOperation(textField.text.toString().toDouble())
        model.setLastOperation(operation)
        clearAndSetHint(textField, model.getValue().toString())
    }
}

fun addSubEventListener(model: Model,textField: EditText, button: Button) {
    button.setOnClickListener {

        if (model.getLastOperation() == Operation.EQUAL){
            model.setLastOperation(Operation.SUB)
            return@setOnClickListener
        }

        if (textField.text.toString() == "-") {
            textField.setText("")
            return@setOnClickListener
        }


        if(textField.text.isEmpty()){
            textField.setText("-")
            return@setOnClickListener
        }


        if(!isValidOp(model.getLastOperation(), textField.text.toString())){
            return@setOnClickListener
        }

        model.executeLastOperation(textField.text.toString().toDouble())
        model.setLastOperation(Operation.SUB)
        clearAndSetHint(textField, model.getValue().toString())
    }
}

fun addEqualButtonEventListener(model: Model,textField: EditText, button: Button) {
    button.setOnClickListener {

        if(!isValidOp(model.getLastOperation(), textField.text.toString())){
            return@setOnClickListener
        }

        model.executeLastOperation(textField.text.toString().toDouble())
        model.setLastOperation(Operation.EQUAL)
        clearAndSetHint(textField,model.getValue().toString())
    }
}

fun isValidOp(operation: Operation, num: String): Boolean {
//    if (num.isEmpty()) return true
    return try {
        !(num.toDouble() == 0.0 && operation == Operation.DIV)
    } catch (e: java.lang.NumberFormatException) {
        false
    }
}

fun clearAndSetHint(textField: EditText, string: String) {
    textField.setText("")
    textField.hint = toPrettyNum(string)
}

fun toPrettyNum(num: String): String {
    if (num == "-0") return "-"
    var d = num.toDouble()
    var i = d.roundToInt()

    if (i.toDouble() == d){
        return i.toString()
    }
    return d.toString()
}