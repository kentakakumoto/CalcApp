package jp.techacademy.kenta.kakumoto.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        timesButton.setOnClickListener(this)
        dividedButton.setOnClickListener(this)

    }

    override fun onClick(v: View){
        val intent = Intent(this,ResultActivity::class.java)

        try{
        val value1 = editText1.text.toString().toDouble()
        val value2 = editText2.text.toString().toDouble()

        Log.d("TEST", editText1.text.toString())
        var mark = 0

        when(v.id){
            R.id.plusButton -> intent.putExtra("CALC",(value1+value2))
            R.id.minusButton -> intent.putExtra("CALC",(value1-value2))
            R.id.timesButton -> intent.putExtra("CALC",(value1*value2))
            R.id.dividedButton -> {
                intent.putExtra("CALC",(value1/value2))
                mark = 1
            }
        }
        if(value2 == 0.0 && mark == 1){
            Snackbar.make(v, "0で割れません", Snackbar.LENGTH_LONG)
                .setAction("OK", null).show()
        }else{
            startActivity(intent)
        }
        }catch(e:Exception){
            Log.d("TEST","例外処理")
            Snackbar.make(v ,"何か入力してください", Snackbar.LENGTH_LONG)
                .setAction("OK", null).show()
        }
    }
}