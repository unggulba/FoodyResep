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

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextTextEmailAddress2 : EditText
    private lateinit var editTextTextPassword2 : EditText
    private  lateinit var editTextTextPersonName : EditText
    private lateinit var bRegistrasi: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editTextTextEmailAddress2 = findViewById(R.id.editTextTextEmailAddress2) as EditText
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2) as EditText
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName) as EditText
        bRegistrasi = findViewById(R.id.bRegistrasi) as Button

        bRegistrasi.setOnClickListener{
            if (editTextTextEmailAddress2.text.equals("") || editTextTextPassword2.text.equals("") || editTextTextPersonName.text.equals("")){
                Toast.makeText(this, "Data Masih Ada Yang Kosong", Toast.LENGTH_SHORT).show()

            }else{
                registrasi(editTextTextEmailAddress2.text.toString(), editTextTextPassword2.text.toString(), editTextTextPersonName.text.toString())
            }
        }

    }

    private fun registrasi(email: String, pass:String, username: String) {
        NetworkConfig().getService()
            .register(email, pass, username)
            .enqueue(object : Callback<UserResponse> {
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.body()!!.msg.equals("Berhasil")) {
                        startActivity(Intent(applicationContext, LoginActivity::class.java))
                    } else {
                        Toast.makeText(this@RegisterActivity, response.body()!!.msg, Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }
}