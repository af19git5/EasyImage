package io.github.af19git5.utils;

import lombok.NonNull;

import java.awt.*;

/**
 * 顏色處理共用
 *
 * @author Jimmy Kang
 */
public class ColorUtils {

    /**
     * 轉換argb色碼為顏色物件
     *
     * @param argbColorHex argb色碼
     * @return 顏色物件
     */
    public static Color parseArgbColorHexToColor(@NonNull String argbColorHex) {
        return new Color(hexStringToInt(argbColorHex), true);
    }

    /**
     * 將16進位字串轉為16進位數字
     *
     * @param hexString 16進位字串
     * @return 16進位數字
     */
    public static int hexStringToInt(String hexString) {
        return (int) Long.parseLong(hexString.replace("#", ""), 16);
    }
}
