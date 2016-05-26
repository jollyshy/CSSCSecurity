package wechat.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import wechat.bean.token.Token;
import wechat.client.LocalHttpClient;

/**
 * Created by wenqing on 2016/5/22.
 */
public class TokenAPI extends BaseAPI{
        /**
         * ��ȡaccess_token
         * @param appid
         * @param secret
         * @return
         */
        public static Token token(String appid,String secret){
            HttpUriRequest httpUriRequest = RequestBuilder.post()
                    .setUri(BASE_URI + "/cgi-bin/token")
                    .addParameter("grant_type","client_credential")
                    .addParameter("appid", appid)
                    .addParameter("secret", secret)
                    .build();
            return LocalHttpClient.executeJsonResult(httpUriRequest, Token.class);
        }
}
