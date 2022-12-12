package com.example.foodyresep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.foodyresep.data.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextTextEmailAddress: EditText
    private  lateinit var editTextTextPassword: EditText
    private lateinit var bLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress) as EditText
        editTextTextPassword = findViewById(R.id.editTextTextPassword) as EditText
        bLogin = findViewById(R.id.bLogin) as Button
        bLogin.setOnClickListener{
            if (editTextTextEmailAddress.text.equals("") || editTextTextPassword.text.equals("")){
                Toast.makeText(this, "Data Masih Ada Yang Kosong", Toast.LENGTH_SHORT).show()

            }else{
                login(editTextTextEmailAddress.text.toString(), editTextTextPassword.text.toString())
            }
        }


    }

    private fun login(email: String, pass:String) {
        NetworkConfig().getService()
            .login(email, pass)
            .enqueue(object : Callback<UserResponse> {
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.body()!!.msg.equals("Berhasil")) {
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                    } else {
                        Toast.makeText(this@LoginActivity, response.body()!!.msg, Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }
}