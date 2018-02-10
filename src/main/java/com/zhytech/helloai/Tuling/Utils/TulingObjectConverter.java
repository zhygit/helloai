package com.zhytech.helloai.Tuling.Utils;


import com.zhytech.helloai.Tuling.Beans.MenuItem;
import com.zhytech.helloai.Tuling.Beans.TuliingRespone;
import com.zhytech.helloai.WX.Service.impl.CoreServiceImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TulingObjectConverter {

    public static Logger logger = LoggerFactory.getLogger(TulingObjectConverter.class);


    public TuliingRespone converter(String str) {
        TuliingRespone tuliingRespone = new TuliingRespone();
        try {
            JSONObject ob = new JSONObject(str);
            tuliingRespone.setText(ob.getString("text"));
            tuliingRespone.setCode(ob.getString("code"));
            if(ob.has("url")){
                tuliingRespone.setUrl(ob.getString("url"));
            }
            switch (tuliingRespone.getCode()) {
                case "100000":
                    logger.info("Tuling Return MsgType : "+"100000");
                    logger.info(tuliingRespone.getText());
                case "308000":
                    if (ob.has("list")) {
                        String menuListString = ob.getString("list");
                        JSONArray menuList = new JSONArray(menuListString);

                        List<MenuItem> list = new ArrayList<>();
                        for (int i =0 ;i<menuList.length();i++) {
                            MenuItem menuItem = new MenuItem();
                            JSONObject tempObject = menuList.getJSONObject(i);
                            menuItem.setName(tempObject.getString("name"));
                            menuItem.setDetailurl(tempObject.getString("detailurl"));
                            menuItem.setIcon(tempObject.getString("icon"));
                            menuItem.setInfo(tempObject.getString("info"));
                            logger.info(menuItem.toString());
                            list.add(menuItem);
                        }
                        tuliingRespone.setList(list);



                    }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tuliingRespone;
    }


    public static void main(String args[]) {
        TulingObjectConverter tulingObjectConverter = new TulingObjectConverter();
//        String string = "{\"code\":308000,\"text\":\"亲，已帮您找到菜谱信息\",\"list\":[{\"name\":\"宫保鸡丁\",\"icon\":\"http://s2.cdn.xiachufang.com/12fce0ae893611e6a9a10242ac110002_551w_551h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分7.8 3623人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/100520161/?ref=tuling\"},{\"name\":\"宫保鸡丁！最正宗最讲究的做法！\",\"icon\":\"http://s2.cdn.xiachufang.com/4fc9a98e8a8c11e6b87c0242ac110003_4608w_3072h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分7.9 1885人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/101761223/?ref=tuling\"},{\"name\":\"宫保鸡丁(家常版)\",\"icon\":\"http://s1.cdn.xiachufang.com/b917a46af36711e6947d0242ac110002_1177w_1178h.jpg@2o_50sh_1pr_1l_280w_190h_1c_1e_90q_1wh\",\"info\":\"评分8.1 428人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/102205755/?ref=tuling\"},{\"name\":\"【中餐厅】张亮版宫保鸡丁\",\"icon\":\"http://s2.cdn.xiachufang.com/1e52fbade83d4e28b5d42f0bb37f84e4_3360w_2240h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分8.2 591人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/102752353/?ref=tuling\"},{\"name\":\"宫保鸡丁，照着做好吃哭\",\"icon\":\"http://s2.cdn.xiachufang.com/5af636c05f2243959659bd82b52603b1_395w_221h.gif?imageView2/1/w/280/h/190/interlace/1/q/90/format/gif/.gif\",\"info\":\"评分7.7 33人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/102870754/?ref=tuling\"},{\"name\":\"宫保鸡丁\",\"icon\":\"http://s2.cdn.xiachufang.com/a306be15a21149a7b76a50fd73b65294_1560w_2080h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分8.6 26人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/102760550/?ref=tuling\"},{\"name\":\"【中餐厅】亮大厨教做宫保鸡丁『多图详解』\",\"icon\":\"http://s2.cdn.xiachufang.com/7c64e3d66415438b8ef65ba1da68d487_1280w_720h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分8.0 2132人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/102426239/?ref=tuling\"},{\"name\":\"宫保鸡丁\",\"icon\":\"http://s2.cdn.xiachufang.com/214256f2873911e6a9a10242ac110002_600w_400h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分7.4 4787人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/1000430/?ref=tuling\"},{\"name\":\"宫保鸡丁\",\"icon\":\"http://s2.cdn.xiachufang.com/1196fd1e86f011e6a9a10242ac110002_450w_675h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分8.0 1887人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/12892/?ref=tuling\"},{\"name\":\"宫保鸡丁\",\"icon\":\"http://s1.cdn.xiachufang.com/214ccd58877f11e6b87c0242ac110003_533w_800h.jpg@2o_50sh_1pr_1l_280w_190h_1c_1e_90q_1wh\",\"info\":\"评分7.8 320人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/1067246/?ref=tuling\"},{\"name\":\"秘诀是雪碧的宫保鸡丁\",\"icon\":\"http://s2.cdn.xiachufang.com/68dc5f1288ce11e6a9a10242ac110002_650w_650h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分7.8 1251人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/100437011/?ref=tuling\"},{\"name\":\"宫保鸡丁 Gong Bao Chiken\",\"icon\":\"http://s2.cdn.xiachufang.com/8db9819289a611e6a9a10242ac110002_800w_533h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分8.1 791人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/100577506/?ref=tuling\"},{\"name\":\"家常宫保鸡丁\",\"icon\":\"http://s2.cdn.xiachufang.com/058b699ef4a811e6bc9d0242ac110002_1395w_1047h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分7.6 101人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/101719329/?ref=tuling\"},{\"name\":\"辣子鸡丁\",\"icon\":\"http://s1.cdn.xiachufang.com/376784668af911e6b87c0242ac110003_4608w_3072h.jpg@2o_50sh_1pr_1l_280w_190h_1c_1e_90q_1wh\",\"info\":\"评分8.1 475人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/101812675/?ref=tuling\"},{\"name\":\"宫保鸡丁\",\"icon\":\"http://s2.cdn.xiachufang.com/5c2ec43e88e811e6a9a10242ac110002_750w_728h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90\",\"info\":\"评分7.6 855人下厨\",\"detailurl\":\"http://m.xiachufang.com/recipe/100461836/?ref=tuling\"}]}";
//        Object o = tulingObjectConverter.converter(string);
    }

}
