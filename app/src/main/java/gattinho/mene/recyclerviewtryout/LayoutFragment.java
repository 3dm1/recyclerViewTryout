package gattinho.mene.recyclerviewtryout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by edsonmenegatti on 10/26/15.
 */
public class LayoutFragment extends Fragment {

	public static Fragment newInstance() {
		return new LayoutFragment();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.line_layout, container, false);
		ButterKnife.bind(this, view);
		return view;
	}
}
