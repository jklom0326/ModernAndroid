package com.example.maskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maskapp.model.Store
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storeadapter = StoreAdapter()

        recycler_View.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                RecyclerView.VERTICAL,
                false)
            adapter = storeadapter
        }

        viewModel.apply {
            itemLiveData.observe(this@MainActivity, Observer {
                storeadapter.updateItems(it)
            })

            loadingLiveData.observe(this@MainActivity,  Observer {
                progressBar.visibility = if (it) View.VISIBLE else View.GONE
            })
        }
    }
}