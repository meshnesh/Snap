package com.example.tune.snap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class snap extends ActionBarActivity {

    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap);


//        initialize Image view and buttons
        iv = (ImageView) findViewById(R.id.imageView3);
        Button btnCapture = (Button) findViewById(R.id.button_camera);


//        set listener on capture button

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(c, 0);

            }
        });

    }



    //        Override method onActivityResult used to retrive the image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap m = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(m);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
    }
}
