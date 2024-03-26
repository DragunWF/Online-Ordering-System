package com.example.online_ordering_system.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Product;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<Product> cartItems;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemName;
        private TextView itemQuantity;
        private ImageView plusBtn;
        private ImageView minusBtn;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            itemName = view.findViewById(R.id.itemNameCart);
            itemQuantity = view.findViewById(R.id.numOfItemCart);
            plusBtn = view.findViewById(R.id.plusCartBtn);
            minusBtn = view.findViewById(R.id.minusCartBtn);
        }

        public TextView getItemName() {
            return itemName;
        }

        public void setItemName(TextView itemName) {
            this.itemName = itemName;
        }

        public TextView getItemQuantity() {
            return itemQuantity;
        }

        public void setItemQuantity(TextView itemQuantity) {
            this.itemQuantity = itemQuantity;
        }

        public ImageView getPlusBtn() {
            return plusBtn;
        }

        public void setPlusBtn(ImageView plusBtn) {
            this.plusBtn = plusBtn;
        }

        public ImageView getMinusBtn() {
            return minusBtn;
        }

        public void setMinusBtn(ImageView minusBtn) {
            this.minusBtn = minusBtn;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView
     */
    public CartAdapter(List<Product> cartItems) {
        ;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycleviews_cart, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        // viewHolder.getTextView().setText(localDataSet[position]);
        Product product = cartItems.get(position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
