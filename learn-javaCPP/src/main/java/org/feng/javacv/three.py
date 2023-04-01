import cv2
import numpy as np


def readimg(src_path):
  src = cv2.imread(src_path);

  # 创建一个与输入图像大小相同的图像
  background = np.zeros_like(src, dtype=np.uint8)
  background.fill(0)
  # 将输出图像的所有像素值都设置为红色
  background[:, :, 2] = 255
  #   蓝色
  #   background.fill(255)
  #   background[:, :, 2] = 0

  # 定义红色背景的大小和颜色
  # background_color = (0, 0, 255) # 红色
  #   background_color = (255, 255, 255) # 白色
  #   background_color = (255, 0, 0) # 蓝色

  h, w, ch = src.shape
  mask = np.zeros(src.shape[:2], dtype=np.uint8)
  rect = (53,12,w-100,h-12)
  bgdmodel = np.zeros((1,65),np.float64)
  fgdmodel = np.zeros((1,65),np.float64)

  cv2.grabCut(src,mask,rect,bgdmodel,fgdmodel,1,mode=cv2.GC_INIT_WITH_RECT)
  mask2 = np.where((mask==1) + (mask==3), 255, 0).astype('uint8')
  # object = cv2.bitwise_and(src, src, mask=mask2)
  # cv2.imshow("object", object)

  # 高斯模糊
  se = cv2.getStructuringElement(cv2.MORPH_RECT, (3, 3))
  cv2.dilate(mask2, se, mask2)
  mask2 = cv2.GaussianBlur(mask2, (5, 5), 0)
  # cv2.imshow('mask',mask2)

  # 虚化背景
  background = cv2.GaussianBlur(background, (0, 0), 15)

  # blend image
  result = np.zeros((h, w, ch), dtype=np.uint8)
  for row in range(h):
    for col in range(w):
      w1 = mask2[row, col] / 255.0
      b, g, r = src[row, col]
      b1,g1,r1 = background[row, col]
      b = (1.0-w1) * b1 + b * w1
      g = (1.0-w1) * g1 + g * w1
      r = (1.0-w1) * r1 + r * w1
      result[row, col] = (b, g, r)
  output = cv2.resize(result, (295, 413))
  return output

if __name__ == '__main__':
  src_path = '/Users/wei/Downloads/202132318494635807.jpg'
  # src_path = '/Users/wei/Documents/个人资料/冯志伟/IMG_7732.JPG'
  background_path = '/Users/wei/Downloads/666666.jpg'
  output = readimg(src_path)
  cv2.imwrite(background_path, output)
  cv2.imshow("result", output)
  cv2.waitKey(0)
  cv2.destroyAllWindows()