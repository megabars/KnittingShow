package ru.mezentsev.knittingshow

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*
import ru.mezentsev.knittingshow.dto.Knitting
import ru.mezentsev.knittingshow.fragment.KnittingListFragment
import ru.mezentsev.knittingshow.fragment.ProfileFragment

class MainActivity : AppCompatActivity(), KnittingListFragment.OnListFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onListFragmentInteraction(item: Knitting?) {
        // todo клик
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener loadFragment(KnittingListFragment())
            }
            R.id.navigation_add -> {
                return@OnNavigationItemSelectedListener loadFragment(KnittingListFragment())
            }
            R.id.navigation_person -> {
                return@OnNavigationItemSelectedListener loadFragment(ProfileFragment())
            }
        }
        false
    }

    /**
     * Загрузка фрагмента
     */
    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
