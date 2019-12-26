package com.example.myexperiments.fragment_testing.backstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import com.example.myexperiments.R
import kotlinx.android.synthetic.main.activity_back_stack.*

class BackStackActivity : AppCompatActivity() {

    var commitId1 : Int = 0
    var commitId2 : Int = 0
    var commitId3 : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)

        btn_fragment1.setOnClickListener{
            commitId1 = supportFragmentManager.beginTransaction().replace(R.id.backstack_container, Fragment1(), Fragment1.TAG).addToBackStack(Fragment1.TAG).commit()
        }

        btn_fragment2.setOnClickListener{
            commitId2 = supportFragmentManager.beginTransaction().replace(R.id.backstack_container, Fragment2(), Fragment2.TAG).addToBackStack(Fragment2.TAG).commit()
        }

        btn_fragment3.setOnClickListener{
            commitId3 = supportFragmentManager.beginTransaction().replace(R.id.backstack_container, Fragment3(), Fragment3.TAG).addToBackStack(Fragment3.TAG).commit()
        }

        btn_clr_back_stack1.setOnClickListener{
            //poping by one element
            supportFragmentManager.popBackStack()
        }

        btn_clr_back_stack2.setOnClickListener{
            //popping by tag 0 for not including
            supportFragmentManager.popBackStack(Fragment1.TAG, 0)
        }

        btn_clr_back_stack3.setOnClickListener{
            //popping by tag with including the given fragment
            supportFragmentManager.popBackStack(Fragment1.TAG, POP_BACK_STACK_INCLUSIVE)
        }

        btn_clr_back_stack4.setOnClickListener{
            //popping by commit id
            supportFragmentManager.popBackStack(commitId1, 0)
        }
    }
}
