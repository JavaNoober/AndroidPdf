package com.xiaoqi.androidpdf;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.xiaoqi.pdftools.PDFView;
import com.xiaoqi.pdftools.listener.OnDrawListener;

import java.io.File;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		PDFView pdfView  = findViewById(R.id.pdf);
		String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
		pdfView.fromFile(new File(rootPath + "/test.pdf")).onDraw(new OnDrawListener() {
			@Override
			public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
				Log.e("ccc", displayedPage + "");
				if(displayedPage == 0){
					Paint paint = new Paint();
					paint.setColor(Color.BLACK);
					canvas.drawLine(0, 0, 100, 100 , paint);
				}
			}
		}).load();
//		pdfView.fromUrl("http://e.fooww.com/EstateSalesContract/1/%E7%BE%A4%E7%AE%A1%E7%90%86%E7%A7%98%E7%B1%8D.pdf",
//				rootPath, "1.pdf", true).swipeVertical(true).onDraw(new OnDrawListener() {
//			@Override
//			public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
//				Log.e("ccc", displayedPage + "");
//			}
//		}).load();
	}
}
