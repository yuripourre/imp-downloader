package com.imp.network;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileDownloader {

	private static final int BUFFER_SIZE = 1024;
	
	public static void download(String url, String output) throws IOException { 
		URL link = new URL(url);

		InputStream in = new BufferedInputStream(link.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[BUFFER_SIZE];
		int n = 0;
		while (-1!=(n=in.read(buf))) {
			out.write(buf, 0, n);
		}
		out.close();
		in.close();
		byte[] response = out.toByteArray();

		FileOutputStream fos = new FileOutputStream(output);
		fos.write(response);
		fos.close();
	}
	
}
