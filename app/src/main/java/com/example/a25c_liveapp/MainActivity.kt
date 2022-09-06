package com.example.a25c_liveapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
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

        /**
         * LINKS für SnapHelper Positioning
         * https://medium.com/over-engineering/detecting-snap-changes-with-androids-recyclerview-snaphelper-9e9f5e95c424
         * https://stackoverflow.com/questions/42878132/snaphelper-item-position
         */

        // LayoutManager hat Überblick über das Layout
        val layoutManager = binding.fanRecycler.layoutManager

//        binding.snapButton.setOnClickListener {
//            val snapView = snapHelper.findSnapView(layoutManager)
//            val snapPosition = snapView?.let { layoutManager?.getPosition(it) }
//            binding.homeItemText.text = snapPosition.toString()
//        }

        // der OnScrollListener beobachtet Scrollvorgänge
        binding.fanRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            // diese Funktion wird nach jedem Scroll durchgeführt
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // SnapView speichert die aktuell gesnapte View
                val snapView = snapHelper.findSnapView(layoutManager)

                // SnapPosition speichert die Position der gesnapten View
                val snapPosition = snapView?.let { layoutManager?.getPosition(it) }
                if (snapPosition != null) {
                    binding.homeItemText.text = fans[snapPosition].name
                }
            }
        })
    }
}
