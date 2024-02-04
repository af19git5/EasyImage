package io.github.af19git5.entity;

import io.github.af19git5.exception.ImageException;

import lombok.Getter;
import lombok.NonNull;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 插入圖片物件
 *
 * @author Jimmy Kang
 */
@Getter
public class Image extends Item {

    /** 圖片資源 */
    private final BufferedImage bufferedImage;

    public Image(@NonNull File file) throws ImageException {
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    public Image(@NonNull InputStream inputStream) throws ImageException {
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    public static Image.Builder init(@NonNull File file) throws ImageException {
        return new Builder(file);
    }

    public static Image.Builder init(@NonNull InputStream inputStream) throws ImageException {
        return new Builder(inputStream);
    }

    public static class Builder {

        private final Image image;

        public Builder(@NonNull File file) throws ImageException {
            image = new Image(file);
        }

        public Builder(@NonNull InputStream inputStream) throws ImageException {
            image = new Image(inputStream);
        }

        public Builder setWidth(int width) {
            this.image.setWidth(width);
            return this;
        }

        public Builder setHeight(int height) {
            this.image.setHeight(height);
            return this;
        }

        public Image build() {
            return image;
        }
    }
}
