package elalto.gamea.map.canchas.view.Calendar;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import elalto.gamea.R;

/**
 * Created by FRAMGIA\pham.van.khac on 07/07/2016.
 */
public class DayView extends FrameLayout {

    private TextView mTextHour;

    private LinearLayout mSeparateHour;

    public DayView(Context context) {
        super(context);
        init(null);
    }

    public DayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.view_day, this, true);

        mTextHour = (TextView) findViewById(R.id.text_hour);
        mSeparateHour = (LinearLayout) findViewById(R.id.separate_hour);
    }

    public void setText(String text) {
        mTextHour.setText(text);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public float getHourTextWidth() {
        LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) mTextHour.getLayoutParams();
        float measureTextWidth = mTextHour.getPaint().measureText("12:00".toString());
        return Math.max(measureTextWidth, param.width)
                + param.getMarginEnd()
                + param.getMarginStart();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public float getHourTextHeight() {
        return (new StaticLayout("12:00", mTextHour.getPaint(), (int) getHourTextWidth(),
                Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true)).getHeight();
    }

    public float getSeparateHeight() {
        return mSeparateHour.getLayoutParams().height;
    }

    public void setHourSeparatorAsInvisible() {
        mSeparateHour.setVisibility(INVISIBLE);

    }

    public void setHourSeparatorAsVisible() {
        mSeparateHour.setVisibility(VISIBLE);
    }

    public void setHourSeparatorIsVisible(boolean b) {
        if (b) {
            setHourSeparatorAsVisible();
        } else {
            setHourSeparatorAsInvisible();
        }

    }

}
