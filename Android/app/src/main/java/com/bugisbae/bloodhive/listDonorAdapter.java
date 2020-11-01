package com.bugisbae.bloodhive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class listDonorAdapter extends RecyclerView.Adapter<listDonorAdapter.ViewHolder> {

    private List<listDonorModel> listDonorModelList;
    private RecViewItemClickListener recViewItemClickListener;


    listDonorAdapter(List<listDonorModel> listDonorModelList){
        this.listDonorModelList=listDonorModelList;
    }

    @NonNull
    @Override
    public listDonorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listDonorAdapter.ViewHolder holder, int position) {
        String userName=listDonorModelList.get(position).getUsername();
        float bloodQuality=listDonorModelList.get(position).getBloodQuality();
        String bloodGrp=listDonorModelList.get(position).getBloodGrp();
        boolean isOK=listDonorModelList.get(position).isOK();

        holder.setDonorDetails(userName,bloodQuality,bloodGrp,isOK);
    }

    @Override
    public int getItemCount() {
        return listDonorModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView username,bloodGrp,bloodQuality,isOK;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.userName);
            bloodGrp=itemView.findViewById(R.id.bloodGrp);
            bloodQuality=itemView.findViewById(R.id.bloodQuality);
            isOK=itemView.findViewById(R.id.isOK);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recViewItemClickListener.onItemClickListener(getAdapterPosition());
                }
            });*/
        }

        void setDonorDetails(String name,float quality,String bloodtype,boolean isok){
            username.setText(name);
            bloodQuality.setText(String.valueOf(quality));
            bloodGrp.setText(bloodtype);
            isOK.setText(isok?"Fit":"Unfit");
        }
    }
}
