package com.nst.my_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private val adapter = MovieAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        var  recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        var editText = findViewById<EditText>(R.id.searchview)
        //var searchview = findViewById<SearchView>(R.id.searchview)
        //recyclerview.layoutManager = LinearLayoutManager(this)

        recyclerview.layoutManager = GridLayoutManager(this,2)
        recyclerview.adapter = adapter

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)

//        searchview.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
//
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                println("On_Submit 1");
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                println("On_Submit 2");
//                adapter.searchdata(p0)
//                return false
//            }
//
//        })
        editText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("SubmitSample 1");
                //adapter.searchdata(p0)
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("SubmitSample 2");
                adapter.searchdata("Sample")
            }

            override fun afterTextChanged(p0: Editable?) {
                println("SubmitSample 2");
                adapter.searchdata("Sample")
            }

        })
        viewModel.movieList.observe(this, {
            adapter.setMovies(it)
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer {
//            if (it) {
//                binding.progressDialog.visibility = View.VISIBLE
//            } else {
//                binding.progressDialog.visibility = View.GONE
//            }
        })

        viewModel.getAllMovies()
    }
}