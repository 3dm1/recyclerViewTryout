package gattinho.mene.recyclerviewtryout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by edsonmenegatti on 10/24/15.
 */
public class MyAdapter extends RecyclerView.Adapter {

	private ArrayList<String> mData;

	public MyAdapter(ArrayList<String> data) {
		mData = data;
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		@Bind(R.id.recycler_view_item)
		public TextView mTextView;

		public ViewHolder(View v) {
			super(v);
			ButterKnife.bind(this, v);
		}
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tile_layout, parent, false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		((ViewHolder) holder).mTextView.setText(mData.get(position));
	}

	@Override
	public int getItemCount() {
		return mData.size();
	}
}
