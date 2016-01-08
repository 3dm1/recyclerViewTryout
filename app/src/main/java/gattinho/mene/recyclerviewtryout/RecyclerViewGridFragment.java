package gattinho.mene.recyclerviewtryout;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by edsonmenegatti on 10/24/15.
 */
public class RecyclerViewGridFragment extends RecyclerViewFragment {

	private static final String TAG = "RecyclerViewFragmnt";

	public static Fragment newInstance(ArrayList<String> countryName) {
		Bundle arguments = new Bundle();
		arguments.putStringArrayList("data", countryName);

		final RecyclerViewGridFragment recyclerViewLinearFragment = new RecyclerViewGridFragment();
		recyclerViewLinearFragment.setArguments(arguments);

		return recyclerViewLinearFragment;
	}

	@Override
	protected void setupRecyclerView() {
		final GridLayoutManager gridLayoutManager = new GridLayoutManager(mRecyclerView.getContext(), 100, ORIENTATION, false);
		final GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
			@Override
			public int getSpanSize(int position) {
				int spanSize = getTextSpanCount(data.get(position), mRecyclerView.getContext());
				Log.e(TAG, "getSpanSize position: " + position + " span size: " + spanSize);

				return spanSize;
			}

			@Override
			public int getSpanIndex(int position, int spanCount) {
				final int spanIndex = super.getSpanIndex(position, spanCount);
				Log.e(TAG, "getSpanIndex position: " + position + " spanCount: " + spanCount + " spanIndex: " + spanIndex);
				return spanIndex;
			}

			@Override
			public int getSpanGroupIndex(int adapterPosition, int spanCount) {
				Log.e(TAG, "getSpanGroupIndex adapterPosition: " + adapterPosition + " spanCount: " + spanCount);
				return super.getSpanGroupIndex(adapterPosition, spanCount);
			}

		};
		gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
		spanSizeLookup.setSpanIndexCacheEnabled(false);

		mRecyclerView.setAdapter(new MyAdapter(data));
		mRecyclerView.setLayoutManager(gridLayoutManager);
	}

	private int getTextSpanCount(String s, Context context) {
		final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

		Paint mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setTextSize(getResources().getDimensionPixelSize(R.dimen.text_size) + 5);


		float textSize = mPaint.measureText(s, 0, s.length());
		float textPadding = densityToPixel(3 * 2, displayMetrics);
		float margin = densityToPixel(2 * 2, displayMetrics);

		return (int) Math.min(100 * (textSize + textPadding + margin) / mRecyclerView.getWidth(), 100);
	}

	private float densityToPixel(int densityValue, DisplayMetrics displayMetrics) {
		return densityValue * displayMetrics.scaledDensity;
	}
}
