package me.chenfuduo.mymarketpro.adapter;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.BitmapUtils;

import java.util.List;

import me.chenfuduo.mymarketpro.R;
import me.chenfuduo.mymarketpro.bean.AppInfo;
import me.chenfuduo.mymarketpro.holder.BaseViewHolder;
import me.chenfuduo.mymarketpro.http.HttpHelper;
import me.chenfuduo.mymarketpro.protocol.AppProtocol;
import me.chenfuduo.mymarketpro.utils.BitmapHelper;
import me.chenfuduo.mymarketpro.utils.UIUtils;

/**
 * Created by chenfuduo on 2015/10/3.
 */
public class AppAdapter extends DefaultAdapter<AppInfo> {

    ListView listView;

    public AppAdapter(List<AppInfo> appInfos,ListView listView) {
        super(appInfos,listView);
        this.listView = listView;
    }

    @Override
    public BaseViewHolder<AppInfo> getHolder() {
        ViewHolder viewHolder = null;
        if (viewHolder == null){
            viewHolder = new ViewHolder();
        }
        return viewHolder;
    }


    @Override
    public void onInnerItemClick(int position) {
        Toast.makeText(UIUtils.getContext(),"position:" + position,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected List<AppInfo> onload() {
        AppProtocol appProtocol = new AppProtocol();
        List<AppInfo> appInfoList = appProtocol.load(datas.size());
        datas.addAll(appInfoList);
        return appInfoList;
    }




    static class ViewHolder extends BaseViewHolder<AppInfo>{
        ImageView item_icon;
        TextView item_title, item_size, item_bottom;
        RatingBar item_rating;

        @Override
        public View initView() {
            View convertView = View.inflate(UIUtils.getContext(), R.layout.list_item, null);
            this.item_icon = (ImageView) convertView.findViewById(R.id.item_icon);
            this.item_title = (TextView) convertView.findViewById(R.id.item_title);
            this.item_size = (TextView) convertView.findViewById(R.id.item_size);
            this.item_bottom = (TextView) convertView.findViewById(R.id.item_bottom);
            this.item_rating = (RatingBar) convertView.findViewById(R.id.item_rating);
            return convertView;
        }

        @Override
        public void refreshView(AppInfo data) {
            this.item_title.setText(data.getName());
            String size = Formatter.formatFileSize(UIUtils.getContext(), data.getSize());
            this.item_size.setText(size);
            this.item_bottom.setText(data.getDes());

            float stars = data.getStars();
            this.item_rating.setRating(stars);
            // Glide.with(UIUtils.getContext()).load(HttpHelper.URL + "image?name=" + appInfo.getIconUrl()).into(viewHolder.item_icon);

            BitmapUtils bitmapUtils = BitmapHelper.getInstance();
            bitmapUtils.display(this.item_icon, HttpHelper.URL + "image?name=" + data.getIconUrl());

        }


    }

}
