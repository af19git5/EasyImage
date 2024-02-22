package io.github.af19git5.entity;

import io.github.af19git5.utils.ColorUtils;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.awt.*;

/**
 * 插入矩形物件
 *
 * @author Jimmy Kang
 */
@Getter
@Setter
public class Rectangle extends Item {

    /** 顏色 */
    private Color color = Color.BLUE;

    /** 邊線寬度 */
    private Integer strokeWidth = 0;

    /** 邊線顏色 */
    private Color strokeColor = Color.BLACK;

    /** 圓角 */
    private Integer cornerRadius = 0;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Builder init(int width, int height) {
        return new Builder(width, height);
    }

    public static class Builder {

        private final Rectangle rectangle;

        public Builder(int width, int height) {
            this.rectangle = new Rectangle(width, height);
        }

        public Builder setWidth(int width) {
            this.rectangle.setWidth(width);
            return this;
        }

        public Builder setHeight(int height) {
            this.rectangle.setHeight(height);
            return this;
        }

        public Builder setColor(@NonNull Color color) {
            this.rectangle.setColor(color);
            return this;
        }

        public Builder setColor(@NonNull String colorHex) {
            this.rectangle.setColor(ColorUtils.parseArgbColorHexToColor(colorHex));
            return this;
        }

        public Builder setStrokeWidth(int borderWidth) {
            this.rectangle.setStrokeWidth(borderWidth);
            return this;
        }

        public Builder setStrokeColor(@NonNull Color color) {
            this.rectangle.setStrokeColor(color);
            return this;
        }

        public Builder setStrokeColor(@NonNull String colorHex) {
            this.rectangle.setStrokeColor(ColorUtils.parseArgbColorHexToColor(colorHex));
            return this;
        }

        public Builder setCornerRadius(@NonNull int radius) {
            this.rectangle.setCornerRadius(radius);
            return this;
        }

        public Rectangle build() {
            return rectangle;
        }
    }
}
