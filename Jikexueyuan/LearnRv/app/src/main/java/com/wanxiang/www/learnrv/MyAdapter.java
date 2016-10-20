package com.wanxiang.www.learnrv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by JM on 2016/8/26.
 */
class MyAdapter extends RecyclerView.Adapter {

	class ViewHolder extends RecyclerView.ViewHolder {
		private View root;
		private TextView tvTitle, tvContent;

		public ViewHolder(View root) {
			super(root);

			tvTitle = (TextView) root.findViewById(R.id.tvTitle);
			tvContent = (TextView) root.findViewById(R.id.tvContent);

		}

		public TextView getTvContent() {
			return tvContent;
		}

		public TextView getTvTitle() {
			return tvTitle;
		}
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell, null));
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		ViewHolder vh = (ViewHolder) holder;
		CellData cd = data[position];
		vh.getTvTitle().setText(cd.title);
		vh.getTvContent().setText(cd.content);
	}

	@Override
	public int getItemCount() {
		//return data.length;
		return data.length;
	}

	//	private String[] data = new String[]{"Hello", "jike", "jm"};
	private CellData[] data = new CellData[]{new CellData("jike", "IT职业教育"),
	new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错"),
			new CellData("新闻", "这个新闻真不错")};

}
