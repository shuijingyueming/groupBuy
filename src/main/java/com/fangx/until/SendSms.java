package com.fangx.until;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class SendSms {
	
	public static JSONObject fasongdx(String accessKeyId,String accessSecret,String phone,String qm,String yzm,String dxdz,String dxmb) {
        DefaultProfile profile = DefaultProfile.getProfile("default", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(dxdz);
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
//        request.putQueryParameter("RegionId", "default");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", qm);
        request.putQueryParameter("TemplateCode", dxmb);
        request.putQueryParameter("TemplateParam", "{'code':"+yzm+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            String result = response.getData();
            //System.out.println(result);
            return JSONObject.fromObject(result);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
		
		return null;
    }
	
}
