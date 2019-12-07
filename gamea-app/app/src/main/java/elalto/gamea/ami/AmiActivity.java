package elalto.gamea.ami;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import elalto.gamea.R;

public class AmiActivity extends AppCompatActivity {
    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ami);
        browser = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = browser.getSettings();
        browser.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        browser.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        browser.getSettings().setAppCacheEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);
        browser.loadUrl("http://amibolivia.com");
    }
}
