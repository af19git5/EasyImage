# Easy Image

## 關於

簡化製作拼接圖片及插入文字操作邏輯，可以達成簡易需求。

## 如何使用在自己專案中

將以下代碼加入至專案中的pom.xml dependencies.

```xml

<dependency>
    <groupId>io.github.af19git5</groupId>
    <artifactId>easy-image</artifactId>
    <version>1.0.1</version>
</dependency>
```

## 如何使用

### 基礎類別

* **EasyImage** -> Easy Image功能入口。
* **Text** -> 操控插入的文字物件。
* **Image** -> 操控插入的圖片物件。
* **OutputType** -> 輸出格式。
* **PositionX** -> 放置X軸位置。
* **PositionY** -> 放置Y軸位置。

### 範例

```java
// 初始化圖片底框
EasyImage.init(500, 500)
        // 插入圖片(x軸位置, y軸位置, 圖檔資訊)
        .add(
                PositionX.MIDDLE,
                PositionY.MIDDLE,
                Image.init(file)
                        .setWidth(300)
                        .setHeight(300)
                        .build())
        // 插入文字(x軸位置, y軸位置, 文字資訊)
        .add(
                PositionX.MIDDLE,
                PositionY.MIDDLE,
                Text.init("測試文字")
                        .setWidth(300)
                        .setColor(Color.BLACK)
                        .setPosition(TextPosition.MIDDLE)
                        .setFont(font)
                        .setIsAutoScaledFont(false)
                        .build())
        // 寫出檔案(輸出格式, 輸出位置)
        .buildFile(OutputType.PNG, "寫出檔案位置");
```
建議可以去看範例中的方法及物件的建構子，有很多種使用方式，註解內也有說明。

## License

```
Copyright 2023 Jimmy Kang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
