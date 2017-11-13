/**
 * Copyright 2014 Joan Zapata
 *
 * This file is part of Android-pdfview.
 *
 * Android-pdfview is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Android-pdfview is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Android-pdfview.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.xiaoqi.pdftools.listener;

import android.graphics.Canvas;

/**
 * This interface allows an extern class to draw
 * something on the PDFView canvas, above all images.
 */
public interface OnDrawListener {

    /**
     * This method is called when the PDFView is
     * drawing its view.
     * <p/>
     * The page is starting at (0,0)
     * @param canvas        The canvas on which to draw things.
     * @param pageWidth     The width of the current page.
     * @param pageHeight    The height of the current page.
     * @param displayedPage The current page index
     */
    void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage);
}
