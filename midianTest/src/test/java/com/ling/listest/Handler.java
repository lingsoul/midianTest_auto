package com.ling.listest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.net.Socket;


public class Handler implements Runnable {
	private Socket client = null;

	public Handler(Socket myClient) {
		client = myClient;
	}

	@Override
	public void run() {
		DataInputStream input = null;
		DataOutputStream output = null;
		byte[] reqData = null;
		byte[] resData = null;

		// 请求数据流 和 相应数据流
		try {
			input = new DataInputStream(client.getInputStream());
			output = new DataOutputStream(client.getOutputStream());

			try {
				reqData = getOtipRequest(input);
			} catch (EOFException e) { // 针对F5探测请求进行处理
				return;
			}
			String reqStr = new String(reqData, "GBK");
			String lsh = reqStr.substring(30, 52);
			File f_lsh = new File("D:\\test\\" + lsh);
			f_lsh.createNewFile();
			resData = "Z02089920150626111514    0                                                                                                                                                                                                                                                                   1"
					.getBytes("GBK");
			writeResponseData(resData, output);
		} catch (Exception e) {
			// byte[] errResData="ERRORResponse".getBytes("GBK");
			// writeResponseData(errResData, output);
		} finally {
			try {
				if (output != null) {
					output.close();
				}
			} catch (IOException ioe) {
			}
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException ioe) {
			}
			try {
				if (client != null) {
					client.close();
				}
			} catch (IOException ioe) {
			}
		}
	}

	private byte[] getOtipRequest(DataInputStream input) throws Exception {
		int len1 = input.readByte() & 0xff;
		int len2 = input.readByte() & 0xff;
		int total = len1 * 256 + len2;
		byte[] otipRequest = new byte[total];
		input.readFully(otipRequest);
		return otipRequest;
	}

	private void writeResponseData(byte[] responseData,
			DataOutputStream output) {
		try {
			// 计算报文长度
			int len = responseData.length;
			int bwcd1 = len / 256;
			int bwcd2 = len % 256;
			output.writeByte(bwcd1);
			output.writeByte(bwcd2);
			output.write(responseData);
			output.flush();
		} catch (Exception e) {
			// g.error("返回文件服务响应信息异常", e);
		}
	}
}