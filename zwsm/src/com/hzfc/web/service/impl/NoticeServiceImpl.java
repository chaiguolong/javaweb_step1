package com.hzfc.web.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import net.sf.json.JSONArray;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import com.hzfc.utils.TablesNameConstants;
import com.hzfc.web.entity.Notice;
import com.hzfc.web.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	/**
	 * 静态更新过来的领证公告列表
	 */
	private static List<Notice> noticelist;

	@SuppressWarnings( { "unchecked", "deprecation" })
	@Override
	public List<String> selectNoticeList() {
		try {
			RPCServiceClient serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			EndpointReference targetEPR = new EndpointReference(
					TablesNameConstants.GETLZGG_URL);
			options.setTo(targetEPR);
			options.setProperty(HTTPConstants.CHUNKED, false);
			long timeout = 2 * 60 * 1000;
			options.setTimeOutInMilliSeconds(timeout);
			QName qname = new QName("http://soar.hzfc.com/fwdj/wwsupport",
					"getLzgg");
			// Object object = serviceClient.invokeBlocking(qname, new
			// Object[]{},new Class[]{o.getClass()})[0];
//			long start = System.currentTimeMillis();
			OMElement object = serviceClient.invokeBlocking(qname,
					new Object[] {});
//			long end = System.currentTimeMillis();
//			System.out.println("run time:" + (end - start) + "ms");
			JSONArray array = JSONArray.fromObject(object.toString().split("<return>")[1].split("</return>")[0]);
			noticelist = JSONArray.toList(array, Notice.class);
			List<String> result = new ArrayList<String>();
			for (int i = 0; i < noticelist.size() && i < 10; i++) {
				Notice n = noticelist.get(i);
				result.add(n.toString());
			}
			serviceClient.cleanupTransport();
			return result;
		} catch (AxisFault e) {
			e.printStackTrace();
			String notice = "<td align=\"left\">暂无数据</td>";
			List<String> result = new ArrayList<String>();
			result.add(notice);
			return result;
		}
	}

	@Override
	public String planquery(String name, String slbh) {
		// 开始偿试远程服务调用
		try {
			byte[] bs = name.trim().getBytes("GBK");

			String new_name = new String(bs, "ISO-8859-1");
			RPCServiceClient serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			EndpointReference targetEPR = new EndpointReference(
					TablesNameConstants.GETBZCX_URL);
			options.setTo(targetEPR);
			QName qname = new QName("http://soar.hzfc.com/fwdj/wwsupport",
					"getBzcxv2");//getBzcxv2通过证件编号查询
			// Object object = serviceClient.invokeBlocking(qname, new
			// Object[]{},new Class[]{o.getClass()})[0];
			OMElement object = serviceClient.invokeBlocking(qname, new Object[] {
					slbh.trim(), new_name });
			String str = object.toString();
			String json = str.split("<return>")[1].split("</return>")[0];
			serviceClient.cleanupTransport();
			System.out.println(json);
			return json;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		return null;
	}
}