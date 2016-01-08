package gattinho.mene.recyclerviewtryout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

/**
 * Created by edsonmenegatti on 10/24/15.
 */
public class RecyclerViewStaggeredFragment extends RecyclerViewFragment {

	private static final String TAG = "RecyclerViewFragmnt";

	public static Fragment newInstance(ArrayList<String> countryName) {
		Bundle arguments = new Bundle();
		arguments.putStringArrayList("data", countryName);

		final RecyclerViewStaggeredFragment recyclerViewLinearFragment = new RecyclerViewStaggeredFragment();
		recyclerViewLinearFragment.setArguments(arguments);

		return recyclerViewLinearFragment;
	}

	@Override
	protected void setupRecyclerView() {
		final StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, ORIENTATION);
		mRecyclerView.setAdapter(new MyAdapter(data));
		mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
	}
}
