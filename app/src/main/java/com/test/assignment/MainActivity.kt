package com.test.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.webkit.URLUtil
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.assignment.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//    val token = "efe5f6264a2d38bd0a326b77831e9f0f6357c290"

    lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }


    fun init()
    {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

//        val types = arrayOf("https://","http://")
//
//        spType.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,types)

        setObservers()

        btSubmit.setOnClickListener {
            if( Patterns.WEB_URL.matcher(etUrl.text.toString()).matches()&& URLUtil.isValidUrl(etUrl.text.toString())) {
                showProgress(true)
                getUrl()
            }
            else {
                showMessage("Invalid Url")
            }
        }

    }

    fun getUrl()
    {
        viewModel.getShortenUrl(etUrl.text.toString())
    }

    fun setObservers()
    {
        viewModel.response.observe(this, Observer {
            showProgress(false)
            tvUrl.text = it.link
            showMessage("Link Generated SuccessFully!")
        })

        viewModel.error.observe(this, Observer {
            showProgress(false)
            showMessage(it)
        })
    }

    fun showMessage(error:String)
    {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    fun showProgress(show:Boolean)
    {
        if (show)
            progressBar.visibility = View.VISIBLE
        else
            progressBar.visibility = View.GONE
    }
}