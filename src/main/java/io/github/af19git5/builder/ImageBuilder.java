package io.github.af19git5.builder;

import io.github.af19git5.entity.*;
import io.github.af19git5.entity.Image;
import io.github.af19git5.entity.Rectangle;
import io.github.af19git5.exception.ImageException;
import io.github.af19git5.type.OutputType;
import io.github.af19git5.type.PositionX;
import io.github.af19git5.type.PositionY;
import io.github.af19git5.utils.ColorUtils;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
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
     * @param backgroundColor 圖片背景色
     */
    public ImageBuilder(int width, int height, Color backgroundColor) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
    }

    /**
     * @param width 圖片寬
     * @param height 圖片高
     * @param backgroundColorHex 圖片背景色(16進位色碼，可包含透明色)
     */
    public ImageBuilder(int width, int height, String backgroundColorHex) {
        this(width, height, ColorUtils.parseArgbColorHexToColor(backgroundColorHex));
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
     * 加入矩形
     *
     * @param x x軸位置
     * @param y y軸位置
     * @param rectangle 矩形物件
     */
    public ImageBuilder add(int x, int y, Rectangle rectangle) {
        this.itemList.add(new ImageItem(x, y, PositionX.NONE, PositionY.NONE, rectangle));
        return this;
    }

    /**
     * 加入矩形
     *
     * @param positionX x軸定位
     * @param y y軸位置
     * @param rectangle 矩形物件
     */
    public ImageBuilder add(PositionX positionX, int y, Rectangle rectangle) {
        this.itemList.add(new ImageItem(0, y, positionX, PositionY.NONE, rectangle));
        return this;
    }

    /**
     * 加入矩形
     *
     * @param x x軸位置
     * @param positionY y軸定位
     * @param rectangle 矩形物件
     */
    public ImageBuilder add(int x, PositionY positionY, Rectangle rectangle) {
        this.itemList.add(new ImageItem(x, 0, PositionX.NONE, positionY, rectangle));
        return this;
    }

    /**
     * 加入矩形
     *
     * @param positionX x軸定位
     * @param positionY y軸定位
     * @param rectangle 矩形物件
     */
    public ImageBuilder add(PositionX positionX, PositionY positionY, Rectangle rectangle) {
        this.itemList.add(new ImageItem(0, 0, positionX, positionY, rectangle));
        return this;
    }

    /**
     * 加入橢圓
     *
     * @param x x軸位置
     * @param y y軸位置
     * @param ellipse 橢圓物件
     */
    public ImageBuilder add(int x, int y, Ellipse ellipse) {
        this.itemList.add(new ImageItem(x, y, PositionX.NONE, PositionY.NONE, ellipse));
        return this;
    }

    /**
     * 加入橢圓
     *
     * @param positionX x軸定位
     * @param y y軸位置
     * @param ellipse 橢圓物件
     */
    public ImageBuilder add(PositionX positionX, int y, Ellipse ellipse) {
        this.itemList.add(new ImageItem(0, y, positionX, PositionY.NONE, ellipse));
        return this;
    }

    /**
     * 加入橢圓
     *
     * @param x x軸位置
     * @param positionY y軸定位
     * @param ellipse 橢圓物件
     */
    public ImageBuilder add(int x, PositionY positionY, Ellipse ellipse) {
        this.itemList.add(new ImageItem(x, 0, PositionX.NONE, positionY, ellipse));
        return this;
    }

    /**
     * 加入橢圓
     *
     * @param positionX x軸定位
     * @param positionY y軸定位
     * @param ellipse 矩形物件
     */
    public ImageBuilder add(PositionX positionX, PositionY positionY, Ellipse ellipse) {
        this.itemList.add(new ImageItem(0, 0, positionX, positionY, ellipse));
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
        // 加入抗鋸齒
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 組出要繪製物件
        List<DrawItem> drawItemList = new ArrayList<>();
        for (ImageItem imageItem : this.itemList) {
            if (imageItem.getItem() instanceof Text) {
                drawItemList.addAll(buildDrawTextItem(graphics, imageItem));
            } else if (imageItem.getItem() instanceof Image) {
                drawItemList.add(buildDrawImageItem(graphics, imageItem));
            } else if (imageItem.getItem() instanceof Rectangle) {
                drawItemList.add(buildDrawRectangleItem(graphics, imageItem));
            } else if (imageItem.getItem() instanceof Ellipse) {
                drawItemList.add(buildDrawEllipseItem(graphics, imageItem));
            }
        }

        // 執行繪製物件
        for (DrawItem drawItem : drawItemList) {
            if (drawItem instanceof DrawTextItem) {
                drawTextItem(graphics, (DrawTextItem) drawItem);
            } else if (drawItem instanceof DrawImageItem) {
                drawImageItem(graphics, (DrawImageItem) drawItem);
            } else if (drawItem instanceof DrawRectangleItem) {
                drawRectangleItem(graphics, (DrawRectangleItem) drawItem);
            } else if (drawItem instanceof DrawEllipseItem) {
                drawEllipseItem(graphics, (DrawEllipseItem) drawItem);
            }
        }
        return graphics;
    }

    /** 建立要繪製的圖片項目 */
    private DrawImageItem buildDrawImageItem(Graphics2D graphics, ImageItem imageItem) {
        Image image = (Image) imageItem.getItem();
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

        DrawImageItem drawImageItem = new DrawImageItem();
        switch (imageItem.getPositionX()) {
            case LEFT:
                drawImageItem.setX(0);
                break;
            case RIGHT:
                drawImageItem.setX(this.width - imageWidth);
                break;
            case MIDDLE:
                drawImageItem.setX((this.width - imageWidth) / 2);
                break;
            default:
                drawImageItem.setX(imageItem.getX());
                break;
        }
        switch (imageItem.getPositionY()) {
            case TOP:
                drawImageItem.setY(0);
                break;
            case BOTTOM:
                drawImageItem.setY(this.height - imageHeight);
                break;
            case MIDDLE:
                drawImageItem.setY((this.height - imageHeight) / 2);
                break;
            default:
                drawImageItem.setY(imageItem.getY());
                break;
        }

        if (image.getHeight() > 0 && image.getWidth() > 0) {
            drawImageItem.setImage(
                    image.getBufferedImage()
                            .getScaledInstance(
                                    imageWidth, imageHeight, java.awt.Image.SCALE_DEFAULT));
        } else {
            drawImageItem.setImage(image.getBufferedImage());
        }
        return drawImageItem;
    }

    /** 繪製圖片項目 */
    private void drawImageItem(Graphics2D graphics, DrawImageItem drawImageItem) {
        graphics.drawImage(
                drawImageItem.getImage(), drawImageItem.getX(), drawImageItem.getY(), null);
    }

    /** 建立要繪製的文字項目 */
    private List<DrawItem> buildDrawTextItem(Graphics2D graphics, ImageItem imageItem) {
        Text text = (Text) imageItem.getItem();

        if (null == text.getFont()) {
            text.setFont(graphics.getFont());
        }

        List<String> textStringList;
        if (text.getIsAutoScaledFont()) {
            // 覆寫字體大小
            textStringList = Arrays.asList(text.getText().split("\n"));
            text.setFont(
                    text.getFont().deriveFont(Float.valueOf(getAutoScaleFontSize(graphics, text))));
        } else {
            // 切分文字陣列
            textStringList = cutText(graphics, text);
        }

        graphics.setFont(text.getFont());
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int textHeight = fontMetrics.getHeight();
        // 取得文字框最長寬度
        int maxTextWidth = 0;
        if (text.getWidth() > 0) {
            maxTextWidth = text.getWidth();
        } else {
            for (String textString : textStringList) {
                maxTextWidth = Math.max(maxTextWidth, fontMetrics.stringWidth(textString));
            }
        }

        List<DrawItem> drawItemList = new ArrayList<>();

        // 繪製背景
        DrawRectangleItem drawRectangleItem =
                buildTextBackground(graphics, imageItem, text, maxTextWidth, textStringList.size());
        drawItemList.add(drawRectangleItem);
        for (int i = 0; i < textStringList.size(); i++) {
            String textString = textStringList.get(i);
            int textWidth = fontMetrics.stringWidth(textString);

            DrawTextItem drawTextItem = new DrawTextItem();
            drawTextItem.setText(textString);
            drawTextItem.setFont(text.getFont());
            drawTextItem.setColor(text.getColor());
            // 定位x軸位置
            switch (text.getPosition()) {
                case LEFT:
                    drawTextItem.setX(drawRectangleItem.getX() + text.getPaddingLeft());
                    break;
                case MIDDLE:
                    drawTextItem.setX(
                            (drawRectangleItem.getX()
                                                    + text.getPaddingLeft()
                                                    + drawRectangleItem.getX()
                                                    + drawRectangleItem.getWidth()
                                                    - text.getPaddingRight())
                                            / 2
                                    - (textWidth / 2));
                    break;
                case RIGHT:
                    // 最後的-10為補上java計算誤差
                    drawTextItem.setX(
                            drawRectangleItem.getX()
                                    + text.getPaddingLeft()
                                    + drawRectangleItem.getX()
                                    + drawRectangleItem.getWidth()
                                    - text.getPaddingRight()
                                    - textWidth
                                    - 10);
                    break;
            }
            // 定位y軸位置
            drawTextItem.setY(drawRectangleItem.getY() + (textHeight * i) + text.getPaddingTop());
            drawItemList.add(drawTextItem);
        }
        return drawItemList;
    }

    /** 繪製文字項目 */
    private void drawTextItem(Graphics2D graphics, DrawTextItem drawTextItem) {
        graphics.setColor(drawTextItem.getColor());
        graphics.setFont(drawTextItem.getFont());
        // Graphics2D畫字串上去並不是用左上角定位，y要多補字體大小才是左上定位點
        graphics.drawString(
                drawTextItem.getText(),
                drawTextItem.getX(),
                drawTextItem.getY() + drawTextItem.getFont().getSize());
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
            while (textWidth
                    >= (text.getWidth() - text.getPaddingLeft() - text.getPaddingRight())) {
                // 將字體條小一號
                minFontSize = graphics.getFont().getSize() - 1;
                graphics.setFont(graphics.getFont().deriveFont(Float.valueOf(minFontSize)));
                textWidth = graphics.getFontMetrics().stringWidth(textString);
            }
        }
        return minFontSize;
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
                // -20為補上計算誤差
                if (textWidth
                        >= text.getWidth() - 20 - text.getPaddingLeft() - text.getPaddingRight()) {
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

    /** 建立要繪製的文字背景 */
    private DrawRectangleItem buildTextBackground(
            Graphics2D graphics, ImageItem imageItem, Text text, int textWidth, int lineCount) {
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int textHeight = fontMetrics.getHeight();
        DrawRectangleItem drawRectangleItem = new DrawRectangleItem();
        drawRectangleItem.setWidth(
                text.getWidth() == 0
                        ? textWidth + text.getPaddingLeft() + text.getPaddingRight()
                        : text.getWidth());
        int rectangleHeight =
                textHeight * lineCount + text.getPaddingTop() + text.getPaddingBottom();
        drawRectangleItem.setHeight(
                text.getHeight() < rectangleHeight ? rectangleHeight : text.getHeight());
        drawRectangleItem.setColor(text.getBackgroundColor());

        // 定位x軸位置
        switch (imageItem.getPositionX()) {
            case LEFT:
                drawRectangleItem.setX(0);
                break;
            case RIGHT:
                drawRectangleItem.setX(this.width - drawRectangleItem.getWidth());
                break;
            case MIDDLE:
                drawRectangleItem.setX((this.width - drawRectangleItem.getWidth()) / 2);
                break;
            default:
                drawRectangleItem.setX(imageItem.getX());
                break;
        }
        // 定位y軸位置
        switch (imageItem.getPositionY()) {
            case TOP:
                drawRectangleItem.setY(0);
                break;
            case BOTTOM:
                drawRectangleItem.setY(this.height - drawRectangleItem.getHeight());
                break;
            case MIDDLE:
                drawRectangleItem.setY((this.height - drawRectangleItem.getHeight()) / 2);
                break;
            default:
                drawRectangleItem.setY(imageItem.getY());
                break;
        }
        return drawRectangleItem;
    }

    /** 建立要繪製的矩形項目 */
    private DrawRectangleItem buildDrawRectangleItem(Graphics2D graphics, ImageItem imageItem) {
        Rectangle rectangle = (Rectangle) imageItem.getItem();
        DrawRectangleItem drawRectangleItem = new DrawRectangleItem();
        drawRectangleItem.setHeight(rectangle.getHeight());
        drawRectangleItem.setWidth(rectangle.getWidth());
        drawRectangleItem.setColor(rectangle.getColor());
        drawRectangleItem.setStrokeWidth(rectangle.getStrokeWidth());
        drawRectangleItem.setStrokeColor(rectangle.getStrokeColor());
        drawRectangleItem.setCornerRadius(rectangle.getCornerRadius());
        switch (imageItem.getPositionX()) {
            case LEFT:
                drawRectangleItem.setX(0);
                break;
            case RIGHT:
                drawRectangleItem.setX(this.width - rectangle.getWidth());
                break;
            case MIDDLE:
                drawRectangleItem.setX((this.width - rectangle.getWidth()) / 2);
                break;
            default:
                drawRectangleItem.setX(imageItem.getX());
                break;
        }
        switch (imageItem.getPositionY()) {
            case TOP:
                drawRectangleItem.setY(0);
                break;
            case BOTTOM:
                drawRectangleItem.setY(this.height - rectangle.getHeight());
                break;
            case MIDDLE:
                drawRectangleItem.setY((this.height - rectangle.getHeight()) / 2);
                break;
            default:
                drawRectangleItem.setY(imageItem.getY());
                break;
        }
        return drawRectangleItem;
    }

    /** 繪製矩形項目 */
    private void drawRectangleItem(Graphics2D graphics, DrawRectangleItem drawRectangleItem) {
        if (drawRectangleItem.getCornerRadius() > 0) {
            // 使用圓角矩形
            if (drawRectangleItem.getStrokeWidth() > 0) {
                Shape shape =
                        new RoundRectangle2D.Float(
                                drawRectangleItem.getX()
                                        + ((float) drawRectangleItem.getStrokeWidth() / 2),
                                drawRectangleItem.getY()
                                        + ((float) drawRectangleItem.getStrokeWidth() / 2),
                                drawRectangleItem.getWidth() - drawRectangleItem.getStrokeWidth(),
                                drawRectangleItem.getHeight() - drawRectangleItem.getStrokeWidth(),
                                drawRectangleItem.getCornerRadius(),
                                drawRectangleItem.getCornerRadius());
                graphics.setColor(drawRectangleItem.getColor());
                graphics.fill(shape);
                Stroke oldStroke = graphics.getStroke();
                graphics.setColor(drawRectangleItem.getStrokeColor());
                graphics.setStroke(new BasicStroke(drawRectangleItem.getStrokeWidth()));
                graphics.draw(shape);
                graphics.setStroke(oldStroke);
            } else {
                graphics.setColor(drawRectangleItem.getColor());
                graphics.fill(
                        new RoundRectangle2D.Float(
                                drawRectangleItem.getX(),
                                drawRectangleItem.getY(),
                                drawRectangleItem.getWidth(),
                                drawRectangleItem.getHeight(),
                                drawRectangleItem.getCornerRadius(),
                                drawRectangleItem.getCornerRadius()));
            }
        } else {
            // 使用矩形
            if (drawRectangleItem.getStrokeWidth() > 0) {
                Shape shape =
                        new Rectangle2D.Float(
                                drawRectangleItem.getX()
                                        + ((float) drawRectangleItem.getStrokeWidth() / 2),
                                drawRectangleItem.getY()
                                        + ((float) drawRectangleItem.getStrokeWidth() / 2),
                                drawRectangleItem.getWidth() - drawRectangleItem.getStrokeWidth(),
                                drawRectangleItem.getHeight() - drawRectangleItem.getStrokeWidth());
                graphics.setColor(drawRectangleItem.getColor());
                graphics.fill(shape);
                Stroke oldStroke = graphics.getStroke();
                graphics.setColor(drawRectangleItem.getStrokeColor());
                graphics.setStroke(new BasicStroke(drawRectangleItem.getStrokeWidth()));
                graphics.draw(shape);
                graphics.setStroke(oldStroke);
            } else {
                graphics.setColor(drawRectangleItem.getColor());
                graphics.fill(
                        new Rectangle2D.Float(
                                drawRectangleItem.getX(),
                                drawRectangleItem.getY(),
                                drawRectangleItem.getWidth(),
                                drawRectangleItem.getHeight()));
            }
        }
    }

    /** 建立要繪製的橢圓項目 */
    private DrawEllipseItem buildDrawEllipseItem(Graphics2D graphics, ImageItem imageItem) {
        Ellipse ellipse = (Ellipse) imageItem.getItem();
        DrawEllipseItem drawEllipseItem = new DrawEllipseItem();
        drawEllipseItem.setHeight(ellipse.getHeight());
        drawEllipseItem.setWidth(ellipse.getWidth());
        drawEllipseItem.setColor(ellipse.getColor());
        drawEllipseItem.setStrokeWidth(ellipse.getStrokeWidth());
        drawEllipseItem.setStrokeColor(ellipse.getStrokeColor());
        switch (imageItem.getPositionX()) {
            case LEFT:
                drawEllipseItem.setX(0);
                break;
            case RIGHT:
                drawEllipseItem.setX(this.width - ellipse.getWidth());
                break;
            case MIDDLE:
                drawEllipseItem.setX((this.width - ellipse.getWidth()) / 2);
                break;
            default:
                drawEllipseItem.setX(imageItem.getX());
                break;
        }
        switch (imageItem.getPositionY()) {
            case TOP:
                drawEllipseItem.setY(0);
                break;
            case BOTTOM:
                drawEllipseItem.setY(this.height - ellipse.getHeight());
                break;
            case MIDDLE:
                drawEllipseItem.setY((this.height - ellipse.getHeight()) / 2);
                break;
            default:
                drawEllipseItem.setY(imageItem.getY());
                break;
        }
        return drawEllipseItem;
    }

    /** 繪製橢圓項目 */
    private void drawEllipseItem(Graphics2D graphics, DrawEllipseItem drawEllipseItem) {
        // 使用圓角矩形
        if (drawEllipseItem.getStrokeWidth() > 0) {
            Shape shape =
                    new Ellipse2D.Float(
                            drawEllipseItem.getX() + ((float) drawEllipseItem.getStrokeWidth() / 2),
                            drawEllipseItem.getY() + ((float) drawEllipseItem.getStrokeWidth() / 2),
                            drawEllipseItem.getWidth() - drawEllipseItem.getStrokeWidth(),
                            drawEllipseItem.getHeight() - drawEllipseItem.getStrokeWidth());
            graphics.setColor(drawEllipseItem.getColor());
            graphics.fill(shape);
            Stroke oldStroke = graphics.getStroke();
            graphics.setColor(drawEllipseItem.getStrokeColor());
            graphics.setStroke(new BasicStroke(drawEllipseItem.getStrokeWidth()));
            graphics.draw(shape);
            graphics.setStroke(oldStroke);
        } else {
            graphics.setColor(drawEllipseItem.getColor());
            graphics.fill(
                    new Ellipse2D.Float(
                            drawEllipseItem.getX(),
                            drawEllipseItem.getY(),
                            drawEllipseItem.getWidth(),
                            drawEllipseItem.getHeight()));
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

    @Getter
    @Setter
    private static class DrawItem {

        private Integer x;

        private Integer y;
    }

    @Getter
    @Setter
    private static class DrawRectangleItem extends DrawItem {

        private Integer width;

        private Integer height;

        private Color color;

        private Integer strokeWidth = 0;

        private Color strokeColor = Color.BLACK;

        private Integer cornerRadius = 0;
    }

    @Getter
    @Setter
    private static class DrawEllipseItem extends DrawItem {

        private Integer width;

        private Integer height;

        private Color color;

        private Integer strokeWidth = 0;

        private Color strokeColor = Color.BLACK;
    }

    @Getter
    @Setter
    private static class DrawTextItem extends DrawItem {

        private String text;

        private Color color;

        private Font font;
    }

    @Getter
    @Setter
    private static class DrawImageItem extends DrawItem {

        private java.awt.Image image;
    }
}
