package com.sst.framework.jwt;

import com.sst.entity.User;
import com.sst.framework.exception.MyException;
import io.jsonwebtoken.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class JWTUtils {
    public static String token = "token";
    //密钥
    public static String jwt_secret = "aslajfl12151";
    //过期时间（毫秒）
    public static long jwt_expr = 3600*24*1000;

    //生成token
    public static String sign(User user){
        //指定签名的时候，使用签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成签发时间
        long nowMillis = System.currentTimeMillis();
        Date date = new Date(nowMillis);
        //创建payload的私有声明
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("userName",user.getUserName());
        //生成签发人
        String subject = user.getUserName();
        //生成token
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(date)
                .setSubject(subject)
                .signWith(signatureAlgorithm,jwt_secret)
                .setExpiration(new Date(nowMillis+jwt_expr));
        return builder.compact();
    }


    //验证token
    public static boolean verify(String token)  {
        try {
            if(token == null || token.length() == 0){
                return false;
            }
            Jwts.parser().setSigningKey(jwt_secret).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }



    //获取用户信息
    public static User getUser(String token) throws MyException {

        try {
            if(token == null || token.length() == 0){
                throw new MyException("token不能为空");
            }

            if (verify(token)){
                Claims claims = Jwts.parser().setSigningKey(jwt_secret).parseClaimsJws(token).getBody();
                User user = new User();
                user.setId(Integer.parseInt(claims.get("id")+""));
                user.setUserName(claims.get("userName")+"");
                return user;
            }else {
                throw new MyException("超时或不合法的token");
            }
        } catch (MyException e) {
            throw new MyException("超时或不合法的token");
        }

    }


    //main
    public static void main(String[] args) throws MyException {

//        User user = new User();
//        user.setId(5);
//        user.setUserName("sid");
//        long l = System.currentTimeMillis();
//        String token = sign(user);
//        long l1 = System.currentTimeMillis();



        User u = getUser("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlkIjoxLCJ1c2VyTmFtZSI6ImFkbWluIiwiZXhwIjoxNjA5ODQ4MzUxLCJpYXQiOjE2MDk3NjE5NTEsImp0aSI6ImViNDRlZTY2LTA3MDQtNGRkMy1hYWVlLTU2ZGIxZTNlZTRlNSJ9.FdIZBkZSEc2Ww8X-bOwC3RB7ErrCg_OfqQE0nPprHa8");
        long l2 = System.currentTimeMillis();

        System.out.println(u.getId()+"=="+u.getUserName());

    }
}
