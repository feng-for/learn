#coding=UTF-8
import paddlehub as hub
import numpy as np
import sys


# 定义人脸识别和人物识别的paddlehub函数
face_landmark = hub.Module(name="face_landmark_localization")


# 人脸检测
def crop_face(pic_path):
    # 人脸识别
    result = face_landmark.keypoint_detection(paths=[pic_path])
    face = np.array(result[0]['data'][0], dtype=np.int64)
    return face


def id_photo(pic_path):
    crop_face(pic_path)


id_photo(sys.argv[1])
# id_photo('/Users/wei/Documents/个人资料/冯志伟/IMG_5722.JPG')