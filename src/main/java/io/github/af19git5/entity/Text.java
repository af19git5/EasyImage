package io.github.af19git5.entity;

import io.github.af19git5.type.TextPosition;

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

    private final String text;

    private Color color = Color.BLACK;

    private Color backgroundColor = new Color(0, 0, 0, 0);

    private Font font;

    private TextPosition position = TextPosition.LEFT;

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

        public Builder setColor(@NonNull Color color) {
            this.text.setColor(color);
            return this;
        }

        public Builder setColor(@NonNull String colorHex) {
            this.text.setColor(Color.decode(colorHex));
            return this;
        }

        public Builder setBackgroundColor(@NonNull Color color) {
            this.text.setBackgroundColor(color);
            return this;
        }

        public Builder setBackgroundColor(@NonNull String colorHex) {
            this.text.setBackgroundColor(Color.decode(colorHex));
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

        public Text build() {
            return text;
        }
    }
}
