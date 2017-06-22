package com.sample.moreteapots;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by wyf on 2017/6/22.
 */

public class GpuInfoActivity extends Activity {
    /**
     * Called when the activity is starting.  This is where most initialization
     * should go: calling {@link #setContentView(int)} to inflate the
     * activity's UI, using {@link #findViewById} to programmatically interact
     * with widgets in the UI, calling
     * {@link #managedQuery(Uri, String[], String, String[], String)} to retrieve
     * cursors for data being displayed, etc.
     * <p>
     * <p>You can call {@link #finish} from within this function, in
     * which case onDestroy() will be immediately called without any of the rest
     * of the activity lifecycle ({@link #onStart}, {@link #onResume},
     * {@link #onPause}, etc) executing.
     * <p>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutInflater().inflate(R.layout.gpu_info,null));

        String info = getIntent().getStringExtra("GpuInfo");
        String[] infoArr = info.split(",");
        String[] extensArr = infoArr[2].split(":");
        String[] extensions = extensArr[1].split(" ");
        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.list_view_item, R.id.textView3, extensions);

        TextView tv_renderer = (TextView) findViewById(R.id.textView);
        TextView tv_vendor = (TextView) findViewById(R.id.textView2);
        TextView tv_extens = (TextView) findViewById(R.id.textView4);
        ListView lv_extensions = (ListView) findViewById(R.id.listview);

        tv_renderer.setText(infoArr[0]);
        tv_vendor.setText(infoArr[1]);
        tv_extens.setText(extensArr[0]+"("+(extensions.length-1)+") : ");
        lv_extensions.setAdapter(adapter);
    }
}
