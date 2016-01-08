package gattinho.mene.recyclerviewtryout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	@Bind(R.id.sliding_tab_strip)
	PagerSlidingTabStrip mSlidingTabStrip;

	@Bind(R.id.view_pager)
	ViewPager mViewPager;

	ArrayList<String> countryName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		mSlidingTabStrip.setViewPager(mViewPager);

		countryName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.countries_array)));
		Log.e(TAG, "onCreate " + countryName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public class MyAdapter extends FragmentPagerAdapter {

		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
				case 0:
					return RecyclerViewLinearFragment.newInstance(countryName);
				case 1:
					return RecyclerViewGridFragment.newInstance(countryName);
				case 2:
					return RecyclerViewStaggeredFragment.newInstance(countryName);
				case 3:
					return LayoutFragment.newInstance();
			}

			return RecyclerViewLinearFragment.newInstance(countryName);
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
				case 0:
					return "Linear";
				case 1:
					return "Grid";
				case 2:
					return "Staggered";
				case 3:
					return "Layout";
			}

			return "Nameless";
		}
	}
}
