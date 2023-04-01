package org.feng.javacv;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;

import java.io.IOException;

public class FaceDetectionAndGrabcut {

    public static void main(String[] args) throws InterruptedException, IOException {

        // Load the OpenCV library
        Loader.load(opencv_imgproc.class);

        // Load the image
        Mat inputImage = opencv_imgcodecs.imread("/Users/wei/Documents/个人资料/冯志伟/IMG_7732.JPG");
        // Mat inputImage = opencv_imgcodecs.imread("/Users/wei/Downloads/202132318494635807.jpg");

        // Create a new Mat object for output image
        // Mat outputImage = new Mat(inputImage.size(), opencv_core.CV_8UC3, new Scalar(255, 255, 255, 0));
        // Mat outputImage = new Mat(inputImage.rows(), inputImage.cols(), inputImage.type(), Scalar.WHITE);

        // Convert the image to grayscale
        // Mat grayImage = new Mat();
        // opencv_imgproc.cvtColor(inputImage, grayImage, opencv_imgproc.COLOR_BGR2GRAY);

        // String classifierName;
        // if (args.length > 0) {
        //     classifierName = args[0];
        // } else {
        //     URL url = new URL("https://raw.github.com/opencv/opencv/master/data/haarcascades/haarcascade_frontalface_alt.xml");
        //     File file = Loader.cacheResource(url);
        //     classifierName = file.getAbsolutePath();
        // }

        // Detect faces in the image
        CascadeClassifier faceDetector = new CascadeClassifier("/Users/wei/Documents/Tools/opencv-4.6.0/data/haarcascades/haarcascade_frontalface_alt.xml");
        RectVector faces = new RectVector();
        faceDetector.detectMultiScale(inputImage, faces);

        // Get the first detected face
        Rect face = faces.get(0);

        Mat outputImage = new Mat(inputImage, face);

        // CanvasFrame canvasFrame = new CanvasFrame("show image");
        // canvasFrame.showImage(new OpenCVFrameConverter.ToMat().convert(mask));
        // canvasFrame.waitKey();

        // Save the output image
        opencv_imgcodecs.imwrite("/Users/wei/Downloads/output.jpg", outputImage);
    }
}



