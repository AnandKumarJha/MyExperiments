package com.example.myexperiments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.myexperiments.util.showToastMsg

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportActionBar?.setTitle("hello")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.header, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.item_search){
            showToastMsg("Search")
        }else if(item.itemId==R.id.item_settings){
            showToastMsg("settting")
        }else if (item.itemId == R.id.item_star){
            showToastMsg("star")
        }
        return true
    }
}
