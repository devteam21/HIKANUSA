package id.zapnut.project.HIKANUSA.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import id.zapnut.project.HIKANUSA.Activity.SubCategory;
import id.zapnut.project.HIKANUSA.Item.AuthorList;
import id.zapnut.project.HIKANUSA.R;
import id.zapnut.project.HIKANUSA.Util.Method;
import id.zapnut.project.HIKANUSA.Util.PopUpAds;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.ViewHolder> {

    private Activity activity;
    private List<AuthorList> authorLists;
    private Method method;
    private int columnWidth;

    public AuthorAdapter(Activity activity, List<AuthorList> authorLists) {
        this.activity = activity;
        this.authorLists = authorLists;
        method = new Method(activity);
        columnWidth = method.getScreenWidth();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.author_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.imageView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, columnWidth / 2));
        holder.view.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, columnWidth / 2));

        holder.textView_Name.setText(authorLists.get(position).getAuthor_name());

        Picasso.with(activity).load(authorLists.get(position).getAuthor_image())
                .placeholder(R.drawable.placeholder_portable)
                .into(holder.imageView);

        Animation animation = AnimationUtils.loadAnimation(activity,
                R.anim.up_from_bottom_left);
        holder.itemView.startAnimation(animation);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUpAds.ShowInterstitialAds(activity);
                activity.startActivity(new Intent(activity, SubCategory.class)
                        .putExtra("toolbarTitle", authorLists.get(position).getAuthor_name())
                        .putExtra("id", authorLists.get(position).getAuthor_id())
                        .putExtra("type", "author"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return authorLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RoundedImageView imageView;
        private RelativeLayout relativeLayout;
        private View view;
        private TextView textView_Name;


        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (RoundedImageView) itemView.findViewById(R.id.imageView_authorName_author_adapter);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout_author_adapter);
            view = (View) itemView.findViewById(R.id.view_authorName_author_adapter);
            textView_Name = (TextView) itemView.findViewById(R.id.textView_authorName_author_adapter);

        }
    }
}
