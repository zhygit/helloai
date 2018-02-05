package com.zhytech.helloai.WX.Utils;

import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.zhytech.helloai.WX.beans.message.resp.Article;
import com.zhytech.helloai.WX.beans.message.resp.MusicMessageResp;
import com.zhytech.helloai.WX.beans.message.resp.NewsMessageResp;
import com.zhytech.helloai.WX.beans.message.resp.TextMessageResp;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.thoughtworks.xstream.XStream;


/**
 * Created by zhy on 2017/4/30.
 */
public class XmlUtils {

    public static Logger logger = LoggerFactory.getLogger(XmlUtils.class);
//    private XStream xstream = null;


    public static Map<String, String> parseXmlToMap(String xml) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        Element root = document.getRootElement();
        Map<String, String> map = new HashMap<String, String>();
        List<Element> elementList = root.elements();
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static String textMessageToXml(TextMessageResp textMessageResp) {
//        xstream = new XStream();
        xstream.alias("xml", textMessageResp.getClass());
        return xstream.toXML(textMessageResp);


    }

    public static String musicMessageToXml(MusicMessageResp musicMessageResp) {
//        xstream = new XStream();
        xstream.alias("xml", musicMessageResp.getClass());
        return xstream.toXML(musicMessageResp);

    }

    public static String newsMessageToXml(NewsMessageResp newsMessageResp) {
//        xstream = new XStream();
        xstream.alias("xml", newsMessageResp.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessageResp);

    }

    private static XStream xstream = new XStream(new XppDriver(){
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out){
                boolean cdata=true;

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    }else {
                        writer.write(text);
                    }
                }
            };

        }
    });


    public static void main(String args[]) {
        String xml = "<xml>\n" +
                "    <ToUserName><![CDATA[gh_c527188d36dc]]></ToUserName>\n" +
                "    <FromUserName><![CDATA[oDdzSvsDO59Fy_4_5U9KfJ8tjumY]]></FromUserName>\n" +
                "    <CreateTime>1493564197</CreateTime>\n" +
                "    <MsgType><![CDATA[text]]></MsgType>\n" +
                "    <Content><![CDATA[aaaa]]></Content>\n" +
                "    <MsgId>6414809381057026287" +
                "<Content><![CDATA[bbbb]]></Content></MsgId>\n" +
                "    <Encrypt><![CDATA[QNJnyC77Ca/9N7kW7q5CGFvsGQTHQCALmpNPO/Y3cghyJE0APnqPDLZLF7zf8aOxoMRgeSbzk6E4RqA03X8GtzvyYhzNgLEoQjU+PNzIgPcEGd39OsayINR8SdfhR1yCm7+JkquHPCgj/qPsJZedVNy3Tt+pcRkVNl4O1Zby+3ugYnEg7e92tJuH+/bDF5R2R5eX0pNkoCJKDtumpi9Uo/bxATDvfWrsQiBPWUxpptOuebizkjZoghUQSUmEhRDQ07HtNdfGZxzIXNxkSoHe2UDx91CyK/tucxOflxHOwUebY2BD14pwD4fbA2/eRqgzJDcSpGr2hPLLYWIaa2KECjFEbLpjRHdlpIPjheSV+p3NC7qiyvDc+FD4GQ0xShRo8YG20sagTgH7ROdsfmLOJ2HZhDM8z+P3m00tJLh/mcs=]]></Encrypt>\n" +
                "</xml>";
        XmlUtils xmlUtils = new XmlUtils();
        try {
            Map<String, String> map = xmlUtils.parseXmlToMap(xml);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                logger.info("<" + entry.getKey() + ", " + entry.getValue() + ">");
            }
            logger.info("===========");
            Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                logger.info("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
//        logger.info("encrypt: "+encrypt);
//        logger.info("content: "+content1);
//        logger.info("content2: "+content2);


    }


}
