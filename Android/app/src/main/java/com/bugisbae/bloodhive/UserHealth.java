package com.bugisbae.bloodhive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;

public class UserHealth extends AppCompatActivity {

    LoadingDialog loadingDialog;
    EditText usernameTF,mobileTF,emailTF,addressTF,heightTF,weightTF,ageTF,tatoosTF,alcoholLevelTF,smokingLevelTF,haemoglobinTF,sportsAndGymTF,sleepingHrTF,heartRateTF;
    ToggleButton toggleButton;
    String username,email,address,bloodGrp,mobile;
    ArrayList<String> pastDiseases=new ArrayList<>();

    int height,weight,age,alcoholLevel,smokingLevel,haemoglobin,sleepingHr,heartRate;
    boolean tatoos,sportsAndGym,activeDonor;
    Uri uri;
    CheckBox dis1,dis2,dis3,dis4,dis5,dis6,dis7;
    ImageView aadharCardImg;
    RadioGroup bloodRadioGroup;
    RadioButton blooRadioButton;


    private static final int IMAGE_REQUEST=1;

    FirebaseAuth firebaseAuth;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    DatabaseReference donorData,userData;
    String user_id;
    boolean flag=false;


    public void Update(View view){
        username=usernameTF.getText().toString();
        if(username.isEmpty()){
            usernameTF.setError("Required.");
            usernameTF.setFocusable(true);
            flag=true;
        }

        mobile=mobileTF.getText().toString();
        if(mobile.isEmpty()){
            mobileTF.setError("Required.");
            mobileTF.setFocusable(true);
            flag=true;
        }

        email=emailTF.getText().toString();
        if(email.isEmpty()){
            emailTF.setError("Required.");
            emailTF.setFocusable(true);
            flag=true;
        }

        address=addressTF.getText().toString();
        if(address.isEmpty()){
            addressTF.setError("Required.");
            addressTF.setFocusable(true);
            flag=true;
        }

        int bloodSelected=bloodRadioGroup.getCheckedRadioButtonId();
        blooRadioButton=findViewById(bloodSelected);
        if(bloodSelected==-1)
        {
            Toast.makeText(this, "Choose Your Blood Group", Toast.LENGTH_SHORT).show();
            flag=true;
        }
        else
            bloodGrp=blooRadioButton.getText().toString();

        /*pastDiseases=pastDiseasesTF.getText().toString();
        if(pastDiseases.isEmpty()){
            pastDiseasesTF.setError("Required.");
            pastDiseasesTF.setFocusable(true);
        }*/
        String tatooString= tatoosTF.getText().toString().toLowerCase();
        tatoos= tatooString.equals("yes");

        String sportsAndGymString= sportsAndGymTF.getText().toString().toLowerCase();
        sportsAndGym= sportsAndGymString.equals("yes");


        try {
            haemoglobin = Integer.parseInt(haemoglobinTF.getText().toString());
            if (haemoglobin < 1 ) {
                haemoglobinTF.setError("Fill Proper Data.");
                haemoglobinTF.setFocusable(true);
                flag=true;
            }
        }
        catch (NumberFormatException ignored) {
            haemoglobinTF.setError("Fill Proper Data.");
        }

        try {
            height=Integer.parseInt( heightTF.getText().toString() );
            if(height<=120 || height>=210) {
                heightTF.setError("Fill Proper Data.");
                heightTF.setFocusable(true);
                flag=true;
            }
        }
        catch (NumberFormatException ignored) {
            heightTF.setError("Fill Proper Data.");
        }

        try {
            weight=Integer.parseInt(weightTF.getText().toString());
            if(weight<20 || weight>150) {
                weightTF.setError("Fill Proper Data.");
                weightTF.setFocusable(true);
                flag=true;
            }
        }
        catch (NumberFormatException ignored) {
            weightTF.setError("Fill Proper Data.");
        }

        try {
            age=Integer.parseInt(ageTF.getText().toString());
            if(age<0 || age>100) {
                ageTF.setError("Fill Proper Data.");
                ageTF.setFocusable(true);
                flag=true;
            }
        }
        catch (NumberFormatException ignored) {
            ageTF.setError("Fill Proper Data.");
        }

        try {
            alcoholLevel=Integer.parseInt(alcoholLevelTF.getText().toString());
            if(alcoholLevel<0 || alcoholLevel>5) {
                alcoholLevelTF.setError("Fill Proper Data.");
                alcoholLevelTF.setFocusable(true);
                flag=true;
            }
        }
        catch (NumberFormatException ignored) {
            alcoholLevelTF.setError("Fill Proper Data.");

        }

        try {
            smokingLevel=Integer.parseInt(smokingLevelTF.getText().toString());
            if(smokingLevel<0 || smokingLevel>5) {
                smokingLevelTF.setError("Fill Proper Data.");
                smokingLevelTF.setFocusable(true);
                flag=true;
            }
        }
        catch (NumberFormatException ignored) {
            smokingLevelTF.setError("Fill Proper Data.");
        }

        try {
            sleepingHr=Integer.parseInt(sleepingHrTF.getText().toString());
            if(sleepingHr<0 || sleepingHr>24) {
                sleepingHrTF.setError("Fill Proper Data.");
                sleepingHrTF.setFocusable(true);
                flag=true;
            }
        }
        catch (NumberFormatException ignored) {
            sleepingHrTF.setError("Fill Proper Data.");

        }

        try {
            heartRate=Integer.parseInt(heartRateTF.getText().toString());
            if(heartRate<0 || heartRate>150) {
                heartRateTF.setError("Fill Proper Data.");
                heartRateTF.setFocusable(true);
                flag=true;
            }
        }
        catch (NumberFormatException ignored) {
            heartRateTF.setError("Fill Proper Data.");
        }

        if(dis1.isChecked())
            pastDiseases.add(dis1.getText().toString());
        if(dis2.isChecked())
            pastDiseases.add(dis2.getText().toString());
        if(dis3.isChecked())
            pastDiseases.add(dis3.getText().toString());
        if(dis4.isChecked())
            pastDiseases.add(dis4.getText().toString());
        if(dis5.isChecked())
            pastDiseases.add(dis5.getText().toString());
        if(dis6.isChecked())
            pastDiseases.add(dis6.getText().toString());
        if(dis7.isChecked())
            pastDiseases.add(dis7.getText().toString());

        if(uri==null)
            Toast.makeText(this, "Upload Your Aadhar", Toast.LENGTH_SHORT).show();
        else if(!flag){
            loadingDialog.startLoadingDialog();
            user user=new user(user_id,username,email,mobile,address,weight,height,age,bloodGrp,pastDiseases,tatoos,alcoholLevel,smokingLevel,haemoglobin,sportsAndGym,sleepingHr,heartRate,activeDonor);
            uploadUserDetails(user);
        }
    }

