package com.tool.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2018/7/25.
 */
public class TestMain {
    public static void main(String[] args) {
//        InputStream in = FileUtil.getFileSource("C:\\Users\\admin\\Desktop\\01.xlsx");
//        List<Map<String,Object>> list = ExcelUtil.getBean(in);
//        if(list != null){
//            for (Map<String,Object> map : list) {
//                System.out.println(map.toString());
//            }
//        }else{
//            System.out.println("代码异常");
//        }

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:bean.xml","classpath*:myBatis_config.xml");
		
        context.start();
        TestService service = (TestService) context.getBean("testService");
        service.getTrump();
        service.getTableInfo("t_player_capability");
        context.stop();
    }
}
