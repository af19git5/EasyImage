package io.github.af19git5.entity;

import io.github.af19git5.type.TextPosition;
import io.github.af19git5.utils.ColorUtils;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.awt.*;

/**
 * 插入文字物件
 *
 * @author Jimmy Kang
 */
@Getter
@Setter
public class Text extends Item {

    /** 文字內容 */
    private final String text;

    /** 文字顏色 */
    private Color color = Color.BLACK;

    /** 文字背景顏色 */
    private Color backgroundColor = new Color(0, 0, 0, 0);

    /** 字體樣式 */
    private Font font;

    /** 上內間距 */
    private Integer paddingTop = 0;

    /** 左內間距 */
    private Integer paddingLeft = 0;

    /** 右內間距 */
    private Integer paddingRight = 0;

    /** 下內間距 */
    private Integer paddingBottom = 0;

    /** 文字對齊 */
    private TextPosition position = TextPosition.LEFT;

    /** 是否自動縮小字體 */
    private Boolean isAutoScaledFont = false;

    public Text(@NonNull String text) {
        this.text = text;
    }

    public static Builder init(@NonNull String text) {
        return new Builder(text);
    }

    public static class Builder {

        private final Text text;

        public Builder(@NonNull String text) {
            this.text = new Text(text);
        }

        public Builder setWidth(int width) {
            this.text.setWidth(width);
            return this;
        }

        public Builder setHeight(int height) {
            this.text.setHeight(height);
            return this;
        }

        public Builder setColor(@NonNull Color color) {
            this.text.setColor(color);
            return this;
        }

        public Builder setColor(@NonNull String colorHex) {
            this.text.setColor(ColorUtils.parseArgbColorHexToColor(colorHex));
            return this;
        }

        public Builder setBackgroundColor(@NonNull Color color) {
            this.text.setBackgroundColor(color);
            return this;
        }

        public Builder setBackgroundColor(@NonNull String colorHex) {
            this.text.setBackgroundColor(ColorUtils.parseArgbColorHexToColor(colorHex));
            return this;
        }

        public Builder setFont(@NonNull Font font) {
            this.text.setFont(font);
            return this;
        }

        public Builder setPosition(@NonNull TextPosition position) {
            this.text.setPosition(position);
            return this;
        }

        public Builder setIsAutoScaledFont(boolean isAutoScaledFont) {
            this.text.setIsAutoScaledFont(isAutoScaledFont);
            return this;
        }

        public Builder setPadding(int padding) {
            this.text.setPaddingTop(padding);
            this.text.setPaddingLeft(padding);
            this.text.setPaddingRight(padding);
            this.text.setPaddingBottom(padding);
            return this;
        }

        public Builder setPaddingTop(int padding) {
            this.text.setPaddingTop(padding);
            return this;
        }

        public Builder setPaddingLeft(int padding) {
            this.text.setPaddingLeft(padding);
            return this;
        }

        public Builder setPaddingRight(int padding) {
            this.text.setPaddingRight(padding);
            return this;
        }

        public Builder setPaddingBottom(int padding) {
            this.text.setPaddingBottom(padding);
            return this;
        }

        public Text build() {
            return text;
        }
    }
}
