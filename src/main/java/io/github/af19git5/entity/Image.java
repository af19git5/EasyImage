package io.github.af19git5.entity;

import io.github.af19git5.exception.ImageException;
import io.github.af19git5.type.PositionX;
import io.github.af19git5.type.PositionY;

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

    private final BufferedImage bufferedImage;

    private int overrideWidth = -1;

    private int overrideHeight = -1;

    /**
     * @param x 放置x軸位置
     * @param y 放置y軸位置
     * @param file 圖片檔案
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(int x, int y, @NonNull File file) throws ImageException {
        this.setX(x);
        this.setY(y);
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param y 放置y軸位置
     * @param file 圖片檔案
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(int x, int y, @NonNull File file, int overrideWidth, int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setX(x);
        this.setY(y);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param y 放置y軸位置
     * @param path 圖片檔案路徑
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(int x, int y, @NonNull String path) throws ImageException {
        this.setX(x);
        this.setY(y);
        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param y 放置y軸位置
     * @param path 圖片檔案路徑
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(int x, int y, @NonNull String path, int overrideWidth, int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setX(x);
        this.setY(y);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param y 放置y軸位置
     * @param inputStream 資料流
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(int x, int y, @NonNull InputStream inputStream) throws ImageException {
        this.setX(x);
        this.setY(y);
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param y 放置y軸位置
     * @param inputStream 資料流
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            int x, int y, @NonNull InputStream inputStream, int overrideWidth, int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setX(x);
        this.setY(y);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param y 放置y軸位置
     * @param file 圖片檔案
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(@NonNull PositionX positionX, int y, @NonNull File file) throws ImageException {
        this.setPositionX(positionX);
        this.setY(y);
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param y 放置y軸位置
     * @param file 圖片檔案
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            @NonNull PositionX positionX,
            int y,
            @NonNull File file,
            int overrideWidth,
            int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setPositionX(positionX);
        this.setY(y);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param y 放置y軸位置
     * @param path 圖片檔案路徑
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(@NonNull PositionX positionX, int y, @NonNull String path) throws ImageException {
        this.setPositionX(positionX);
        this.setY(y);
        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param y 放置y軸位置
     * @param path 圖片檔案路徑
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            @NonNull PositionX positionX,
            int y,
            @NonNull String path,
            int overrideWidth,
            int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setPositionX(positionX);
        this.setY(y);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param y 放置y軸位置
     * @param inputStream 資料流
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(@NonNull PositionX positionX, int y, @NonNull InputStream inputStream)
            throws ImageException {
        this.setPositionX(positionX);
        this.setY(y);
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param y 放置y軸位置
     * @param inputStream 資料流
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            @NonNull PositionX positionX,
            int y,
            @NonNull InputStream inputStream,
            int overrideWidth,
            int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setPositionX(positionX);
        this.setY(y);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param positionY 放置y軸位置
     * @param file 圖片檔案
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(int x, @NonNull PositionY positionY, @NonNull File file) throws ImageException {
        this.setX(x);
        this.setPositionY(positionY);
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param positionY 放置y軸位置
     * @param file 圖片檔案
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            int x,
            @NonNull PositionY positionY,
            @NonNull File file,
            int overrideWidth,
            int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setX(x);
        this.setPositionY(positionY);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param positionY 放置y軸位置
     * @param path 圖片檔案路徑
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(int x, @NonNull PositionY positionY, @NonNull String path) throws ImageException {
        this.setX(x);
        this.setPositionY(positionY);
        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param positionY 放置y軸位置
     * @param path 圖片檔案路徑
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            int x,
            @NonNull PositionY positionY,
            @NonNull String path,
            int overrideWidth,
            int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setX(x);
        this.setPositionY(positionY);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param positionY 放置y軸位置
     * @param inputStream 資料流
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(int x, @NonNull PositionY positionY, @NonNull InputStream inputStream)
            throws ImageException {
        this.setX(x);
        this.setPositionY(positionY);
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param x 放置x軸位置
     * @param positionY 放置y軸位置
     * @param inputStream 資料流
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            int x,
            @NonNull PositionY positionY,
            @NonNull InputStream inputStream,
            int overrideWidth,
            int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setX(x);
        this.setPositionY(positionY);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param positionY 放置y軸位置
     * @param file 圖片檔案
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(@NonNull PositionX positionX, @NonNull PositionY positionY, @NonNull File file)
            throws ImageException {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param positionY 放置y軸位置
     * @param file 圖片檔案
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            @NonNull PositionX positionX,
            @NonNull PositionY positionY,
            @NonNull File file,
            int overrideWidth,
            int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param positionY 放置y軸位置
     * @param path 圖片檔案路徑
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(@NonNull PositionX positionX, @NonNull PositionY positionY, @NonNull String path)
            throws ImageException {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param positionY 放置y軸位置
     * @param path 圖片檔案路徑
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            @NonNull PositionX positionX,
            @NonNull PositionY positionY,
            @NonNull String path,
            int overrideWidth,
            int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param positionY 放置y軸位置
     * @param inputStream 資料流
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            @NonNull PositionX positionX,
            @NonNull PositionY positionY,
            @NonNull InputStream inputStream)
            throws ImageException {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    /**
     * @param positionX 放置x軸位置
     * @param positionY 放置y軸位置
     * @param inputStream 資料流
     * @param overrideWidth 覆寫寬度
     * @param overrideHeight 覆寫高度
     * @throws ImageException 圖檔讀取錯誤
     */
    public Image(
            @NonNull PositionX positionX,
            @NonNull PositionY positionY,
            @NonNull InputStream inputStream,
            int overrideWidth,
            int overrideHeight)
            throws ImageException {
        if (overrideWidth <= 0 || overrideHeight <= 0) {
            throw new ImageException(
                    "overrideWidth and overrideHeight cannot be less than or equal to 0");
        }
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }
}
