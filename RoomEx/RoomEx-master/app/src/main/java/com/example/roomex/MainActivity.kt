package com.example.roomex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.roomex.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner =this // 라이브 데이터를 활용하기 위해 사용함

        val viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        binding.viewModel = viewModel

//        UI 관찰 코드
//        viewModel.getAll().observe(this, Observer {
//            result_text.text = it.toString()
//        })

//        btn_add.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                viewModel.insert(Todo(editTextTextPersonName.text.toString()))
//                editTextTextPersonName.setText("")
//            }
//        }
    }
}