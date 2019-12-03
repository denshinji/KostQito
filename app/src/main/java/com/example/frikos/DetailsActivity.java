package com.example.frikos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    TextView deskrip;
    TextView nama;
    TextView harga;
    TextView ukuran;
    TextView kamarmandi;
    TextView alamat;
    TextView wifi;
    TextView ac;
    ImageView image;

    Button contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        String Nama,Harga,Images,Ukuran,Kamarmandi,Alamat,Wifi,Ac;

        Nama=getIntent().getStringExtra("nama");
        Harga=getIntent().getStringExtra("harga");
        Images=getIntent().getStringExtra("image");
        Ukuran=getIntent().getStringExtra("ukuran");
        Kamarmandi=getIntent().getStringExtra("kamarmandi");
        Alamat=getIntent().getStringExtra("alamat");
        Wifi=getIntent().getStringExtra("wifi");
        Ac=getIntent().getStringExtra("ac");
        nama=(TextView)findViewById(R.id.namaa);
        harga=(TextView)findViewById(R.id.hargaa);
        image= (ImageView) findViewById(R.id.image_view);
        ukuran=(TextView)findViewById(R.id.tv_ukuran);
        kamarmandi=(TextView)findViewById(R.id.tv_kamarmandi);
        alamat=(TextView)findViewById(R.id.tv_alamat);
        wifi=(TextView)findViewById(R.id.tv_wifi);
        ac=(TextView)findViewById(R.id.tv_ac);
        contact = (Button)findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "082284220439";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
            }
        });


        Glide.with(getApplicationContext())
                .load(Images)
                .apply(new RequestOptions())
                .into(image);
        nama.setText(Nama);
        harga.setText(Harga);
        ukuran.setText(Ukuran);
        kamarmandi.setText(Kamarmandi);
        alamat.setText(Alamat);
        wifi.setText(Wifi);
        ac.setText(Ac);



    }

    @Override
    public void onClick(View view) {

    }
}
