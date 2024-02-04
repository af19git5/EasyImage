import io.github.af19git5.EasyImage;
import io.github.af19git5.builder.ImageBuilder;
import io.github.af19git5.entity.Image;
import io.github.af19git5.entity.Text;
import io.github.af19git5.exception.ImageException;
import io.github.af19git5.type.OutputType;
import io.github.af19git5.type.PositionX;
import io.github.af19git5.type.PositionY;
import io.github.af19git5.type.TextPosition;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 單元測試
 *
 * @author Jimmy Kang
 */
public class EasyImageTests {

    private static final String TEST_OUTPUT_PATH = "test-output/";

    /** 測試寫出 */
    @Test
    public void test() throws ImageException, IOException, URISyntaxException {
        URL testImageUrl = EasyImageTests.class.getResource("test.jpg");
        if (null == testImageUrl) {
            throw new IOException("查無測試檔案");
        }
        File testImageFile = new File(testImageUrl.toURI());
        Font font = new Font("Arial", Font.BOLD, 20);
        ImageBuilder imageBuilder =
                EasyImage.init(500, 500, Color.YELLOW)
                        .add(
                                PositionX.MIDDLE,
                                70,
                                Image.init(testImageFile).setWidth(300).setHeight(300).build())
                        .add(
                                PositionX.MIDDLE,
                                PositionY.BOTTOM,
                                Text.init("測試鴿子\n咕咕咕")
                                        .setWidth(300)
                                        .setColor(Color.RED)
                                        .setBackgroundColor(Color.BLUE)
                                        .setPosition(TextPosition.MIDDLE)
                                        .setFont(font)
                                        .setPaddingTop(10)
                                        .setPaddingBottom(30)
                                        .setPaddingLeft(10)
                                        .setPaddingRight(30)
                                        .setIsAutoScaledFont(true)
                                        .build());
        imageBuilder.buildFile(OutputType.PNG, new File(TEST_OUTPUT_PATH + "output.png"));
    }
}
