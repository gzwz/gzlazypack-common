package gzlazypack.common.util;
//package lazypack.common.util;
//
//import com.alibaba.simpleimage.ImageRender;
//import com.alibaba.simpleimage.SimpleImageException;
//import com.alibaba.simpleimage.render.*;
//import org.apache.commons.io.IOUtils;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//
///**
// * 图片处理
// */
//public class ImageUtils {
//
//    /**
//     *  压缩图片
//     * @param in  输入图片
//     * @param out 输出图片
//     * @param maxWidth 压缩图片的最大宽度
//     * @param maxHeight 压缩图片的最大高度
//     * @throws FileNotFoundException
//     * @throws SimpleImageException
//     */
//    public static void comparess(File in, File out, int maxWidth, int maxHeight) throws FileNotFoundException, SimpleImageException {
//        ScaleParameter scaleParam = new ScaleParameter(maxWidth, maxHeight);
//
//        FileInputStream inStream = new FileInputStream(in);
//        FileOutputStream outStream = new FileOutputStream(out);
//
//        ImageRender rr = new ReadRender(inStream);
//        ImageRender sr = new ScaleRender(rr, scaleParam);
//
//        WriteRender wr = new WriteRender(sr, outStream);
//
//        wr.render();
//
//        IOUtils.closeQuietly(inStream);         //图片文件输入输出流必须记得关闭
//        IOUtils.closeQuietly(outStream);
//
//        if (wr != null) {
//            wr.dispose();                   //释放simpleImage的内部资源
//        }
//    }
//
//    /**
//     * 压缩图片
//     * @param in  输入图片
//     * @param outPath 图片输出路径
//     * @param maxWidth 压缩图片的最大宽度
//     * @param maxHeight 压缩图片的最大高度
//     * @throws FileNotFoundException
//     * @throws SimpleImageException
//     */
//    public static void comparess(File in, String outPath, int maxWidth, int maxHeight) throws FileNotFoundException, SimpleImageException {
//        File out = new File(outPath);
//        comparess(in, out, maxWidth, maxHeight);
//    }
//
//    /**
//     * 压缩图片
//     * @param inPath  输入图片路径
//     * @param outPath 图片输出路径
//     * @param maxWidth 压缩图片的最大宽度
//     * @param maxHeight 压缩图片的最大高度
//     * @throws FileNotFoundException
//     * @throws SimpleImageException
//     */
//    public static void comparess(String inPath, String outPath, int maxWidth, int maxHeight) throws FileNotFoundException, SimpleImageException {
//        File in =  new File(inPath);
//        comparess(in, outPath, maxWidth, maxHeight);
//    }
//
//    /**
//     * 裁剪图片
//     * @param in 输入图片
//     * @param out 输出图片
//     * @param x X轴开始裁剪的起点
//     * @param y Y轴开始裁剪的起点
//     * @param width 宽度
//     * @param height 高度
//     * @throws FileNotFoundException
//     * @throws SimpleImageException
//     */
//    public static void crop(File in, File out, float x, float y, int width, int height) throws FileNotFoundException, SimpleImageException {
//        CropParameter cp = new CropParameter(x, y, width, height);
//
//        FileInputStream inStream = new FileInputStream(in);
//        FileOutputStream outStream = new FileOutputStream(out);
//
//        ImageRender rr = new ReadRender(inStream);
//        ImageRender sr = new CropRender(rr, cp);
//
//        WriteRender wr = new WriteRender(sr, outStream);
//
//        wr.render();
//
//        IOUtils.closeQuietly(inStream);         //图片文件输入输出流必须记得关闭
//        IOUtils.closeQuietly(outStream);
//
//        if (wr != null) {
//            wr.dispose();                   //释放simpleImage的内部资源
//        }
//    }
//
//    /**
//     * 裁剪图片
//     * @param in 输入图片
//     * @param outPath 输出图片路径
//     * @param x X轴开始裁剪的起点
//     * @param y Y轴开始裁剪的起点
//     * @param width 宽度
//     * @param height 高度
//     * @throws FileNotFoundException
//     * @throws SimpleImageException
//     */
//    public static void crop(File in, String outPath, float x, float y, int width, int height) throws FileNotFoundException, SimpleImageException {
//        File out = new File(outPath);
//        crop(in, out, x, y, width, height);
//    }
//
//    /**
//     * 裁剪图片
//     * @param inPath 输入图片路径
//     * @param outPath 输出图片路径
//     * @param x X轴开始裁剪的起点
//     * @param y Y轴开始裁剪的起点
//     * @param width 宽度
//     * @param height 高度
//     * @throws FileNotFoundException
//     * @throws SimpleImageException
//     */
//    public static void crop(String inPath, String outPath, float x, float y, int width, int height) throws FileNotFoundException, SimpleImageException {
//        File in = new File(inPath);
//        crop(in, outPath, x, y, width, height);
//    }
//
//
//
//}
