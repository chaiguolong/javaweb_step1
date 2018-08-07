package cn.itheima.xml.dom4j;

import java.util.List;

import org.junit.Test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestDom4j_001{
    @Test
    @SuppressWarnings("unchecked")
    public void testReadWebXML(){
        try{
            //1.获取解析器
            SAXReader SAXReader = new SAXReader();
            //2.获得document文档对象
            Document doc = SAXReader.read("/Users/mymac/Documents/JavaWeb01/WEB11_XML/src/cn/itheima/xml/schema/web.xml");
            //3.获取根元素
            Element rootElement = doc.getRootElement();
            System.out.println(rootElement.getName());  //获取根元素的名称
            System.out.println(rootElement.attributeValue("version"));//获取根元素中的属性值
            //4.获取根元素下的子元素
            List<Element> childElements = rootElement.elements();
            //5.遍历子元素
            for(Element element : childElements){
                //6.判断元素名称为servlet的元素
                if("servlet".equals(element.getName())){
                    //7.获取servlet-name元素
                    Element servletName = element.element("servlet-name");
                    //8.获取servlet-class元素
                    Element servletClass = element.element("servlet-class");
                    System.out.println(servletName.getText());
                    System.out.println(servletClass.getText());
                }
            }
        }catch(DocumentException e){
            e.printStackTrace();
        }
    }
}
