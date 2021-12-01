package com.example.numbersystemconverter

import android.app.ActionBar
import android.graphics.Color
import android.graphics.Color.WHITE
import android.graphics.ColorFilter
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_view_pager.*
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        myToolbar.inflateMenu(R.menu.top_menu)
        myToolbar.setTitle("Number System Converter")
        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager,lifecycle)

        view.viewpager.adapter=adapter
        TabLayoutMediator(tablayout,viewpager){
                tab,position ->
            when(position){
                0->
                    tab.text="CONVERT"
                1->
                    tab.text="LEARN"
            }

        }.attach()

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.share->
                Toast.makeText(context?.applicationContext, "Share", Toast.LENGTH_SHORT)
            R.id.privacy_policy->
                Toast.makeText(context?.applicationContext, "Privacy Policy", Toast.LENGTH_SHORT).show()
            R.id.About->
                Toast.makeText(context?.applicationContext, "About", Toast.LENGTH_SHORT).show()
            R.id.rate_app->
                Toast.makeText(context?.applicationContext, "Rate App", Toast.LENGTH_SHORT).show()
        }
        true

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_menu,menu)
        return super.onCreateOptionsMenu(menu,inflater)
    }
}
