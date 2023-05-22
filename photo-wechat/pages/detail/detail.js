const url = 'https://www.feng.email'
// const url = 'http://localhost:8080'
const swiperList = [
  `${url}/images/detail/IMG_8205.PNG`,
  `${url}/images/detail/IMG_8204.PNG`,
  `${url}/images/detail/IMG_8206.PNG`
];

Component({
  data: {
    current: 3,
    autoplay: true,
    duration: 500,
    interval: 5000,
    swiperList,
    navigation: { type: '', showControls: true },
    title: '',
    pxSize: '',
    printInch: '',
    imgSize: '',
    loading: false,
    visible: false,
    message: '',
    confirmBtn: { content: '知道了', variant: 'base' },
    generate: false
  },
  methods: {
    onLoad(options){
      let descriptions = options.description.split(' ')
      let pxSize = descriptions[0]
      let printInch = descriptions[2]
      let imgSize = descriptions[4]
      let title = options.title
      this.setData({
        title: title,
        pxSize: pxSize,
        printInch: printInch,
        imgSize: imgSize
      })
    },
    onChooseImage(event) {
      let _this = this
      //打开相册选取
      wx.chooseMedia({
        count: 1,
        mediaType: ['image'],
        sourceType: ['album'],
        success(res) {
          let tempFile = res.tempFiles[0]
          _this.onLoading()
          _this.onVerifyFace(tempFile.tempFilePath)
          // _this.onGenerateImage(tempFile.tempFilePath)
        },
        fail(res) {
          _this.failLog(res)
        }
      })
    },
    onChooseCamera(event) {
      let _this = this
      // 打开相机
      wx.chooseMedia({
        count: 1,
        mediaType: ['image'],
        sourceType: ['camera'],
        camera: 'back',
        success(res) {
          console.log(res)
          let tempFile = res.tempFiles[0]
          _this.onLoading()
          // _this.onVerifyFace(tempFile.tempFilePath)
          _this.onGenerateImage(tempFile.tempFilePath)
        },
        fail(res) {
          _this.failLog(res)
        }
      })
    },
    onGenerateImage(tempFilePath) {
      let _this = this
      let inch = _this.data.printInch.replace('px', '').replace('x', ',')
      wx.uploadFile({
          filePath: tempFilePath,
          formData: {"inch": inch, "color": "red"},
          name: 'imgFile',
          url: `${url}/photo/generate`,
          success(res) {
            _this.onLoading()
            let data = JSON.parse(res.data)
            if(data.code === 2000){
                _this.onDownloadFile(data.result.savePath)
            } else {
                _this.setData({
                    visible: true,
                    message: data.message
                })
            }
          },
          fail(res) {
            _this.failLog(res)
          }
        })
  },
    onVerifyFace(tempFilePath) {
        let _this = this
        wx.uploadFile({
            filePath: tempFilePath,
            name: 'imgFile',
            url: `${url}/photo/verify`,
            success(res) {
                let data = JSON.parse(res.data)
                if(data.code === 2000){
                  _this.onLoading()
                  _this.setData({
                    visible: true,
                    message: "服务器 CPU 使用率过高，无法完成人像分析"
                })
                  // let result = data.result
                  // _this.onGeneratePhoto(result.temp, result.savePath, _this.data.printInch, 'red')
                } else{
                  _this.onLoading()
                  _this.setData({
                      visible: true,
                      message: data.message
                  })
                }
            },
            fail(res) {
              _this.failLog(res)
            }
          })
    },
    onGeneratePhoto(tempFilePath, savePath, inch, color){
        let _this = this
        wx.request({
            url: `${url}/photo/upload?temp=${tempFilePath}&savePath=${savePath}&inch=${inch}&color=${color}`,
            method: 'POST',
            success (res) {
                _this.onLoading()
                if(res.data.code === 2000){
                    _this.onDownloadFile(savePath)
                } else {
                    _this.setData({
                        visible: true,
                        message: res.data.message
                    })
                }
            },
            fail(res) {
              _this.failLog(res)
            }
          })
    },
    onDownloadFile(savePath) {
        let path = savePath.replace('..', '')
        let _this = this
        wx.downloadFile({
            url: `${url}${path}`, //仅为示例，并非真实的资源
            success (res) {
              // 只要服务器有响应数据，就会把响应内容写入文件并进入 success 回调，业务需要自行判断是否下载到了想要的内容
              if(res.statusCode === 200) {
                wx.saveImageToPhotosAlbum({
                    filePath: res.tempFilePath,
                    success(res) {
                        _this.setData({
                            visible: true,
                            message: '下载完成，已保存系统相册'
                        })
                    }
                  })
              } else {
                _this.setData({
                    visible: true,
                    message: '下载失败，请检查网络状态'
                })
              }
            },
            fail(res) {
              _this.failLog(res)
            }
          })
    },
    onLoading() {
      this.setData({
        loading: !this.data.loading
      })
    },
    onVisibleChange(e) {
        this.setData({
          loading: e.detail.visible,
        });
      },
    onClose() {
        this.onLoading()
    },
    closeDialog() {
        this.setData({ visible: false });
    },
    failLog(res){
      console.error(res)
      this.onLoading()
      this.setData({
          visible: true,
          message: res.errMsg
      })
    }
  }
});