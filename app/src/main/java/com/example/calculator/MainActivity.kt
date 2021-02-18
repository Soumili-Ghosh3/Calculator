package com.example.calculator

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.faendir.rhino_android.RhinoAndroidHelper
import org.mozilla.javascript.ImporterTopLevel
import org.mozilla.javascript.Scriptable


class MainActivity : AppCompatActivity() {

    lateinit var tvOutput: TextView
    lateinit var tvInput: TextView
    private var context: Context? = null
    private var scope: Scriptable? = null
    private var rhinoAndroidHelper: RhinoAndroidHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOutput = findViewById(R.id.tvOutput)
        tvInput = findViewById(R.id.tvInput)
        val button0: Button = findViewById(R.id.btn0)
        val button1: Button = findViewById(R.id.btn1)
        val button2: Button = findViewById(R.id.btn2)
        val button3: Button = findViewById(R.id.btn3)
        val button4: Button = findViewById(R.id.btn4)
        val button5: Button = findViewById(R.id.btn5)
        val button6: Button = findViewById(R.id.btn6)
        val button7: Button = findViewById(R.id.btn7)
        val button8: Button = findViewById(R.id.btn8)
        val button9: Button = findViewById(R.id.btn9)

        val buttonclr: Button = findViewById(R.id.btnClear)
        val buttonbracket: Button = findViewById(R.id.btnBracket)
        val buttonpercent: Button = findViewById(R.id.btnPercent)
        val buttondiv: Button = findViewById(R.id.btnDivision)
        val buttonmul: Button = findViewById(R.id.btnMultiply)
        val buttonsub: Button = findViewById(R.id.btnSubtract)
        val buttonplus: Button = findViewById(R.id.btnPlus)
        val buttondot: Button = findViewById(R.id.btnDot)
        val buttonequal: Button = findViewById(R.id.btnEqual)

        buttonclr.setOnClickListener()
        {
            tvInput.text = ""
            tvOutput.text = ""
        }

        button0.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("0")
            tvOutput.text=""
        }
        button1.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("1")
            tvOutput.text=""
        }
        button2.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("2")
            tvOutput.text=""
        }
        button3.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("3")
            tvOutput.text=""
        }
        button4.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("4")
            tvOutput.text=""
        }
        button5.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("5")
            tvOutput.text=""
        }
        button6.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("6")
            tvOutput.text=""
        }
        button7.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("7")
            tvOutput.text=""
        }
        button8.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("8")
            tvOutput.text=""
        }
        button9.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("9")
            tvOutput.text=""
        }
        buttonplus.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("+")
            tvOutput.text=""
        }
        buttonpercent.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("%")
            tvOutput.text=""
        }
        buttondiv.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("÷")
            tvOutput.text=""
        }
        buttonsub.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("-")
            tvOutput.text=""
        }
        buttondot.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append(".")
            tvOutput.text=""
        }
        buttonmul.setOnClickListener()
        {
            tvInput.append(tvOutput.text)
            tvInput.append("×")
            tvOutput.text=""
        }
        var checkedbracket: Boolean = false
        buttonbracket.setOnClickListener()
        {
            if(checkedbracket)
            {
                tvInput.append(tvOutput.text)
                tvInput.append(")")
                tvOutput.text=""
                checkedbracket = false
            }
            else{
                tvInput.append(tvOutput.text)
                tvInput.append("(")
                tvOutput.text=""
                checkedbracket = true
            }
        }

        buttonequal.setOnClickListener()
        {
            val p: String = tvInput.text.toString()


            rhinoAndroidHelper = RhinoAndroidHelper(this)
            context = rhinoAndroidHelper.enterContext()
            context.setOptimizationLevel(1)
            scope = ImporterTopLevel(context)
            var finalresult: String = ""
            try{
                val scriptable: Scriptable = context.initStandardObjects()
                context.evaluateString(scriptable, p, "javascript", 1, null).toString()
            }catch (e: Exception){
                finalresult = "0"
            }
            tvOutput.text = finalresult
        }

    }
}

