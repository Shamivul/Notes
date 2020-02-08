package com.example.notes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.R;
import com.example.notes.modelClass.Note;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteItemAdapter extends RecyclerView.Adapter<NoteItemAdapter.NoteViewHolder> {

    //vars
    private Context mContext;
    private ArrayList<Note> mNoteArrayList;
    private OnNoteClickListener onNoteClickListener;

    public NoteItemAdapter(Context mContext, ArrayList<Note> mNoteArrayList) {
        this.mContext = mContext;
        this.mNoteArrayList = mNoteArrayList;
        this.onNoteClickListener = (OnNoteClickListener)mContext;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(mContext).inflate(R.layout.note_view_holder_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        //Binding view holder
        holder.bindTo();
    }

    @Override
    public int getItemCount() {
        return mNoteArrayList.size();
    }

    //view holder class for the NotesItemAdapter
    protected class NoteViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.note_container)
        ConstraintLayout noteContainer;

        @BindView(R.id.item_title_tv)
        TextView noteTitleTv;

        @BindView(R.id.item_created_time_tv)
        TextView noteCreatedTimeTv;

        @BindView(R.id.notes_item_description_tv)
        TextView noteDescriptionTv;

        //create viewHolder constructor which creates itemView for the item
        private NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            noteContainer.setOnClickListener(view -> onNoteClickListener.onNoteClick(mNoteArrayList.get(getAdapterPosition())));
        }

        //binding item to item view
        private void bindTo(){
            noteTitleTv.setText(mNoteArrayList.get(getAdapterPosition()).getTitle());
            noteCreatedTimeTv.setText(mNoteArrayList.get(getAdapterPosition()).getCreatedAt());
            noteDescriptionTv.setText(mNoteArrayList.get(getAdapterPosition()).getNoteText());
        }
    }

    public interface OnNoteClickListener{
        void  onNoteClick(Note note);
    }

}
