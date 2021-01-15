package com.code.apps.album.ui.dashboard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.code.apps.album.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

import static com.code.apps.album.R.id.imv_foto;

public class DashboardFragment extends Fragment {

    private static final int RESULT_OK = -1 ;
    private DashboardViewModel dashboardViewModel;

    private StorageReference mStorageRef;
    private DatabaseReference databaseReference;


    private static final int RC_GALLERY=21;
    private static final int RC_CAMERA=22;

    private static final int RP_CAMERA=121;
    private static final int RP_STORAGE=122;
    private static final String IMAGE_DIRECTORY="/My Album";
    private static final String MyPhoto="my_photo";

    private static final String PATH_PROFILE="profile";
    private static final String PATH_PHOTO_URL="photoUrl";

    private String mCurrentPhotoPath;
    private Uri mPhotoSelectedUri;

    private  ImageView imageView;
    private Button btn_borrar;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        
        //fromGlallery();
        imageView=root.findViewById(R.id.imv_foto);
       // btn_borrar=root.findViewById(R.id.btn_eliminar);

        return root;
    }

    private void fromGlallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,RC_GALLERY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RC_GALLERY:
                    if (data != null) {
                        mPhotoSelectedUri = data.getData();

                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), mPhotoSelectedUri);
                            imageView.setImageBitmap(bitmap);
                            btn_borrar.setVisibility(View.GONE);
                           // mTextMessage.setText(R.string.main_message_question_upload);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                        /*Bundle extras = data.getExtras();
                    Bitmap bitmap = (Bitmap)extras.get("data");*/

            /*    mPhotoSelectedUri = addPicGallery();

                try {
                    Bitmap bitmap;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        bitmap = ImageDecoder.decodeBitmap(ImageDecoder
                                .createSource(this.getContentResolver(), mPhotoSelectedUri));
                    } else {
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),
                                mPhotoSelectedUri);
                    }
                    imgPhoto.setImageBitmap(bitmap);
                    btnDelete.setVisibility(View.GONE);
                    mTextMessage.setText(R.string.main_message_question_upload);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    /*try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),
                                mPhotoSelectedUri);
                        imgPhoto.setImageBitmap(bitmap);
                        btnDelete.setVisibility(View.GONE);
                        mTextMessage.setText(R.string.main_message_question_upload);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                break;*/



            }
        }

