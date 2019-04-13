package com.isofh.his.util;

import com.isofh.his.dto.base.ResponseMsg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {

    public static void writeResponse(HttpServletResponse response, ResponseMsg responseMsg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(Util.writeValueAsString(responseMsg));
    }
}
