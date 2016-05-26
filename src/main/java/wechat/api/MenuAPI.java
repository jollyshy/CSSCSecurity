package wechat.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import wechat.bean.menu.Menu;
import wechat.bean.menu.MenuButtons;
import wechat.bean.menu.TrymatchResult;
import wechat.bean.menu.selfmenu.CurrentSelfmenuInfo;
import wechat.client.LocalHttpClient;
import wechat.bean.BaseResult;
import wechat.util.JsonUtil;

import java.nio.charset.Charset;

/**
 * Created by wenqing on 2016/5/22.
 */
public class MenuAPI extends BaseAPI {

    /**
     * �����˵�
     * @param access_token
     * @param menuJson �˵�json ���� ����{\"button\":[{\"type\":\"click\",\"name\":\"���ո���\",\"key\":\"V1001_TODAY_MUSIC\"},{\"type\":\"click\",\"name\":\"���ּ��\",\"key\":\"V1001_TODAY_SINGER\"},{\"name\":\"�˵�\",\"sub_button\":[{\"type\":\"view\",\"name\":\"����\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"��Ƶ\",\"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"��һ������\",\"key\":\"V1001_GOOD\"}]}]}
     * @return
     */
    public static BaseResult menuCreate(String access_token,String menuJson){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/menu/create")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(menuJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * �����˵�
     * @param access_token
     * @param menuButtons
     * @return
     */
    public static BaseResult menuCreate(String access_token,MenuButtons menuButtons){
        String str = JsonUtil.toJSONString(menuButtons);
        return menuCreate(access_token, str);
    }

    /**
     * ��ȡ�˵�
     * @param access_token
     * @return
     */
    public static Menu menuGet(String access_token){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/menu/get")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, Menu.class);
    }

    /**
     * ɾ���˵�
     * @param access_token
     * @return
     */
    public static BaseResult menuDelete(String access_token){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/menu/delete")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }


    /**
     * ��ȡ�Զ���˵�����
     * ���ӿڽ����ṩ���ںŵ�ǰʹ�õ��Զ���˵������ã�
     * ������ں���ͨ��API�������õĲ˵����򷵻ز˵��Ŀ������ã�
     * ��������ں����ڹ���ƽ̨����ͨ����վ���ܷ����˵���
     * �򱾽ӿڷ�����Ӫ�����õĲ˵����á�
     * @param access_token
     * @return
     */
    public static CurrentSelfmenuInfo get_current_selfmenu_info(String access_token){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/get_current_selfmenu_info")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, CurrentSelfmenuInfo.class);
    }

    /**
     * �������Ի��˵�
     * @param access_token
     * @param menuButtons
     * @return
     */
    public static BaseResult menuAddconditional(String access_token,MenuButtons menuButtons){
        String menuJson = JsonUtil.toJSONString(menuButtons);
        return menuAddconditional(access_token, menuJson);
    }

    /**
     * �������Ի��˵�
     * @since 2.7.1
     * @param access_token
     * @param menuJson
     * @return
     */
    public static BaseResult menuAddconditional(String access_token,String menuJson){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/menu/addconditional")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(menuJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }

    /**
     * ɾ�����Ի��˵�
     * @param access_token
     * @param menuid
     * @return
     */
    public static BaseResult menuDelconditional(String access_token,String menuid){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/menu/delconditional")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity("{\"menuid\":\"" + menuid + "\"}", Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }

    /**
     * ���Ը��Ի��˵�ƥ����
     * @param access_token
     * @param user_id �����Ƿ�˿��OpenID��Ҳ�����Ƿ�˿��΢�źš�
     * @return
     */
    public static TrymatchResult menuTrymatch(String access_token,String user_id){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/menu/trymatch")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity("{\"user_id\":\""+user_id+"\"}",Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, TrymatchResult.class);
    }


}
