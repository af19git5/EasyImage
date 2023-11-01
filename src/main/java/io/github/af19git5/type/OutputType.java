package io.github.af19git5.type;

import lombok.Getter;

/**
 * 輸出類型
 *
 * @author Jimmy Kang
 */
@Getter
public enum OutputType {
    JPG("jpg"),

    PNG("png"),
    ;

    private final String type;

    OutputType(String type) {
        this.type = type;
    }
}
