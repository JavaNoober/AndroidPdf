# AndroidPdf
android pdf一个工具类，可以阅读pdf文件，也可以生成pdf文件

##显示pdf：
		###pdfView.fromUrl(path, file.getAbsolutePath(), "/" + fileName, false)
				   .swipeVertical(true)
				   .load();
##生成pdf：
###ArrayList<String> tempPath = new ArrayList<>();
...
...
PDFGenerator.generatePdfFromImage(file.getAbsolutePath() + '/' + fileName, tempPath);
