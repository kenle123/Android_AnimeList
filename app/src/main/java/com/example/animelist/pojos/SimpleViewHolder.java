package com.example.animelist.pojos;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder {

    private TextView simpleTextView;


    public SimpleViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);
        simpleTextView = (TextView) itemView.findViewById(R.id.simple_text);
    }

    public void bindData(final SimpleViewModel viewModel) {
        simpleTextView.setText(viewModel.getSimpleText());
    }
}
