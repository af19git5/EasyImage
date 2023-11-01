package io.github.af19git5.exception;

/**
 * 圖片處理錯誤
 *
 * @author Jimmy Kang
 */
public class ImageException extends Exception {

    public ImageException(String message) {
        super(message);
    }

    public ImageException(Exception e) {
        super(e);
    }
}
