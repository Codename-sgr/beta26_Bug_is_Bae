package com.bugisbae.bloodhive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListDonor extends AppCompatActivity {
    RecyclerView listDonorRecView;
    String bloodGrp,user_id;
    TextView noDonor;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<user> arrayList=new ArrayList<>();
    List<listDonorModel> listDonorModelList=new ArrayList<>();
    listDonorAdapter listDonorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_donor);

        Intent intent=getIntent();
        bloodGrp=intent.getStringExtra("bloodGrp");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Donor List");
        }

        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("Manit").child("Donor");
        FirebaseAuth mAuth= FirebaseAuth.getInstance();
        FirebaseUser user =mAuth.getCurrentUser();
        user_id=user.getUid();

        noDonor=findViewById(R.id.noDonors);
        listDonorRecView=findViewById(R.id.listDonorRecView);
        listDonorRecView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        listDonorRecView.setLayoutManager(layoutManager);
        showList();
    }

    private void showList() {

        if(bloodGrp.matches("A")){
            databaseReference.child("A").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        user user=dataSnapshot.getValue(user.class);
                        if(user.isOK()){
                            arrayList.add(user);
                        }
                    }

                    for (int i=0;i<arrayList.size();i++){
                        listDonorModelList.add(
                                new listDonorModel(
                                        arrayList.get(i).getUser_name(),
                                        arrayList.get(i).getQualityIndex(),
                                        arrayList.get(i).getBloodGroup(),
                                        arrayList.get(i).isOK));
                    }
                    arrayList.clear();
                    listDonorAdapter=new listDonorAdapter(listDonorModelList);
                    listDonorRecView.setAdapter(listDonorAdapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            databaseReference.child("O").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        user user=dataSnapshot.getValue(user.class);
                        if(user.isOK()){
                            arrayList.add(user);
                        }
                    }

                    if(arrayList.isEmpty()){
                        listDonorRecView.setVisibility(View.INVISIBLE);
                        noDonor.setVisibility(View.VISIBLE);
                    }

                    for (int i=0;i<arrayList.size();i++){
                        listDonorModelList.add(
                                new listDonorModel(
                                        arrayList.get(i).getUser_name(),
                                        arrayList.get(i).getQualityIndex(),
                                        arrayList.get(i).getBloodGroup(),
                                        arrayList.get(i).isOK));
                    }
                    arrayList.clear();
                    listDonorAdapter=new listDonorAdapter(listDonorModelList);
                    listDonorRecView.setAdapter(listDonorAdapter);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else if(bloodGrp.matches("B")){
            databaseReference.child("B").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        user user=dataSnapshot.getValue(user.class);
                        if(user.isOK()){
                            arrayList.add(user);
                        }
                    }


                    for (int i=0;i<arrayList.size();i++){
                        listDonorModelList.add(
                                new listDonorModel(
                                        arrayList.get(i).getUser_name(),
                                        arrayList.get(i).getQualityIndex(),
                                        arrayList.get(i).getBloodGroup(),
                                        arrayList.get(i).isOK));
                    }
                    arrayList.clear();
                    listDonorAdapter=new listDonorAdapter(listDonorModelList);
                    listDonorRecView.setAdapter(listDonorAdapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            databaseReference.child("O").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        user user=dataSnapshot.getValue(user.class);
                        if(user.isOK()){
                            arrayList.add(user);
                        }
                    }

                    if(arrayList.isEmpty()){
                        listDonorRecView.setVisibility(View.INVISIBLE);
                        noDonor.setVisibility(View.VISIBLE);
                    }

                    for (int i=0;i<arrayList.size();i++){
                        listDonorModelList.add(
                                new listDonorModel(
                                        arrayList.get(i).getUser_name(),
                                        arrayList.get(i).getQualityIndex(),
                                        arrayList.get(i).getBloodGroup(),
                                        arrayList.get(i).isOK));
                    }
                    arrayList.clear();
                    listDonorAdapter=new listDonorAdapter(listDonorModelList);
                    listDonorRecView.setAdapter(listDonorAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else if(bloodGrp.matches("AB")){
            databaseReference.child("AB").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        user user=dataSnapshot.getValue(user.class);
                        if(user.isOK()){
                            arrayList.add(user);
                        }
                    }

                    for (int i=0;i<arrayList.size();i++){
                        listDonorModelList.add(
                                new listDonorModel(
                                        arrayList.get(i).getUser_name(),
                                        arrayList.get(i).getQualityIndex(),
                                        arrayList.get(i).getBloodGroup(),
                                        arrayList.get(i).isOK));
                    }
                    arrayList.clear();
                    listDonorAdapter=new listDonorAdapter(listDonorModelList);
                    listDonorRecView.setAdapter(listDonorAdapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            databaseReference.child("A").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        user user=dataSnapshot.getValue(user.class);
                        if(user.isOK()){
                            arrayList.add(user);
                        }
                    }

                    for (int i=0;i<arrayList.size();i++){
                        listDonorModelList.add(
                                new listDonorModel(
                                        arrayList.get(i).getUser_name(),
                                        arrayList.get(i).getQualityIndex(),
                                        arrayList.get(i).getBloodGroup(),
                                        arrayList.get(i).isOK));
                    }
                    arrayList.clear();
                    listDonorAdapter=new listDonorAdapter(listDonorModelList);
                    listDonorRecView.setAdapter(listDonorAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            databaseReference.child("B").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        user user=dataSnapshot.getValue(user.class);
                        if(user.isOK()){
                            arrayList.add(user);
                        }
                    }


                    for (int i=0;i<arrayList.size();i++){
                        listDonorModelList.add(
                                new listDonorModel(
                                        arrayList.get(i).getUser_name(),
                                        arrayList.get(i).getQualityIndex(),
                                        arrayList.get(i).getBloodGroup(),
                                        arrayList.get(i).isOK));
                    }
                    arrayList.clear();
                    listDonorAdapter=new listDonorAdapter(listDonorModelList);
                    listDonorRecView.setAdapter(listDonorAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            databaseReference.child("O").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        user user=dataSnapshot.getValue(user.class);
                        if(user.isOK()){
                            arrayList.add(user);
                        }
                    }

                    if(arrayList.isEmpty()){
                        listDonorRecView.setVisibility(View.INVISIBLE);
                        noDonor.setVisibility(View.VISIBLE);
                    }

                    for (int i=0;i<arrayList.size();i++){
                        listDonorModelList.add(
                                new listDonorModel(
                                        arrayList.get(i).getUser_name(),
                                        arrayList.get(i).getQualityIndex(),
                                        arrayList.get(i).getBloodGroup(),
                                        arrayList.get(i).isOK));
                    }
                    arrayList.clear();
                    listDonorAdapter=new listDonorAdapter(listDonorModelList);
                    listDonorRecView.setAdapter(listDonorAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else if(bloodGrp.matches("O")){
            databaseReference.child("O").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        user user=dataSnapshot.getValue(user.class);
                        if(user.isOK()){
                            arrayList.add(user);
                        }
                    }
                    if(arrayList.isEmpty()){
                        listDonorRecView.setVisibility(View.INVISIBLE);
                        noDonor.setVisibility(View.VISIBLE);
                    }

                    for (int i=0;i<arrayList.size();i++){
                        listDonorModelList.add(
                                new listDonorModel(
                                        arrayList.get(i).getUser_name(),
                                        arrayList.get(i).getQualityIndex(),
                                        arrayList.get(i).getBloodGroup(),
                                        arrayList.get(i).isOK));
                    }
                    arrayList.clear();
                    listDonorAdapter=new listDonorAdapter(listDonorModelList);
                    listDonorRecView.setAdapter(listDonorAdapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}
