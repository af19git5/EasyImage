package io.github.af19git5.builder;

import io.github.af19git5.entity.Image;
import io.github.af19git5.entity.Item;
import io.github.af19git5.entity.Text;
import io.github.af19git5.exception.ImageException;
import io.github.af19git5.type.OutputType;
import io.github.af19git5.type.PositionX;
import io.github.af19git5.type.PositionY;

import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * 圖片建構器
 *
 * @author Jimmy Kang
 */
public class ImageBuilder {

    private final int width;

    private final int height;

    private final Color backgroundColor;

    private final List<ImageItem> itemList = new ArrayList<>();

    /**
     * @param width 圖片寬
     * @param height 圖片高
     */
    public ImageBuilder(int width, int height) {
        this(width, height, Color.WHITE);
    }

    /**
     * @param width 圖片寬
     * @param height 圖片高
     * @param backgroundColor 圖片背景色(16進位色碼)
     */
    public ImageBuilder(int width, int height, Color backgroundColor) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
    }

    /**
     * @param width 圖片寬
     * @param height 圖片高
     * @param backgroundColorHex 圖片背景色(16進位色碼)
     */
    public ImageBuilder(int width, int height, String backgroundColorHex) {
        this(width, height, Color.decode(backgroundColorHex));
    }

    /**
     * 加入文字
     *
     * @param x x軸位置
     * @param y y軸位置
     * @param text 文字物件
     */
    public ImageBuilder add(int x, int y, Text text) {
        this.itemList.add(new ImageItem(x, y, PositionX.NONE, PositionY.NONE, text));
        return this;
    }

    /**
     * 加入文字
     *
     * @param positionX x軸定位
     * @param y y軸位置
     * @param text 文字物件
     */
    public ImageBuilder add(PositionX positionX, int y, Text text) {
        this.itemList.add(new ImageItem(0, y, positionX, PositionY.NONE, text));
        return this;
    }

    /**
     * 加入文字
     *
     * @param x x軸位置
     * @param positionY y軸定位
     * @param text 文字物件
     */
    public ImageBuilder add(int x, PositionY positionY, Text text) {
        this.itemList.add(new ImageItem(x, 0, PositionX.NONE, positionY, text));
        return this;
    }

    /**
     * 加入文字
     *
     * @param positionX x軸定位
     * @param positionY y軸定位
     * @param text 文字物件
     */
    public ImageBuilder add(PositionX positionX, PositionY positionY, Text text) {
        this.itemList.add(new ImageItem(0, 0, positionX, positionY, text));
        return this;
    }

    /**
     * 加入圖檔
     *
     * @param x x軸位置
     * @param y y軸位置
     * @param image 圖檔物件
     */
    public ImageBuilder add(int x, int y, Image image) {
        this.itemList.add(new ImageItem(x, y, PositionX.NONE, PositionY.NONE, image));
        return this;
    }

    /**
     * 加入圖檔
     *
     * @param positionX x軸定位
     * @param y y軸位置
     * @param image 圖檔物件
     */
    public ImageBuilder add(PositionX positionX, int y, Image image) {
        this.itemList.add(new ImageItem(0, y, positionX, PositionY.NONE, image));
        return this;
    }

    /**
     * 加入圖檔
     *
     * @param x x軸位置
     * @param positionY y軸定位
     * @param image 圖檔物件
     */
    public ImageBuilder add(int x, PositionY positionY, Image image) {
        this.itemList.add(new ImageItem(x, 0, PositionX.NONE, positionY, image));
        return this;
    }

    /**
     * 加入圖檔
     *
     * @param positionX x軸定位
     * @param positionY y軸定位
     * @param image 圖檔物件
     */
    public ImageBuilder add(PositionX positionX, PositionY positionY, Image image) {
        this.itemList.add(new ImageItem(0, 0, positionX, positionY, image));
        return this;
    }

    /**
     * 建立至輸出流
     *
     * @param outputType 輸出類別
     * @param outputStream 輸出流
     */
    public void buildOutputStream(OutputType outputType, OutputStream outputStream)
            throws ImageException {
        BufferedImage bufferedImage =
                new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = buildGraphics2D(bufferedImage);
        try {
            ImageIO.write(bufferedImage, outputType.getType(), outputStream);
        } catch (IOException e) {
            throw new ImageException(e);
        } finally {
            graphics.dispose();
        }
    }

    /**
     * 建立byte陣列
     *
     * @param outputType 輸出格式
     * @return base64圖檔
     */
    public byte[] buildBytes(OutputType outputType) throws ImageException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            buildOutputStream(outputType, outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * 建立base64圖檔
     *
     * @param outputType 輸出格式
     * @return base64圖檔
     */
    public String buildBase64(OutputType outputType) throws ImageException {
        return Base64.getEncoder().encodeToString(buildBytes(outputType));
    }

    /**
     * 建立至檔案
     *
     * @param outputType 輸出格式
     * @param file 輸出檔案位置
     */
    public void buildFile(OutputType outputType, File file) throws ImageException {
        BufferedImage bufferedImage =
                new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = buildGraphics2D(bufferedImage);
        try {
            ImageIO.write(bufferedImage, outputType.getType(), file);
        } catch (IOException e) {
            throw new ImageException(e);
        } finally {
            graphics.dispose();
        }
    }

    private Graphics2D buildGraphics2D(BufferedImage bufferedImage) {
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(this.backgroundColor);
        graphics.fillRect(0, 0, this.width, this.height);

        for (ImageItem imageItem : this.itemList) {
            if (imageItem.getItem() instanceof Text) {
                setText(
                        graphics,
                        imageItem.getX(),
                        imageItem.getY(),
                        imageItem.getPositionX(),
                        imageItem.getPositionY(),
                        (Text) imageItem.getItem());
            } else if (imageItem.getItem() instanceof Image) {
                setImage(
                        graphics,
                        imageItem.getX(),
                        imageItem.getY(),
                        imageItem.getPositionX(),
                        imageItem.getPositionY(),
                        (Image) imageItem.getItem());
            }
        }
        return graphics;
    }

    /** 設定文字背景 */
    private void setTextBackground(
            Graphics2D graphics,
            int x,
            int y,
            PositionX positionX,
            PositionY positionY,
            int width,
            List<String> textStringList,
            Color backgroundColor) {
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int textHeight = fontMetrics.getHeight();

        // 定位x軸位置
        switch (positionX) {
            case LEFT:
                x = 0;
                break;
            case RIGHT:
                x = this.width - width;
                break;
            case MIDDLE:
                x = (this.width - width) / 2;
                break;
        }
        // 定位y軸位置
        switch (positionY) {
            case TOP:
                y = 0;
                break;
            case BOTTOM:
                y = this.height - (textHeight * (textStringList.size()));
                break;
            case MIDDLE:
                y = (this.height - textHeight) / 2 - (textHeight * (textStringList.size() - 1));
                break;
        }

        // 繪製背景
        graphics.setColor(backgroundColor);
        graphics.fillRect(x, y, width, textHeight * textStringList.size());
    }

    /**
     * 將過長的文字斷行
     *
     * @return 整理後的文字陣列
     */
    private List<String> cutText(Graphics2D graphics, Text text) {
        String[] textStrings = text.getText().split("\n");
        if (text.getWidth() <= 0) {
            return Arrays.asList(textStrings);
        }

        if (null != text.getFont()) {
            graphics.setFont(text.getFont());
        }

        FontMetrics fontMetrics = graphics.getFontMetrics();
        List<String> cutTextList = new ArrayList<>();
        for (String textString : textStrings) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : textString.toCharArray()) {
                int textWidth = fontMetrics.stringWidth(stringBuilder.toString());
                if (textWidth >= text.getWidth() - 15) {
                    // 超過長度的話進行斷行
                    cutTextList.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(c);
            }
            cutTextList.add(stringBuilder.toString());
        }
        return cutTextList;
    }

    /**
     * 取得自動調整後字體大小
     *
     * @return 調整後字體大小
     */
    private int getAutoScaleFontSize(Graphics2D graphics, Text text) {
        if (text.getWidth() <= 0) {
            return text.getFont().getSize();
        }

        if (null != text.getFont()) {
            graphics.setFont(text.getFont());
        }

        String[] textStrings = text.getText().split("\n");
        int minFontSize = graphics.getFont().getSize();
        for (String textString : textStrings) {
            int textWidth = graphics.getFontMetrics().stringWidth(textString);
            while (textWidth >= text.getWidth()) {
                // 將字體條小一號
                minFontSize = graphics.getFont().getSize() - 1;
                graphics.setFont(graphics.getFont().deriveFont(Float.valueOf(minFontSize)));
                textWidth = graphics.getFontMetrics().stringWidth(textString);
            }
        }
        return minFontSize;
    }

    /** 設定文字 */
    private void setText(
            Graphics2D graphics,
            int x,
            int y,
            PositionX positionX,
            PositionY positionY,
            Text text) {
        if (null != text.getFont()) {
            graphics.setFont(text.getFont());
        }

        List<String> textStringList;
        if (text.getIsAutoScaledFont()) {
            textStringList = Arrays.asList(text.getText().split("\n"));
            graphics.setFont(
                    graphics.getFont()
                            .deriveFont(Float.valueOf(getAutoScaleFontSize(graphics, text))));
        } else {
            textStringList = cutText(graphics, text);
        }

        FontMetrics fontMetrics = graphics.getFontMetrics();
        int textHeight = fontMetrics.getHeight();
        // 取得文字框寬度
        int width = 0;
        if (text.getWidth() > 0) {
            width = text.getWidth();
        } else {
            for (String textString : textStringList) {
                int textWidth = fontMetrics.stringWidth(textString);
                if (textWidth > width) {
                    width = textWidth;
                }
            }
        }

        // 繪製背景
        setTextBackground(
                graphics,
                x,
                y,
                positionX,
                positionY,
                width,
                textStringList,
                text.getBackgroundColor());

        // 繪製文字
        graphics.setColor(text.getColor());
        for (int i = 0; i < textStringList.size(); i++) {
            String textString = textStringList.get(i);
            int textWidth = fontMetrics.stringWidth(textString);

            // 定位x軸位置
            switch (positionX) {
                case LEFT:
                    x = 0;
                    break;
                case RIGHT:
                    x = this.width - width;
                    break;
                case MIDDLE:
                    x = (this.width - width) / 2;
                    break;
            }

            // 定位y軸位置
            switch (positionY) {
                case TOP:
                    y = textHeight * i;
                    break;
                case BOTTOM:
                    y = this.height - (textHeight * (textStringList.size() - i));
                    break;
                case MIDDLE:
                    y =
                            (this.height - textHeight) / 2
                                    - (textHeight * (textStringList.size() - i - 1));
                    break;
                default:
                    y = y + (i == 0 ? 0 : textHeight);
            }

            switch (text.getPosition()) {
                case LEFT:
                    graphics.drawString(textString, x, y + graphics.getFont().getSize());
                    break;
                case MIDDLE:
                    graphics.drawString(
                            textString,
                            x + ((width - textWidth) / 2),
                            y + graphics.getFont().getSize());
                    break;
                case RIGHT:
                    graphics.drawString(
                            textString, x + width - textWidth, y + graphics.getFont().getSize());
                    break;
            }
        }
    }

    private void setImage(
            Graphics2D graphics,
            int x,
            int y,
            PositionX positionX,
            PositionY positionY,
            Image image) {
        int imageWidth, imageHeight;

        if (image.getWidth() > 0) {
            imageWidth = image.getWidth();
        } else {
            imageWidth = image.getBufferedImage().getWidth();
        }

        if (image.getHeight() > 0) {
            imageHeight = image.getHeight();
        } else {
            imageHeight = image.getBufferedImage().getHeight();
        }

        switch (positionX) {
            case LEFT:
                x = 0;
                break;
            case RIGHT:
                x = this.width - imageWidth;
                break;
            case MIDDLE:
                x = (this.width - imageWidth) / 2;
                break;
        }

        switch (positionY) {
            case TOP:
                y = 0;
                break;
            case BOTTOM:
                y = this.height - imageHeight;
                break;
            case MIDDLE:
                y = (this.height - imageHeight) / 2;
                break;
        }

        if (image.getHeight() > 0 && image.getWidth() > 0) {
            java.awt.Image resizedImage =
                    image.getBufferedImage()
                            .getScaledInstance(
                                    imageWidth, imageHeight, java.awt.Image.SCALE_DEFAULT);
            graphics.drawImage(resizedImage, x, y, null);
        } else {
            graphics.drawImage(image.getBufferedImage(), x, y, null);
        }
    }

    @Getter
    private static class ImageItem {

        private final int x;

        private final int y;

        private final PositionX positionX;

        private final PositionY positionY;

        private final Item item;

        public ImageItem(int x, int y, PositionX positionX, PositionY positionY, Item item) {
            this.x = x;
            this.y = y;
            this.positionX = positionX;
            this.positionY = positionY;
            this.item = item;
        }
    }
}
