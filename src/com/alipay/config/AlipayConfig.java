package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101100659278";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCKoN5ZJh4dbWU5la6pOmotLW50wK1nnm8pPoTu8FvipjHhYr9pbqC9KUG/KLytGAwfauJYfgYDCB5aJNsDkEUBQcrrxzrkv/UTTEu5sIGg3Ht8IqJyeHb+PLRytBlO+Iusm0BwqRNERby8zvi/xajR/bWJF04I5iURwJI99hmp1dJhWCwobRvfevKbJIrKj4STtsKGzolxHTmF00UOQ7umHZIbCSZ4wNcqde3KOLOaKF+bwp4kr7vi4xOgAUagsKVwOr8cp3NJsCreHvyCsBX8vcNgIL1v/fgbUaK+8nB6fv52EAKmpS5p8DoEE3wlthco5wRLoePsQz+z2pslkDzTAgMBAAECggEAB/OILVbZXVi7+JyUQxKdqm+zqTCwAYR93cC/QTE6I/riW4odbn+w6oimQ7+jas45S8gGqYq4742UqBj7Eu5Advz+FZ38y8gS14OFyGXOWZqr3ofiB2zPbm+u7fFUjkoFQOY6wPuBpmXVmILKk71TnI/PzMgwaqRAtg70lGc8O5h5bfCgilkjkrQ4JHcdDwMVnwDIlTB+LzwKHstPF49fdU5ULOPxC56Vi5sqsFP4WTBhKFkZlIO1KEBuw4MKjcdX1kJEXT6NLw06TDMozMuRap5rINFHEKXIdIoREYPtt/NBhRWA0/1D4xeLQwTFfktngcilcS96HVWHi5UBjmhOuQKBgQDHr01nCs4+uIifPX27Oq2R4KaywpWDWmInM2IIju+VaIwgo7T09f8iqQ6ILjaSMnNVuk1fWmMaeG5NQvbUOaCy+5jmITCZPDjWTbMNloGcSBSWxFn1bp1ZjEeWaJfDfvZ4UJf5+VhRXFWjtqrjpWgK5i3BW2vTsQlzF2t5KWGUjwKBgQCxuXYi09GJvIPw14n3qpG/V/sunn0Ijx86LHrHTPgBJWfvgqBE4ckvazjLUml3EXBd8El1tSrxGXD1xF3ebTLXlPliydKgMR/LPSsZWp6x8jzFaoKeMfIDQu6yiaLZZOQF0RZhPuYJOlF8/22ZuPlF3PePf3ARISqe1o6E18GdfQKBgC4fvf9JLa6rLVOq/nna6fDCNX8hFywKGpX3dnOHoKugRI3dgpT6pX46EpM+KXjHkoCA0hJubGnW25OZHi6TSR1OpFiz3efnUzGdLPi8hR+2Pps8q5LXhB0FHBwP+M49a20LIK+q+s2ASH/SV9LRiCDMXlFFbritMgOVq0uHVXTdAoGALeRhIA8oTXPTci6GHuD5r7otT1V3ne0vOBtiPPKgG9On6g4GCqNvCwKZ8M7AExH6vRceMPnuM8HJDH1/a78w4MBEQYEyFVF6D0YlSe+/iN2vWZ7uSaFGCBeRgaLO3WoTA3mBWO0gA4P+pNNkXsyH+cVcW76hlprE4a0vshfwlBUCgYAP0P02No+0mXCa8MWt8WpJuP8vCYjFgfan45U/tvus/pe3qVB+1ydyJUrd8YDkkabZH6fzOijMmik+fQCp+kTAPEgLJnKazdZYY+jU953yF67XLo80meSP9zWSRHKApjF1jCbYEOJwi9PILTQbq5E0QPVdrb4OAkTdmVRPfORiAQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlTMfWrFRuiiv8TcShWxotNXs8vpTstPrZy/BjkhoCHNnu+NP13QGU1ajU1AlYIjn5VNcNw6npsvcX/S1+sM4CpDhs4cxpjRKDYVik16GQSNTZJvVpK2lHQsbijusG2ANlk6h9afXVV+AkMh2KOaXZbKrCrejgAFIzeeR4DkxG0BfJHJEK4CdDUlly9nGUlSPo6glFMS2AXm9KFfLvKXdkbrpllwDdJhywFlSD1SiTvS2WQhudblOKaFa0++ps4k3lObZ6WQI9qfpHsqhjpt73hjKwYI2z8tmq6owTkW1EeMaVlMS8O5AYTrJWF84EqzsEMr67J7irnt5wtIpfC3xWQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://huangcaihong.free.idcfengye.com/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://huangcaihong.free.idcfengye.com/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

