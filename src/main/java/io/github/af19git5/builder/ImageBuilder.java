package io.github.af19git5.builder;

import io.github.af19git5.entity.Image;
import io.github.af19git5.entity.Item;
import io.github.af19git5.entity.Text;
import io.github.af19git5.exception.ImageException;
import io.github.af19git5.type.OutputType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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

    private final List<Item> itemList = new ArrayList<>();

    /**
     * @param width 圖片寬
     * @param height 圖片高
     */
    public ImageBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.backgroundColor = Color.WHITE;
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
        this.width = width;
        this.height = height;
        this.backgroundColor = Color.decode(backgroundColorHex);
    }

    /**
     * 加入文字
     *
     * @param text 文字物件
     */
    public ImageBuilder add(Text text) {
        this.itemList.add(text);
        return this;
    }

    /**
     * 加入圖片
     *
     * @param image 圖片物件
     */
    public ImageBuilder add(Image image) {
        this.itemList.add(image);
        return this;
    }

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
     * 建立base64圖檔
     *
     * @param outputType 輸出格式
     * @return base64圖檔
     */
    public String buildBase64(OutputType outputType) throws ImageException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            buildOutputStream(outputType, outputStream);
            byte[] imageBytes = outputStream.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * 建立檔案
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

        for (Item item : this.itemList) {
            if (item instanceof Text) {
                setText(graphics, (Text) item);
            } else if (item instanceof Image) {
                setImage(graphics, (Image) item);
            }
        }
        return graphics;
    }

    private void setText(Graphics2D graphics, Text text) {
        graphics.setColor(text.getColor());
        if (null != text.getFont()) {
            graphics.setFont(text.getFont());
        }

        FontMetrics fontMetrics = graphics.getFontMetrics();
        String[] textStrings = text.getText().split("\n");
        int maxTextWidth = 0;
        for (String textString : textStrings) {
            int textWidth = fontMetrics.stringWidth(textString);
            if (textWidth > maxTextWidth) {
                maxTextWidth = textWidth;
            }
        }

        for (int i = 0; i < textStrings.length; i++) {
            String textString = textStrings[i];
            int x, y;
            int textWidth = fontMetrics.stringWidth(textString);
            int textHeight = fontMetrics.getHeight();
            switch (text.getPositionX()) {
                case LEFT:
                    x = 0;
                    break;
                case RIGHT:
                    x = this.width - maxTextWidth;
                    break;
                case MIDDLE:
                    x = (this.width - textWidth) / 2;
                    break;
                default:
                    x = text.getX();
            }
            switch (text.getPositionY()) {
                case TOP:
                    y = textHeight * i;
                    break;
                case BOTTOM:
                    y = this.height - (textHeight * (textStrings.length - i));
                    break;
                case MIDDLE:
                    y =
                            (this.height - textHeight) / 2
                                    - (textHeight * (textStrings.length - i - 1));
                    break;
                default:
                    y = text.getY() + (textHeight * i);
            }
            graphics.drawString(textString, x, y + graphics.getFont().getSize());
        }
    }

    private void setImage(Graphics2D graphics, Image image) {
        int imageHeight, imageWidth;
        if (image.getOverrideWidth() == -1 || image.getOverrideHeight() == -1) {
            imageHeight = image.getBufferedImage().getHeight();
            imageWidth = image.getBufferedImage().getWidth();
        } else {
            imageHeight = image.getOverrideHeight();
            imageWidth = image.getOverrideWidth();
        }

        int x, y;
        switch (image.getPositionX()) {
            case LEFT:
                x = 0;
                break;
            case RIGHT:
                x = this.width - imageWidth;
                break;
            case MIDDLE:
                x = (this.width - imageWidth) / 2;
                break;
            default:
                x = image.getX();
        }
        switch (image.getPositionY()) {
            case TOP:
                y = 0;
                break;
            case BOTTOM:
                y = this.height - imageHeight;
                break;
            case MIDDLE:
                y = (this.height - imageHeight) / 2;
                break;
            default:
                y = image.getY();
        }

        if (image.getOverrideWidth() == -1 || image.getOverrideHeight() == -1) {
            graphics.drawImage(image.getBufferedImage(), x, y, null);
        } else {
            java.awt.Image resizedImage =
                    image.getBufferedImage()
                            .getScaledInstance(
                                    image.getOverrideWidth(),
                                    image.getOverrideHeight(),
                                    java.awt.Image.SCALE_DEFAULT);
            graphics.drawImage(resizedImage, x, y, null);
        }
    }
}
