package gattinho.mene.recyclerviewtryout;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by edsonmenegatti on 10/24/15.
 */
public abstract class RecyclerViewFragment extends Fragment {

	private static final String TAG = "RecyclerViewFragmnt";

	@Bind(R.id.recycler_view)
	RecyclerView mRecyclerView;

	ArrayList<String> data = new ArrayList<>();

	protected final int ORIENTATION = OrientationHelper.VERTICAL;

	protected abstract void setupRecyclerView();

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
		ButterKnife.bind(this, view);

		if (getArguments() != null) {
			data = getArguments().getStringArrayList("data");
		}

		setupRecyclerView();

		return view;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.unbind(this);
	}

}
