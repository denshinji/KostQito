package com.example.frikos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListKostAdapter extends RecyclerView.Adapter<ListKostAdapter.ListViewHolder> {
    private ArrayList<Kost> listKost;
    public ListKostAdapter(ArrayList<Kost> list) {
        this.listKost = list;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_kost, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Kost kost = listKost.get(position);
        Glide.with(holder.itemView.getContext())
                .load(kost.getPhoto())
                .apply(new RequestOptions())
                .into(holder.imgPhoto);


        holder.harga=(kost.getHarga());
        holder.nama=(kost.getName());
        holder.images=(kost.getPhoto());
        holder.lokasi=(kost.getAlamat());
        holder.ukuran=(kost.getUkuran());
        holder.kamarmandi=(kost.getKamarmandi());
        holder.alamat=(kost.getAlamat());
        holder.wifi=(kost.getWifi());
        holder.ac=(kost.getAc());
        holder.tvName.setText(kost.getName());
        holder.tvPrice.setText(kost.getHarga());
        holder.tvLokasi.setText(kost.getAlamat());







    }

    @Override
    public int getItemCount() {
        return listKost.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgPhoto;
        Context context;
        RelativeLayout relative;
        String nama,descripsi,harga,alamat,kamarmandi,lokasi,ukuran,wifi,ac;
        String images;

        TextView tvName, tvAddress,tvPrice,tvKamarMandi,tvAlamat,tvLokasi,tvUkuran,tvWifi,tvAc;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            context= itemView.getContext();
            tvUkuran = itemView.findViewById(R.id.tv_ukuran);
            tvLokasi = itemView.findViewById(R.id.tv_lokasi);
            tvKamarMandi= itemView.findViewById(R.id.tv_kamarmandi);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvWifi = itemView.findViewById(R.id.tv_wifi);
            tvAc = itemView.findViewById(R.id.tv_ac);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvPrice= itemView.findViewById(R.id.tv_item_price);
            relative= itemView.findViewById(R.id.tv_relative);
            relative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,DetailsActivity.class);
                    intent.putExtra("nama",nama);
                    intent.putExtra("descripsi",descripsi);
                    intent.putExtra("image",images);
                    intent.putExtra("harga",harga);
                    intent.putExtra("ukuran",ukuran);
                    intent.putExtra("kamarmandi",kamarmandi);
                    intent.putExtra("alamat",alamat);
                    intent.putExtra("wifi",wifi);
                    intent.putExtra("ac",ac);
                    context.startActivity(intent);

                }
            });
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Kost data);
    }
}
