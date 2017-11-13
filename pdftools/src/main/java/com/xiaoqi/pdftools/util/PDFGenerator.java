package com.xiaoqi.pdftools.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaoqi on 2017/11/13.
 */

public class PDFGenerator {
	//每个页面间的距离
	public static int BORDER_WIDTH = 2;

	public static boolean generatePdfFromImage(String pdfPath, List<String> imagePathList){
		boolean result = false;
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
			//设置pdf背景
			PdfBackground event = new PdfBackground();
			writer.setPageEvent(event);
			document.open();
			for (int i = 0; i < imagePathList.size(); i++) {
				String path = imagePathList.get(i);
				if(!new File(path).exists()){
					new FileNotFoundException(path + " is not exists").printStackTrace();
					continue;
				}
				document.newPage();
				Image img = Image.getInstance(path);
				//设置图片缩放到A4纸的大小
				img.scaleToFit(PageSize.A4.getWidth() - BORDER_WIDTH * 2, PageSize.A4.getHeight() - BORDER_WIDTH * 2);
				//设置图片的显示位置（居中）
				img.setAbsolutePosition((PageSize.A4.getWidth() - img.getScaledWidth()) / 2, (PageSize.A4.getHeight() - img.getScaledHeight()) / 2);
				document.add(img);
			}
			result = true;
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return result;
	}

	public static boolean generatePdfFromText(String text){
		boolean result = false;
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(android.os.Environment.getExternalStorageDirectory() + File.separator + "iTextTest" + File.separator + "HelloWorld.pdf"));
			document.open();
			document.add(new Paragraph(text));
			result = true;
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return result;
	}
}
