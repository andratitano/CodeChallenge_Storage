package com.andra.codechallenge_storage


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class  MyPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){
    private val pages = listOf(
        LandingPage1(),LandingPage2(),LandingPage3()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Fragment A"
            1 -> "Fragment B"
            else -> "Fragment C"
        }
    }

}