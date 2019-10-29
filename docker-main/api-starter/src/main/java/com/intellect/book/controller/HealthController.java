package com.intellect.book.controller;

import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.token.Action;
import com.intellect.book.base.token.Token;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjianbing
 */
@Api(description = "健康监测")
@RestController
@RequestMapping(value = "/main/health")
@Slf4j
public class HealthController extends BaseController {

    @Value("classpath:/dict.json")
    private Resource areaRes;

    /**
     * 健康检查
     *
     * @return
     */
    @ApiOperation("健康监测")
    @GetMapping("/check")
    @Token(action = Action.SKIP)
    public Object healthCheck() {
//        test();
        return successResponse("OK");
    }

//    private String jsonRead(File file) {
//        Scanner scanner = null;
//        StringBuilder buffer = new StringBuilder();
//        try {
//            scanner = new Scanner(file, "utf-8");
//            while (scanner.hasNextLine()) {
//                buffer.append(scanner.nextLine());
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }
//        return buffer.toString();
//    }
//
//    private void test() {
//        try {
////            InputStream stream = this.getClass().getResourceAsStream("/data/dict.json");
//            File file = areaRes.getFile();
//            String jsonData = this.jsonRead(file);
//
//            JSONObject obj = JSON.parseObject(jsonData);
//            Iterator keys = obj.keySet().iterator();
//
//            while (keys.hasNext()) {
//                String key = (String) keys.next();
//
//                if ("field".equals(key)) {
//                    JSONArray fields = obj.getJSONArray(key);
//                    String values = obj.getString(key);
//                    log.info("values - > {}", values);
//                } else {
//                    String value = (String) obj.get(key);
//                    log.info("value = {}", value);
//                }
//
////                String values = obj.getJSONObject(key).getString("field");
//            }
//            log.info("字典数据已缓存，字典数量：{},字典类型为：{}");
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
//    }
//
//
//    public static void main(String[] args) {
//        try {
//            //转码
//            System.out.println(new sun.misc.BASE64Encoder().encode("中华人民共和国1234567890abcdefghijklmnopqrstuvwxyz".getBytes()));
//            //解码
//            BASE64Decoder decoder = new BASE64Decoder();
////            Base64 base64 = new Base64();
//            byte[] data = decoder.decodeBuffer("H4sIAAAAAAAEAK2UbWvTUBTH3w/2HUpfqWwjuW3Wdq8FYfsI4ossuYsX0yTcJNMxBnNa9+Ae2Kwt2moncyioqEOkrhO/TJPbfgtvbh7Iba1sZTQQcv7/nnPuOb9kdXIik8mqpuKYGKnZuUxWBLm8lJ1icQeV4SLUkBEIQBBL06JAr5QKDfWfmuJi6KxYMBC93Q6p1cn3jrf1KZLxI8NkxaJnFcmaYdqQj2KoIAuqsgO5GiAjinPs4nxxOTCYUy6zeG9j168fezuNAV0xVabfmRVnBCHOWYYqUmSdpjYxO2Kv8q1fafcqf0jtovf0tb/zm3x5HplpEgeZRpwJAD4ed+A9q5APh5F2H9kDMjl9SzoHnEnFsei/2Q/mWG0lSriu23RfSUiHy1APot12p9vp0D947a1kSBqyHYgdLKvRnAu5fA4U8sVSZFlEum4PjnEJQT2odDd4ymRWwxvbIXJgmdtYFB+OBc54OoLIfkUhGTaz0Hkkc3q/59d+kZPz3pNzUj3zWufexYb36rFXPSTbmwNp436FVNw1kGNhpIQHkehaU6JiuoYTCHk+vgSZXeSCKgUkaTot2BaFbokiEmyQOWbyRe0WNdkDjbDVNo7SRzUfOqYbJvYOTvzm3o1ue92vn3bb2/7ndzf5+rIWGvdeUo1UP/Y3D1IGS1YeyPQN1YbLlJERqiFd3OQU01iG2I56B/l0SXnFZnSkY9jVZMvC5rKsG255EeLAMb+wMD8tzRakYkEqFLOhe23qf6CAq4MiCiWKChiBSrPVb26TH8djgCEWRoCRG6ZCEseEAkgMCr69a8QCjMXC2dFIFkQwFgtXRyE3LgqjvhqNBtn/Oh4KxUtiwL8o14bBi5+Xw2B9JAa5kRhwua+AAf8ZvDQHQwwEt3uTE2t/AcduQstqCAAA");
//            InputStream inputStream = new ByteInputStream(data, data.length);
//
//
//            String result = streamToString(inputStream,"UTF-8");
//            System.out.println(result);
////            Object obj = JSON.parse(data);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public static String toHexString(byte[] byteArray) {
//        if (byteArray == null || byteArray.length < 1)
//            throw new IllegalArgumentException("this byteArray must not be null or empty");
//
//        final StringBuilder hexString = new StringBuilder();
//        for (int i = 0; i < byteArray.length; i++) {
//            if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
//                hexString.append("0");
//            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
//        }
//        return hexString.toString().toLowerCase();
//    }
//
//    private static String streamToString(InputStream inputStream, String charset) {
//
//        try {
//            //转换流,将字节流转字符串,并转换编码
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
//            //字符缓冲流
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            //字符串缓冲区
//            StringBuilder stringBuilder = new StringBuilder();
//            //
//            String len = null;
//            //按行读
//            while ((len = bufferedReader.readLine()) != null) {
//                //追加到字符串缓冲区存放
//                stringBuilder.append(len);
//            }
//            //将字符串返回
//            return stringBuilder.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}