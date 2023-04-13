#coding=UTF-8
import matplotlib.pyplot as plt
import matplotlib.image as mpimg
import paddlehub as hub
from PIL import Image
import numpy as np
import cv2
import sys


# 定义人脸识别和人物识别的paddlehub函数
face_landmark = hub.Module(name="face_landmark_localization")
human_seg = hub.Module(name="deeplabv3p_xception65_humanseg")


# 抠图
def seg_face(img):
    result = human_seg.segmentation(images=[cv2.imread(img)], visualization=True)
    print(result[0]['save_path'])
    test_img_path = result[0]['save_path']
    img = mpimg.imread(test_img_path)
    plt.figure(figsize=(10, 10))
    plt.imshow(img)
    plt.axis('off')
    plt.show()
    return test_img_path


# 裁剪成为1寸大小的图片
def crop_face(pic_path, rate=1.3):
    # 人脸识别
    result = face_landmark.keypoint_detection(paths=[pic_path])
    face = np.array(result[0]['data'][0], dtype=np.int64)

    # 剪裁
    left = face[:, 0].min()
    right = face[:, 0].max()
    w = right - left
    cw = int((right + left) / 2)

    upper = face[:, 1].min()
    lower = face[:, 1].max()

    ch = int((lower + upper) / 2)

    h = int(413 * w / 295)

    box = (cw - rate * w, ch - rate * h, cw + rate * w, ch + rate * h)

    img = Image.open(pic_path)
    img = img.crop(box)
    img = img.resize((295, 413), Image.ANTIALIAS)

    return img


# 改变颜色
def change_color(img, save_path, thresh=100):
    def cut_person(images, num=None):
        if num is None:
            num = [255, 255, 255]
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
    # cut = cut_person(img, num=[255, 255, 255])
    cut = cut_person(img, num=[255, 0, 0])
    # cut = cut_person(img, num=[0, 255, 0])
    # cut = cut_person(img, num=[0, 0, 255])
    return cut


# 生成三种底色的登记照片
def id_photo(pic_path, rate=1.3, thresh=2):
    picture = seg_face(pic_path)
    img = crop_face(picture, rate)
    image = change_color(img, picture, thresh)
    image.save(picture, quality=95)
    print('Hello World!!!')


arg1 = sys.argv[1]
id_photo(arg1, rate=1.3, thresh=50)