    private void uploadUserDetails(user user) {
        loadingDialog.dismissDialog();
        donorData.child(bloodGrp).child(user_id).setValue(user);

        StorageReference reference=storageReference.child("donor").child(user_id);
        reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                loadingDialog.dismissDialog();
                Toast.makeText(UserHealth.this,"Data Successfully Updated",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingDialog.dismissDialog();
                Toast.makeText(UserHealth.this, "Failed"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progress = (100.0*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                loadingDialog.message("Uploaded "+(int)progress+"%");

            }
        });

        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void ChooseImage(View view){
        Intent intent= new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                aadharCardImg.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_health);

        loadingDialog=new LoadingDialog(this);
        usernameTF=findViewById(R.id.userName);
        mobileTF=findViewById(R.id.mobile);
        emailTF=findViewById(R.id.email);
        addressTF=findViewById(R.id.address);
        heightTF=findViewById(R.id.height);
        weightTF=findViewById(R.id.weight);
        ageTF=findViewById(R.id.age);
        bloodRadioGroup=findViewById(R.id.bloodRadBtn);
        tatoosTF=findViewById(R.id.tatoos);
        alcoholLevelTF=findViewById(R.id.alcohol);
        smokingLevelTF=findViewById(R.id.smoking);
        haemoglobinTF=findViewById(R.id.haemoglobin);
        sportsAndGymTF=findViewById(R.id.sportsAndGym);
        sleepingHrTF=findViewById(R.id.sleepHr);
        heartRateTF=findViewById(R.id.heartRate);
        toggleButton=findViewById(R.id.toggleButton);
        dis1=findViewById(R.id.dis1);
        dis2=findViewById(R.id.dis2);
        dis3=findViewById(R.id.dis3);
        dis4=findViewById(R.id.dis4);
        dis5=findViewById(R.id.dis5);
        dis6=findViewById(R.id.dis6);
        dis7=findViewById(R.id.dis7);
        aadharCardImg=findViewById(R.id.aadharCardImg);

        firebaseAuth=FirebaseAuth.getInstance();
        donorData= FirebaseDatabase.getInstance().getReference().child("Manit").child("Donor");

        FirebaseUser user=firebaseAuth.getCurrentUser();
        assert user != null;
        user_id=user.getUid();

        userData=FirebaseDatabase.getInstance().getReference().child("Manit").child("Users");

        userData.child(user_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                username=String.valueOf(snapshot.child("user_name").getValue());
                Log.i("Name: ", username);
                email=String.valueOf(snapshot.child("email").getValue());
                Log.i("Email: ", email);
                usernameTF.setText(username);
                emailTF.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseStorage=FirebaseStorage.getInstance();
        storageReference=firebaseStorage.getReference();





    }
}
