package com.xiaoqi.androidpdf;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaoqi.pdftools.PDFView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		PDFView pdfView  = findViewById(R.id.pdf);
		String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
//		pdfView.fromFile(new File(rootPath + "/test.pdf")).load();
		pdfView.fromUrl("http://e.fooww.com/EstateSalesContract/1/%E7%BE%A4%E7%AE%A1%E7%90%86%E7%A7%98%E7%B1%8D.pdf",
				rootPath, "1.pdf").load();
	}
}
