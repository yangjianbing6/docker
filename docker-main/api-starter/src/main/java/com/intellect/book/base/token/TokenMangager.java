package com.intellect.book.base.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huijun
 */
public class TokenMangager {

    private static  String secret = "#$sdd2df2dsdfsdfds";

    public  static  String generateToken(Map<String, Object> claims,Date date){

        String tokenStr = Jwts.builder()
                .setClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        return  tokenStr;
    }

    public static Claims getClaimsFromToken(String token) {

        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();


        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }


    public static void main(String[] args) throws ParseException {


        Map<String, Object> claims = new HashMap<>();
        claims.put("name","dog");


        String tokenStr = generateToken(claims,DateUtils.addMinutes(new Date(),30));

        System.out.println(tokenStr);

        Claims claims1= getClaimsFromToken(tokenStr);

        System.out.println(claims1.get("name"));

        System.out.println("KWK:"+secret.toString());
    }

}
