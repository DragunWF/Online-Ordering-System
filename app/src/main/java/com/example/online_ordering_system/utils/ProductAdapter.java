package com.example.online_ordering_system.utils;

import static androidx.core.content.ContextCompat.startActivity;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.online_ordering_system.MainActivity;
import com.example.online_ordering_system.R;
import com.example.online_ordering_system.activities.ItemsActivity;
import com.example.online_ordering_system.data.Product;

import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private final List<Product> productList;
    private Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productName;
        private TextView productPrice;
        private ImageView productImage;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            productName = view.findViewById(R.id.cardItemsName);
            productPrice = view.findViewById(R.id.cardItemsPrice);
            productImage = view.findViewById(R.id.cardItemsPic);
        }

        public TextView getProductName() {
            return productName;
        }

        public TextView getProductPrice() {
            return productPrice;
        }

        public ImageView getProductImage() {
            return productImage;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public ProductAdapter(Context context, List<Product> dataSet) {
        this.context = context;
        productList = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycleview_card, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Product product = productList.get(position);

        final int CHAR_LIMIT = 15;
        String productName = product.getName();
        if (productName.length() > CHAR_LIMIT) {
            int endIndex = CHAR_LIMIT - 2;
            for (int i = CHAR_LIMIT - 1; i >= 1; i--) {
                if (productName.charAt(i) != ' ') {
                    endIndex = i;
                    break;
                }
            }
            productName = productName.substring(0, endIndex) + "-";
        }

        viewHolder.getProductName().setText(productName);
        viewHolder.getProductPrice().setText(product.getPrice() + " PHP");
        viewHolder.getProductImage().setOnClickListener(v -> {
            Intent intent = new Intent(context, ItemsActivity.class);
            intent.putExtra("id", product.getId());
            context.startActivity(intent);
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return productList.size();
    }
}
