package com.feng.demo.util

import nu.pattern.OpenCV
import org.opencv.core.*
import org.opencv.highgui.HighGui
import org.opencv.highgui.HighGui.imshow
import org.opencv.highgui.HighGui.waitKey
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgcodecs.Imgcodecs.imwrite
import org.opencv.imgproc.Imgproc
import org.opencv.imgproc.Imgproc.*
import org.opencv.photo.Photo


object WatermarkUtils {

    private const val path = "C:\\Users\\Fengzhiwei\\Pictures\\Screenshots\\111.jpg"

    private const val d = "/Users/wei/Downloads"

    private fun loadImage(imagePath: String?): Mat? {
        return Imgcodecs.imread(imagePath)
    }
    fun saveImage(imageMatrix: Mat?, targetPath: String?) {
        imwrite(targetPath, imageMatrix)
    }
    fun testOpenCV() {
        // 读取图像
        val image = loadImage(path)
        imshow("Original Image", image)
        // 创建输出单通道图像
        val grayImage = image?.apply { Mat(image.rows(), image.cols(), CvType.CV_8SC1) }
        // 进行图像色彩空间转换
        cvtColor(image, grayImage, COLOR_RGB2GRAY);
        imshow("Processed Image", grayImage);
        imwrite("${d}/222.jpg", grayImage);
        waitKey()
    }
    fun removeWatermark(){
        val src = loadImage(path)
        val gray = Mat()
        cvtColor(src, gray, COLOR_BGR2GRAY)
        val mask1 = Mat()
        val threshold = Mat()
        val edges = Mat()
        // 进行掩膜处理
        medianBlur(gray, mask1, 15)
        adaptiveThreshold(
            mask1,
            threshold,
            255.0,
            Imgproc.ADAPTIVE_THRESH_MEAN_C,
            Imgproc.THRESH_BINARY,
            15,
            2.0
        )
        Core.bitwise_not(threshold, threshold)
        // 进行边缘检测
        Imgproc.Canny(threshold, edges, 50.0, 200.0, 3, false)
        // 定位水印区域
        val hierarchy = Mat()
        val contours: List<MatOfPoint> = ArrayList()
        findContours(edges, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE)
        // 标识定位到的水印区域
        for (i in contours.indices) {
            drawContours(src, contours, i, Scalar(0.0, 0.0, 255.0), 2)
        }
        imshow("Contours", src)
        waitKey()
        // 将水印区域覆盖为周围区域的平均像素值
        for (i in contours.indices) {
            val mask: Mat = Mat.zeros(edges.size(), CvType.CV_8UC1)
            drawContours(mask, contours, i, Scalar(255.0, 255.0, 255.0), -1)
            val mean = Mat()
            Core.mean(src, mask)
            if (src != null) {
                for (j in 0 until src.rows()) {
                    for (k in 0 until src.cols()) {
                        val pixel: DoubleArray = src.get(j, k)
                        if (mask[j, k][0] == 255.0) {
                            pixel[0] = mean[0, 0][0]
                            pixel[1] = mean[1, 0][0]
                            pixel[2] = mean[2, 0][0]
                            src.put(j, k, pixel[0], pixel[1], pixel[2])
                        }
                    }
                }
            }
        }
    }
    fun watermark(){
        val image = Imgcodecs.imread(path)
        // 水印区域
        val watermarkRect = Rect(50, 50, 200, 100)
        // 获取水印区域的均值
        val watermarkMean = Core.mean(image.submat(watermarkRect))
        // 替换水印区域的像素值
        for (i in watermarkRect.y until watermarkRect.y + watermarkRect.height) {
            for (j in watermarkRect.x until watermarkRect.x + watermarkRect.width) {
                val pixel = image[i, j]
                // 如果当前像素属于水印区域，将其像素值修改为均值
                if (watermarkRect.contains(Point(j.toDouble(), i.toDouble()))) {
                    pixel[0] = watermarkMean.`val`[0]
                    pixel[1] = watermarkMean.`val`[1]
                    pixel[2] = watermarkMean.`val`[2]
                    image.put(i, j, pixel[0], pixel[1], pixel[2])
                }
            }
        }
        // 显示修改后的图像
        imwrite("${d}/watermark_removed.jpg", image)
    }
    fun remove(){
        val img = Imgcodecs.imread(path)
        // 先灰度化下
        val gray = Mat()
        cvtColor(img, gray, COLOR_BGRA2GRAY)
        // 高斯模糊
        GaussianBlur(gray, gray, Size(3.0, 3.0), 0.0)
        val height = img.height()
        val width = img.width()
        // 图片二值化处理，把[240, 240, 240] ~ [255, 255, 255]以外的颜色变成0
        val thresh = Mat()
        // inRange(img, new Scalar(240, 240, 240), new Scalar(255, 255, 255), thresh);
        // 二值化处理 ,两种方式都可以实现二值化操作
        threshold(gray, thresh, 0.0, 255.0, THRESH_BINARY or THRESH_OTSU)
        // 创建形状和尺寸的结构元素
        val hiMask = Mat()
        val kernel = getStructuringElement(MORPH_RECT, Size(3.0, 3.0))
        // 对Mask膨胀处理, 扩张待修复区域
        dilate(thresh, hiMask, kernel)
        // 图像修复
        val specular = Mat()
        Photo.inpaint(img, hiMask, specular, 5.0, Photo.INPAINT_TELEA)
        // 显示原图
        HighGui.namedWindow("Image", 0)
        HighGui.resizeWindow("Image", width / 2, height / 2)
        imshow("Image", img)
        // 显示修复后的图
        HighGui.namedWindow("newImage", 0)
        HighGui.resizeWindow("newImage", width / 2, height / 2)
        imshow("newImage", specular)

        waitKey()
        // 释放所有的窗体资源
        // HighGui.destroyAllWindows()
    }
}

val pos: (String, String) -> Int = { k, v -> k.length + v.length}

val in1 = pos("a", "b")

val strings: (String) -> Int = { it.length }

val int = strings("ab")
// fun strings(it: String): Int {
//     return it.length
// }

fun gk(fu: () -> String): String = fu()

fun a(a: String, b: String, pos: (String, String) -> Int): Int = pos(a, b)

fun main(){
    gk { "asfasf" }
    // OpenCV .......
    OpenCV.loadShared()
    // WatermarkUtils.testOpenCV()
    // WatermarkUtils.removeWatermark()
    // WatermarkUtils.watermark()
    WatermarkUtils.remove()
}