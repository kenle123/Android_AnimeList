package com.example.animelist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animelist.pojos.Anime;

import org.w3c.dom.Text;

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    private TextView simpleTextView;

    public SimpleViewHolder(final View itemView) {
        super(itemView);
        simpleTextView = (TextView) itemView.findViewById(R.id.list_item);
    }

    public void bindData(final Anime viewModel) {
        simpleTextView.setText(viewModel.getAnimeName());
    }
}
