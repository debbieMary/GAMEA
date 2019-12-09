package elalto.gamea.map.canchas.view.Adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;



public abstract class BaseRecyclerViewAdapter<T, VHG extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VHG> {

    protected ArrayList<T> recyclerObjects;

    protected ObjectRecyclerListener<T> listener;

    public BaseRecyclerViewAdapter() {
        super();
        recyclerObjects = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        if(recyclerObjects==null){
            return 0;
        }
        return recyclerObjects.size();
    }

    @Override
    public void onBindViewHolder(VHG holder, final int position) {
        final T object = recyclerObjects.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onObjectSelectListener(position, object);
                }
            }
        });
    }

    public void setListener(ObjectRecyclerListener<T> recyclerListener) {
        this.listener = recyclerListener;
    }

    public void addNormalObjects(List<T> items) {
        for (T item:items){
            addNormalObject(item);
        }
    }

    public void addNormalObject(T item){
        recyclerObjects.add(item);
        notifyItemInserted(getItemCount() - 1);
        notifyDataSetChanged();
    }

    public void updateItem(T item,int position){
        recyclerObjects.set(position,item);
        notifyItemChanged(position);
    }

    /**
     * Clear all recyclerView
     */
    public void clear() {
        recyclerObjects.clear(); //clear map
        notifyDataSetChanged(); //let your adapter know about the changes and reload view.
    }

    public interface ObjectRecyclerListener<T> {
        void onObjectSelectListener(int position, T object);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        listener = null;
    }
}