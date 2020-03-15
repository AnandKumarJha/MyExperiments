package com.example.myexperiments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.myexperiments.util.showToastMsg
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportActionBar?.setTitle("hello")

        tv_hello_world.setOnClickListener {
            startActivity(Intent(this@MainActivity, ChildActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.header, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.item_search){
            showToastMsg("Search")
            startActivity(Intent(this, ChildActivity::class.java))
        }else if(item.itemId==R.id.item_settings){
            showToastMsg("settting")
        }else if (item.itemId == R.id.item_star){
            showToastMsg("star")
        }
        return true
    }
}
