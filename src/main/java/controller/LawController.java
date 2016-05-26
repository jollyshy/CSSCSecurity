package controller;

import controller.dto.ResponsePackDto;
import javafx.beans.binding.ObjectBinding;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wenqing on 2016/5/26.
 */
@Controller
@RequestMapping(value = "/law")
public class LawController extends BaseController {

//    ?limit=10��ָ�����ؼ�¼������
//    ?offset=10��ָ�����ؼ�¼�Ŀ�ʼλ�á�
//    ?page=2&per_page=100��ָ���ڼ�ҳ���Լ�ÿҳ�ļ�¼����
//    ?sortby=name&order=asc��ָ�����ؽ�������ĸ����������Լ�����˳��
//    ?animal_type_id=1��ָ��ɸѡ����

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponsePackDto add(@RequestBody Object law) {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody ResponsePackDto delete(@RequestParam int id) {
        return null;
    }

    //
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ResponsePackDto edit(@RequestBody Object law) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponsePackDto query(
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "sortby", required = false, defaultValue = "publishtime") String sortby,
            @RequestParam(value = "order", required = false, defaultValue = "descs") String order,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "publish_institution", required = false)String publish_institution) {
        return null;
    }

}
