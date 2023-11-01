package io.github.af19git5.entity;

import io.github.af19git5.type.PositionX;
import io.github.af19git5.type.PositionY;

import lombok.Getter;
import lombok.Setter;

/**
 * 基礎物件
 *
 * @author Jimmy Kang
 */
@Getter
@Setter
public class Item {

    private Integer x = 0;

    private Integer y = 0;

    private PositionX positionX = PositionX.NONE;

    private PositionY positionY = PositionY.NONE;
}
