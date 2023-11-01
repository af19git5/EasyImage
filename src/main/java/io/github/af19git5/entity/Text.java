package io.github.af19git5.entity;

import io.github.af19git5.type.PositionX;
import io.github.af19git5.type.PositionY;

import lombok.Getter;
import lombok.NonNull;

import java.awt.*;

/**
 * 插入文字物件
 *
 * @author Jimmy Kang
 */
@Getter
public class Text extends Item {

    private final String text;

    private final Color color;

    private final Font font;

    /**
     * @param x 放置x軸位置
     * @param y 放置y軸位置
     * @param text 文字內容
     * @param color 文字顏色
     */
    public Text(int x, int y, @NonNull String text, @NonNull Color color) {
        this.setX(x);
        this.setY(y);
        this.text = text;
        this.color = color;
        this.font = null;
    }

    /**
     * @param x 放置x軸位置
     * @param y 放置y軸位置
     * @param text 文字內容
     * @param colorHex 文字顏色(16進位色碼)
     */
    public Text(int x, int y, @NonNull String text, @NonNull String colorHex) {
        this.setX(x);
        this.setY(y);
        this.text = text;
        this.color = Color.decode(colorHex);
        this.font = null;
    }

    /**
     * @param x 放置x軸位置
     * @param y 放置y軸位置
     * @param text 文字內容
     * @param color 文字顏色
     * @param font 文字字體
     */
    public Text(int x, int y, @NonNull String text, @NonNull Color color, Font font) {
        this.setX(x);
        this.setY(y);
        this.text = text;
        this.color = color;
        this.font = font;
    }

    /**
     * @param x 放置x軸位置
     * @param y 放置y軸位置
     * @param text 文字內容
     * @param colorHex 文字顏色(16進位色碼)
     * @param font 文字字體
     */
    public Text(int x, int y, @NonNull String text, @NonNull String colorHex, Font font) {
        this.setX(x);
        this.setY(y);
        this.text = text;
        this.color = Color.decode(colorHex);
        this.font = font;
    }

    /**
     * @param positionX 放置x軸位置
     * @param y 放置y軸位置
     * @param text 文字內容
     * @param color 文字顏色
     */
    public Text(@NonNull PositionX positionX, int y, @NonNull String text, @NonNull Color color) {
        this.setPositionX(positionX);
        this.setY(y);
        this.text = text;
        this.color = color;
        this.font = null;
    }

    /**
     * @param positionX 放置x軸位置
     * @param y 放置y軸位置
     * @param text 文字內容
     * @param colorHex 文字顏色(16進位色碼)
     */
    public Text(
            @NonNull PositionX positionX, int y, @NonNull String text, @NonNull String colorHex) {
        this.setPositionX(positionX);
        this.setY(y);
        this.text = text;
        this.color = Color.decode(colorHex);
        this.font = null;
    }

    /**
     * @param positionX 放置x軸位置
     * @param y 放置y軸位置
     * @param text 文字內容
     * @param color 文字顏色
     * @param font 文字字體
     */
    public Text(
            @NonNull PositionX positionX,
            int y,
            @NonNull String text,
            @NonNull Color color,
            Font font) {
        this.setPositionX(positionX);
        this.setY(y);
        this.text = text;
        this.color = color;
        this.font = font;
    }

    /**
     * @param positionX 放置x軸位置
     * @param y 放置y軸位置
     * @param text 文字內容
     * @param colorHex 文字顏色(16進位色碼)
     * @param font 文字字體
     */
    public Text(
            @NonNull PositionX positionX,
            int y,
            @NonNull String text,
            @NonNull String colorHex,
            Font font) {
        this.setPositionX(positionX);
        this.setY(y);
        this.text = text;
        this.color = Color.decode(colorHex);
        this.font = font;
    }

    /**
     * @param x 放置x軸位置
     * @param positionY 放置y軸位置
     * @param text 文字內容
     * @param color 文字顏色
     */
    public Text(int x, @NonNull PositionY positionY, @NonNull String text, @NonNull Color color) {
        this.setX(x);
        this.setPositionY(positionY);
        this.text = text;
        this.color = color;
        this.font = null;
    }

    /**
     * @param x 放置x軸位置
     * @param positionY 放置y軸位置
     * @param text 文字內容
     * @param colorHex 文字顏色(16進位色碼)
     */
    public Text(
            int x, @NonNull PositionY positionY, @NonNull String text, @NonNull String colorHex) {
        this.setX(x);
        this.setPositionY(positionY);
        this.text = text;
        this.color = Color.decode(colorHex);
        this.font = null;
    }

    /**
     * @param x 放置x軸位置
     * @param positionY 放置y軸位置
     * @param text 文字內容
     * @param color 文字顏色
     * @param font 文字字體
     */
    public Text(
            int x,
            @NonNull PositionY positionY,
            @NonNull String text,
            @NonNull Color color,
            Font font) {
        this.setX(x);
        this.setPositionY(positionY);
        this.text = text;
        this.color = color;
        this.font = font;
    }

    /**
     * @param x 放置x軸位置
     * @param positionY 放置y軸位置
     * @param text 文字內容
     * @param colorHex 文字顏色(16進位色碼)
     * @param font 文字字體
     */
    public Text(
            int x,
            @NonNull PositionY positionY,
            @NonNull String text,
            @NonNull String colorHex,
            Font font) {
        this.setX(x);
        this.setPositionY(positionY);
        this.text = text;
        this.color = Color.decode(colorHex);
        this.font = font;
    }

    /**
     * @param positionX 放置x軸位置
     * @param positionY 放置y軸位置
     * @param text 文字內容
     * @param color 文字顏色
     */
    public Text(
            @NonNull PositionX positionX,
            @NonNull PositionY positionY,
            @NonNull String text,
            @NonNull Color color) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        this.text = text;
        this.color = color;
        this.font = null;
    }

    /**
     * @param positionX 放置x軸位置
     * @param positionY 放置y軸位置
     * @param text 文字內容
     * @param colorHex 文字顏色(16進位色碼)
     */
    public Text(
            @NonNull PositionX positionX,
            @NonNull PositionY positionY,
            @NonNull String text,
            @NonNull String colorHex) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        this.text = text;
        this.color = Color.decode(colorHex);
        this.font = null;
    }

    /**
     * @param positionX 放置x軸位置
     * @param positionY 放置y軸位置
     * @param text 文字內容
     * @param color 文字顏色
     * @param font 文字字體
     */
    public Text(
            @NonNull PositionX positionX,
            @NonNull PositionY positionY,
            @NonNull String text,
            @NonNull Color color,
            Font font) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        this.text = text;
        this.color = color;
        this.font = font;
    }

    /**
     * @param positionX 放置x軸位置
     * @param positionY 放置y軸位置
     * @param text 文字內容
     * @param colorHex 文字顏色(16進位色碼)
     * @param font 文字字體
     */
    public Text(
            @NonNull PositionX positionX,
            @NonNull PositionY positionY,
            @NonNull String text,
            @NonNull String colorHex,
            Font font) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        this.text = text;
        this.color = Color.decode(colorHex);
        this.font = font;
    }
}
