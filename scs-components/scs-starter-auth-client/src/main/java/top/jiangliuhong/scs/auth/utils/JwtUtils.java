package top.jiangliuhong.scs.auth.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.interfaces.RSAPublicKey;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.alibaba.fastjson.JSONObject;

import top.jiangliuhong.scs.common.utils.RsaUtils;

/**
 * JwtUtils <br/>
 *
 * @author jiangliuhong
 * @date 2020/10/5 11:31 下午
 * @version 1.0.0
 */
public final class JwtUtils {
    private JwtUtils() {}

    private static final String PUBKEY_START = "-----BEGIN PUBLIC KEY-----";
    private static final String PUBKEY_END = "-----END PUBLIC KEY-----";
    private static final String RSA_PUBLIC_KEY = "pubkey.txt";

    /**
     * 通过classpath获取公钥值
     */
    public static RSAPublicKey getPubKeyObj() {
        Resource res = new ClassPathResource(RSA_PUBLIC_KEY);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(res.getInputStream()))) {
            String pubKey = br.lines().collect(Collectors.joining("\n"));
            pubKey = pubKey.substring(PUBKEY_START.length(), pubKey.indexOf(PUBKEY_END));
            return RsaUtils.getPublicKey(pubKey);
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    /**
     * 判断jwt是否过期
     * 
     * @param claims jwt内容
     * @param currTime 当前时间
     * @return true or false
     */
    public static boolean checkExp(JSONObject claims, long currTime) {
        long exp = claims.getLong("exp");
        return exp >= currTime;
    }

    /**
     * 判断jwt是否过期
     * 
     * @param claims jwt内容
     * @return true or false
     */
    public static boolean checkExp(JSONObject claims) {
        return checkExp(claims, System.currentTimeMillis());
    }

}
