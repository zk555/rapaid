package com.ruyuan.rapid.core.helper;


import com.ruyuan.rapid.common.enums.ResponseCode;
import com.ruyuan.rapid.core.context.RapidResponse;

import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

/**
 * <B>主类名称：</B>ResponseHelper<BR>
 * <B>概要说明：</B>响应的辅助类<BR>
 * @author JiFeng
 * @since 2021年12月8日 下午9:53:15
 */
public class ResponseHelper {

	/**
	 * <B>方法名称：</B>getHttpResponse<BR>
	 * <B>概要说明：</B>获取响应对象<BR>
	 * @author JiFeng
	 * @since 2021年12月8日 下午10:01:43
	 * @param responseCode
	 * @return FullHttpResponse
	 */
	public static FullHttpResponse getHttpResponse(ResponseCode responseCode) {
		RapidResponse resRapidResponse = RapidResponse.buildRapidResponse(responseCode);
		DefaultFullHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, 
				HttpResponseStatus.INTERNAL_SERVER_ERROR,
				Unpooled.wrappedBuffer(resRapidResponse.getContent().getBytes()));
		
		httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON + ";charset=utf-8");
		httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, httpResponse.content().readableBytes());
		return httpResponse;
	}
	
	
	
}
