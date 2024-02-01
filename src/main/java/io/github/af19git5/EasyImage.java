package io.github.af19git5;

import io.github.af19git5.builder.ImageBuilder;

import java.awt.*;

/**
 * EasyImage可用功能及方法
 *
 * @author Jimmy Kang
 */
public class EasyImage {

    /**
     * 初始化
     *
     * @param width 圖片寬
     * @param height 圖片高
     */
    public static ImageBuilder init(int width, int height) {
        return new ImageBuilder(width, height);
    }

    /**
     * 初始化
     *
     * @param width 圖片寬
     * @param height 圖片高
     * @param backgroundColor 圖片背景色
     */
    public static ImageBuilder init(int width, int height, Color backgroundColor) {
        return new ImageBuilder(width, height, backgroundColor);
    }

    /**
     * 初始化
     *
     * @param width 圖片寬
     * @param height 圖片高
     * @param backgroundColorHex 圖片背景色(16進位色碼)
     */
    public static ImageBuilder init(int width, int height, String backgroundColorHex) {
        return new ImageBuilder(width, height, backgroundColorHex);
    }
}
