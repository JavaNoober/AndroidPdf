package com.xiaoqi.pdftools.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Created by Administrator on 2017/11/13.
 */

public class PdfBackground extends PdfPageEventHelper {
	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		//设置pdf背景色为白色
		PdfContentByte canvas = writer.getDirectContentUnder();
		Rectangle rect = document.getPageSize();
		canvas.setColorFill(BaseColor.WHITE);
		canvas.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
		canvas.fill();

		//设置pdf页面内间距
		PdfContentByte canvasBorder = writer.getDirectContent();
		Rectangle rectBorder = document.getPageSize();
		rectBorder.setBorder(Rectangle.BOX);
		rectBorder.setBorderWidth(2);
		rectBorder.setBorderColor(BaseColor.WHITE);
		rectBorder.setUseVariableBorders(true);
		canvasBorder.rectangle(rectBorder);
	}
}