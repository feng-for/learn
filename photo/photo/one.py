#coding=UTF-8
# import matplotlib.pyplot as plt
import matplotlib.image as mpimg
import paddlehub as hub
from PIL import Image
import numpy as np
import cv2
import sys
import shutil


# 定义人脸识别和人物识别的paddlehub函数
face_landmark = hub.Module(name="face_landmark_localization")
human_seg = hub.Module(name="deeplabv3p_xception65_humanseg")


# 抠图
def seg_face(img):
    result = human_seg.segmentation(images=[cv2.imread(img)], visualization=True)
    print(result[0]['save_path'])
    test_img_path = result[0]['save_path']
    img = mpimg.imread(test_img_path)
    # plt.figure(figsize=(10, 10))
    # plt.imshow(img)
    # plt.axis('off')
    # plt.show()
    return test_img_path


# 裁剪成为1寸大小的图片
def crop_face(pic_path, width, height, rate):
    # 人脸识别
    result = face_landmark.keypoint_detection(paths=[pic_path])
    face = np.array(result[0]['data'][0], dtype=np.int64)
    # 剪裁
    left = face[:, 0].min()
    right = face[:, 0].max()
    w = right - left
    cw = int(left + w / 2)
    
    upper = face[:, 1].min()
    lower = face[:, 1].max()
    h = lower - upper
    ch = int(upper + h / 2)
    h = int(height * w / width)
    # 原始照片的大小
    img = Image.open(pic_path)
    imgW, imgH = img.size
    if imgW <= width and imgH <= height:
        box = (0, 0, imgW, imgH)
    elif imgW > width and imgH > height:
        box = (cw - rate * w, ch - rate * h, cw + rate * w, ch + rate * h)
    elif imgW > width and imgH <= height:
        box = (cw - rate * w, 0, cw + rate * w, imgW)
    elif imgW <= width and imgH > height:
        box = (0, ch - rate * h, imgW, ch + rate * h)
    
    # 输出原始照片大小和制作尺寸
    print(f'imgW: {imgW}, imgH: {imgH}, width: {width}, height: {height}')

    img = img.crop(box)
    img = img.resize((width, height), Image.ANTIALIAS)

    return img


# 改变颜色
def change_color(img, thresh, color=''):
    def cut_person(images, num):
        images = np.array(images).transpose((2, 0, 1))
        person = []
        for i in range(3):
            a = images[i]
            mask = np.array((images[3] < thresh), dtype=np.uint8)
            # mask = cv2.erode(mask,None,iterations=1)
            mask = cv2.dilate(mask, None, iterations=2)
            mask = np.array(mask, dtype=np.bool_)
            a[mask] = num[i]
            person.append(a)

        images = np.array(person).transpose((1, 2, 0))

        im = Image.fromarray(images)
        return im
    # [红, 绿, 蓝]
    if color == 'red':
        cut = cut_person(img, num=[255, 0, 0])
    elif color == 'green':
        cut = cut_person(img, num=[0, 255, 0])
    elif color == 'blue':
        cut = cut_person(img, num=[0, 0, 255])
    else:
        cut = cut_person(img, num=[255, 255, 255])
    return cut


# 生成三种底色的登记照片
def id_photo(pic_path, save_path, color, inch, rate, thresh):
    picture = seg_face(pic_path)
    # 裁剪，需要添加尺寸参数
    fields = inch.split(",")
    img = crop_face(picture, int(fields[0]), int(fields[1]), rate)
    image = change_color(img, thresh, color)
    image.save(save_path, quality=95)
    shutil.rmtree(picture.split('/')[0])


arg1 = sys.argv[1]
arg2 = sys.argv[2]
arg3 = sys.argv[3]
arg4 = sys.argv[4]
id_photo(arg1, arg2, arg3, arg4, rate=1.3, thresh=50)
# id_photo('C:\\Users\\Fengzhiwei\\D\\444.jpeg', 'C:\\Users\\Fengzhiwei\\D\\test.jpg', '', '295,413', rate=1.3, thresh=50)
