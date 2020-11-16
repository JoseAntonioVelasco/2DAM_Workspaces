package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class AddContact extends AppCompatActivity {
    private Integer RESULT_LOAD_IMAGE = 1;
    private Contacto contacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        contacto = getIntent().getParcelableExtra("CONTACTO");

        //getting the button and editText from xml
        final Typeface font = Typeface.createFromAsset( getAssets(), "fonts/fontawesome-webfont.ttf" );
        final Button addContact = (Button)findViewById( R.id.button );
        final Button deleteContact = (Button)findViewById( R.id.button2 );
        final EditText name = (EditText)findViewById( R.id.nombre );
        final EditText descripcion = (EditText)findViewById( R.id.descripcion );
        final EditText telefono = (EditText)findViewById( R.id.telefono );
        addContact.setTypeface(font);deleteContact.setTypeface(font);

        //if we enter here through edit button contacto != null == true
        if(contacto != null){
            //setimageview also
            name.setText(contacto.getNombre());
            descripcion.setText(contacto.getDescripcion());
            telefono.setText(contacto.getTelefono());
        }



        //source: https://www.viralpatel.net/pick-image-from-galary-android-app/
        final ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent i = new Intent(
                        Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contacto != null){
                    Intent main = new Intent();
                    Contacto c = new Contacto(contacto.getId(),imageView.getId(),name.getText().toString(),descripcion.getText().toString(),telefono.getText().toString(),contacto.getBookmarked());

                    main.putExtra("CONTACTO", c);
                    setResult(RESULT_OK, main);
                }else{
                    Contacto c = new Contacto(0,imageView.getId(),name.getText().toString(),descripcion.getText().toString(),telefono.getText().toString(),false);

                    //sending data back to MainActivity
                    Intent main = new Intent();
                    main.putExtra("CONTACTO", c);
                    setResult(RESULT_OK, main);
                }
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, requestCode);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data && isStoragePermissionGranted()) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            // String picturePath contains the path of selected Image
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
    //source: https://stackoverflow.com/questions/33162152/storage-permission-error-in-marshmallow
    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                //Log.v(TAG,"Permission is granted");
                return true;
            } else {
                //Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
           // Log.v(TAG,"Permission is granted");
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            //Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
            //resume tasks needing this permission
        }
    }

}