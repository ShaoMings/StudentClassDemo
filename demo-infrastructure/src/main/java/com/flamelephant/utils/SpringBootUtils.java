package com.flamelephant.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.regex.Pattern;


/**
 * Description TODO
 *
 * @author shaoming
 * @date 2021/7/19 11:20
 * @since 1.0
 **/
@Component
public class SpringBootUtils {


    public static String generateRandomName(int length){
        Random random = new Random();
        String s = RandomStringUtils.randomAlphanumeric(random.nextInt(length) + 1);
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.insert(random.nextInt(s.length()),random.nextInt(9));
        return sb.toString();
    }

    public static Boolean isAllNumber(String s){
        String str = "[0-9]*";
        Pattern pattern = Pattern.compile(str);
        return pattern.matcher(s).matches();
    }


}
