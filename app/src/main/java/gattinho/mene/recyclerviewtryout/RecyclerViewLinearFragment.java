package gattinho.mene.recyclerviewtryout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

/**
 * Created by edsonmenegatti on 10/24/15.
 */
public class RecyclerViewLinearFragment extends RecyclerViewFragment {

	private static final String TAG = "RecyclerViewFragmnt";

	public static Fragment newInstance(ArrayList<String> countryName) {
		Bundle arguments = new Bundle();
		arguments.putStringArrayList("data", countryName);

		final RecyclerViewLinearFragment recyclerViewLinearFragment = new RecyclerViewLinearFragment();
		recyclerViewLinearFragment.setArguments(arguments);

		return recyclerViewLinearFragment;
	}

	@Override
	protected void setupRecyclerView() {
		final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mRecyclerView.getContext(), ORIENTATION, false);
		mRecyclerView.setAdapter(new MyAdapter(data));
		mRecyclerView.setLayoutManager(linearLayoutManager);
	}
}
