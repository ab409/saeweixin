package com.using.weixin.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpRequestTools {

	/**
	 * ����URL������е�html��Ϣ
	 * 
	 * @param url
	 * @return
	 */
	public static String getHttpClientHtml(String url,String code) {
		String html = null;
		HttpClient httpClient = new DefaultHttpClient();// ����httpClient����
		HttpGet httpget = new HttpGet(url);// ��get��ʽ�����URL
		try {
			HttpResponse responce = httpClient.execute(httpget);// �õ�responce����
			int resStatu = responce.getStatusLine().getStatusCode();// ������
			if (resStatu == HttpStatus.SC_OK) {// 200���� �����Ͳ���
				// �����Ӧʵ��
				HttpEntity entity = responce.getEntity();
				if (entity != null) {
					html = new String(EntityUtils.toString(entity).getBytes("ISO-8859-1"),code);// ���htmlԴ����
				}
			}
		} catch (Exception e) {
			System.out.println("���ʡ�" + url + "�������쳣!");
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return html;
	}
	
	
	/**
	 * Ĭ�ϱ����ȡHTML����
	 * @param url
	 * @return
	 */
	public static String getHttpClientHtml(String url) {
		String html = null;
		HttpClient httpClient = new DefaultHttpClient();// ����httpClient����
		HttpGet httpget = new HttpGet(url);// ��get��ʽ�����URL
		try {
			HttpResponse responce = httpClient.execute(httpget);// �õ�responce����
			int resStatu = responce.getStatusLine().getStatusCode();// ������
			if (resStatu == HttpStatus.SC_OK) {// 200���� �����Ͳ���
				// �����Ӧʵ��
				HttpEntity entity = responce.getEntity();
				if (entity != null) {
					html = EntityUtils.toString(entity);// ���htmlԴ����
				}
			}
		} catch (Exception e) {
			System.out.println("���ʡ�" + url + "�������쳣!");
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return html;
	}
}
