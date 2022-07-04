package com.example.a25c_liveapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.a25c_liveapp.adapter.FanAdapter
import com.example.a25c_liveapp.data.Datasource
import com.example.a25c_liveapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fans = Datasource().loadFans()

        binding.fanRecycler.adapter = FanAdapter(this, fans)

        binding.fanRecycler.setHasFixedSize(true)

        // der SnapHelper sorgt dafür dass die RecyclerView pro Item einrastet
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.fanRecycler)
    }
}
