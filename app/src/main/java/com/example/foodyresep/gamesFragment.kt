package com.example.foodyresep

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodyresep.luckyDraw.LuckyWheel


class gamesFragment : Fragment() {

    private lateinit var spin: LuckyWheel


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_games, container, false)
        spin = view.findViewById(R.id.spinmakanan) as LuckyWheel


        return view
    }


}