package com.example.online_ordering_system.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Product;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    // To prevent errors from calling getItemCount(). I set this by default
    private final List<Product> cartItems;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemName;
        private TextView itemQuantity;

        private ImageView plusBtn;
        private ImageView minusBtn;
        private ImageView removeBtn;

        private RadioButton selectBtn;

        private int productStock;
        private int productQuantity = 1;

        public ViewHolder(View view) {
            super(view);

            itemName = view.findViewById(R.id.itemNameCart);
            itemQuantity = view.findViewById(R.id.numOfItemCart);

            plusBtn = view.findViewById(R.id.plusCartBtn);
            minusBtn = view.findViewById(R.id.minusCartBtn);
            removeBtn = view.findViewById(R.id.removeBtnFromCart);
            selectBtn = view.findViewById(R.id.selectItemOnCartBtn);
        }

        public TextView getItemName() {
            return itemName;
        }

        public RadioButton getSelectBtn() {
            return selectBtn;
        }

        public ImageView getRemoveBtn() {
            return removeBtn;
        }

        public void modifyItemQuantity(boolean isAdd) {
            productQuantity = Integer.parseInt(String.valueOf(itemQuantity.getText()));
            if (isAdd) {
                productQuantity++;
            } else {
                productQuantity--;
                if (productQuantity <= 1) {
                    productQuantity = 1;
                }
            }
            itemQuantity.setText(String.valueOf(productQuantity));
        }

        public ImageView getPlusBtn() {
            return plusBtn;
        }

        public ImageView getMinusBtn() {
            return minusBtn;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView
     */
    public CartAdapter(List<Product> cartItems) {
        this.cartItems = cartItems;
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
        Product product = cartItems.get(position);
        viewHolder.getItemName().setText(product.getName());

        viewHolder.getPlusBtn().setOnClickListener(v -> {
            viewHolder.modifyItemQuantity(true);
        });
        viewHolder.getMinusBtn().setOnClickListener(v -> {
            viewHolder.modifyItemQuantity(false);
        });
        viewHolder.getRemoveBtn().setOnClickListener(v -> {
            SessionData.removeCartItem(position);
            CartAdapter.this.notifyItemRemoved(position);
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
