package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddContact extends AppCompatActivity {
    private Integer RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        //getting the button and editText from xml
        final Typeface font = Typeface.createFromAsset( getAssets(), "fonts/fontawesome-webfont.ttf" );
        Button addContact = (Button)findViewById( R.id.button );
        EditText name = (EditText)findViewById( R.id.nombre );
        EditText descripcion = (EditText)findViewById( R.id.descripcion );
        EditText telefono = (EditText)findViewById( R.id.telefono );
        addContact.setTypeface(font);

        //source: https://www.viralpatel.net/pick-image-from-galary-android-app/
        ImageView imageView = findViewById(R.id.imageView);
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
                //Contacto c = new Contacto(3,"")
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
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
}