const url = 'http://feng.freehk.svipss.top'
const swiperList = [
  `${url}/image/IMG_8196.JPG`,
  `${url}/image/IMG_8195.JPG`,
  `${url}/image/IMG_8194.JPG`,
  `${url}/image/IMG_8193.JPG`,
  `${url}/image/IMG_8192.JPG`,
  `${url}/image/IMG_8191.JPG`
];

Component({
  data: {
    current: 3,
    autoplay: true,
    duration: 500,
    interval: 5000,
    swiperList,
    navigation: { type: '', showControls: true },
    // 导航栏
    tabs: [
      {icon: 'app', label: '普通寸照', value: '1'},
      {icon: 'app', label: '学历考试', value: '2'},
      {icon: 'app', label: '公务员', value: '3'},
      {icon: 'app', label: '建筑工程', value: '4'},
      {icon: 'app', label: '医药卫生', value: '5'},
      {icon: 'app', label: '图像采集', value: '6'},
      {icon: 'app', label: ' IT认证', value: '7'}
    ],
    // 单元格
    cells: [],
    cells1: [
      {title: '一寸照', description: '25x35mm ｜ 295x413px | 100k-200k', image: '/pages/image/a-ziyuan97.png'},
      {title: '二寸照', description: '35x49mm ｜ 413x579px | 100k-200k', image: '/pages/image/a-ziyuan97.png'},
      {title: '三寸照', description: '55x84mm ｜ 650x992px | 100k-200k', image: '/pages/image/a-ziyuan97.png'},
      {title: '四寸照', description: '76x100mm ｜ 898x1181px | 50k-200k', image: '/pages/image/a-ziyuan97.png'}
    ],
    cells2: [
      {title: '英语四六级', description: '33x48mm ｜ 390x567px | 20k-200k', image: '/pages/image/a-ziyuan97.png'},
      {title: '全国计算机等级', description: '25x35mm ｜ 295x413px | 50k-200k', image: '/pages/image/a-ziyuan97.png'},
      {title: '全国计算机等级', description: '33x48mm ｜ 144x192px | 50k-200k', image: '/pages/image/a-ziyuan97.png'},
      {title: '成人高考', description: '41x54mm ｜ 480x640px | 25k-35k', image: '/pages/image/a-ziyuan97.png'},
      {title: '教师资格证笔试', description: '25x35mm ｜ 295x413px | 100k-180k', image: '/pages/image/a-ziyuan97.png'},
      {title: '教师资格证面试', description: '50x70mm ｜ 400x600px | 150k-190k', image: '/pages/image/a-ziyuan97.png'},
      {title: '毕业学历照片', description: '26x34mm ｜ 480x640px | 30k-100k', image: '/pages/image/a-ziyuan97.png'},
      {title: '在职研求生考试', description: '33x48mm ｜ 390x567px | 20k-200k', image: '/pages/image/a-ziyuan97.png'}
    ],
    cells3: [
      {title: '省公务员(一寸照)', description: '25x35mm ｜ 295x413px | 50k-100k', image: '/pages/image/a-ziyuan97.png'},
      {title: '省公务员（二寸照）', description: '35x49mm ｜ 413x579px | 15k-20k', image: '/pages/image/a-ziyuan97.png'},
      {title: '国家公务员（一寸照）', description: '25x35mm ｜ 295x413px | 15k-20k', image: '/pages/image/a-ziyuan97.png'},
      {title: '国家公务员（二寸照）', description: '35x49mm ｜ 413x579px | 15k-20k', image: '/pages/image/a-ziyuan97.png'}
    ],
    cells4: [
      {title: '一级建造师', description: '25x35mm ｜ 295x413px | 50k-100k', image: '/pages/image/a-ziyuan97.png'},
      {title: '二级建造师', description: '25x35mm ｜ 295x413px | 50k-100k', image: '/pages/image/a-ziyuan97.png'}
    ],
    cells5: [
      {title: '医师资格', description: '35x45mm ｜ 413x531px | 50k-100k', image: '/pages/image/a-ziyuan97.png'},
      {title: '国家医学考试网', description: '25x35mm ｜ 295x413px | 50k-100k', image: '/pages/image/a-ziyuan97.png'}
    ],
    cells6: [
      {title: '社保卡', description: '26x32mm ｜ 358x441px | 14k-27k', image: '/pages/image/a-ziyuan97.png'},
      {title: '毕业生图像信息采集', description: '41x54mm ｜ 480x640px | 60k-300k', image: '/pages/image/a-ziyuan97.png'}
    ],
    cells7: [
      {title: '青少年人工智能编程', description: '35x45mm ｜ 413x531px | 150k-200k', image: '/pages/image/a-ziyuan97.png'},
      {title: '青少年软件编程等级', description: '35x53mm ｜ 482x730px | 50k-1024k', image: '/pages/image/a-ziyuan97.png'},
      {title: '全国计算机等级', description: '33x48mm ｜ 390x567px | 20k-200k', image: '/pages/image/a-ziyuan97.png'},
      {title: '全国计算机等级', description: '13x18mm ｜ 150x210px | 20k-100k', image: '/pages/image/a-ziyuan97.png'}
    ]
  },
  methods: {
    onShow(options){
      this.setData({
        cells: this.data.cells1
      })
    },
    onTabsChange(event) {
      let type = event.detail.value
      var cells = []
      if(type === '1')
        cells = this.data.cells1
      else if(type === '2')
        cells = this.data.cells2
      else if(type === '3')
        cells = this.data.cells3
      else if(type === '4')
        cells = this.data.cells4
      else if(type === '5')
        cells = this.data.cells5
      else if(type === '6')
        cells = this.data.cells6
      else if(type === '7')
        cells = this.data.cells7
      else
        cells = this.data.cells1
      this.setData({
        cells : cells
      })
    },
    onTabsClick(event) {

    },

    onCellClick(e) {
      let description = e.currentTarget.dataset.description
      let title = e.currentTarget.dataset.title
      wx.navigateTo({
        url: `/pages/detail/detail?description=${description}&title=${title}`,
      });
    }
  }
});
