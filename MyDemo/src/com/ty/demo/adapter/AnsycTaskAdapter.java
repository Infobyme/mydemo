package com.ty.demo.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ty.demo.R;

import org.w3c.dom.Text;

import java.util.Observable;

/**
 * Created by Administrator on 2015/7/30.
 */
public class AnsycTaskAdapter extends BaseAdapter {


    private Context mContext;

    public AnsycTaskAdapter(Context context) {

        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 500;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AnsycTaskHodler hodler = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_ansyctask, null);

            hodler = new AnsycTaskHodler();

            hodler.image = (ImageView) convertView.findViewById(R.id.item_ansyctask_image);
            hodler.message = (TextView) convertView.findViewById(R.id.item_ansyctask_message);
            convertView.setTag(hodler);
        } else {
            hodler = (AnsycTaskHodler) convertView.getTag();
        }

        new TestAsyncTask(hodler.image).execute("ce");

        hodler.message.setText(position+"");

        return convertView;
    }


    public class TestAsyncTask extends AsyncTask<String,Void,Integer>{

        private ImageView mImageView;

        public TestAsyncTask(ImageView imageView){
            mImageView=imageView;
        }

        @Override
        protected Integer doInBackground(String... params) {

            int sum=0;

            for (int i=0;i<1000*100;i++){
                sum += i * 1l;
            }
            return sum;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            mImageView.setImageBitmap(BitmapFactory.decodeResource(
                    mContext.getResources(), R.drawable.ic_launcher, null));
        }
    }

    class AnsycTaskHodler {
        TextView message;
        ImageView image;
    }
}
